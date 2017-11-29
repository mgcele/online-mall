package com.online.mall.framework.identifier;

import java.security.SecureRandom;
import java.util.Date;

/**
 * 自定义 ID 生成器 ID 生成规则: ID长达 64 bits
 * <p>
 * | 41 bits: Timestamp (毫秒) | 3 bits: 区域（机房或业务种类） |10 bits: 机器编号 | 10 bits: 序列号 |
 * <p>
 * 单一系统内，ID生成器支持：
 * 1. 最多7个区域或业务代号
 * 2. 最多1023台同角色服务器
 * 3. 最快可生成ID 1023/ms=102w/s
 *
 * @author mgcele
 * @since 1.0.0
 */
public class SnowflakeIDGenerator implements IdentifierGenerator<Long>, IdentifierAnalyzer<Long, SnowflakeIDElement> {
    
    private final Long workerId;
    private final Long regionId;
    
    // 基准时间
    private long twepoch = 1288834974657L; // Thu, 04 Nov 2010 01:42:54 GMT
    // 区域标志位数
    private final static long REGION_ID_BITS = 3L;
    // 机器标识位数
    private final static long WORKER_ID_BITS = 10L;
    // 序列号识位数
    private final static long SEQUENCE_BITS = 10L;
    // 区域标志ID最大值
    private final static long MAX_REGION_ID = ~(-1L << REGION_ID_BITS);
    // 机器ID最大值
    private final static long maxWorkerId = ~(-1L << WORKER_ID_BITS);
    // 序列号ID最大值
    private final static long SEQUENCE_MASK = ~(-1L << SEQUENCE_BITS);
    // 机器ID偏左移10位
    private final static long WORKER_ID_SHIFT = SEQUENCE_BITS;
    // 业务ID偏左移20位
    private final static long REGION_ID_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS;
    // 时间毫秒左移23位
    private final static long TIMESTAMP_LEFT_SHIFT = SEQUENCE_BITS + WORKER_ID_BITS + REGION_ID_BITS;
    
    private static long lastTimestamp = -1L;
    private long sequence = 0L;
    
    public SnowflakeIDGenerator(long workerId, long regionId) {
        // 如果超出范围就抛出异常
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        if (regionId > MAX_REGION_ID || regionId < 0) {
            throw new IllegalArgumentException(String.format("region Id can't be greater than %d or less than 0", MAX_REGION_ID));
        }
        this.workerId = workerId;
        this.regionId = regionId;
    }
    
    public SnowflakeIDGenerator(long workerId) {
        // 如果超出范围就抛出异常
        if (workerId > maxWorkerId || workerId < 0) {
            throw new IllegalArgumentException(String.format("worker Id can't be greater than %d or less than 0", maxWorkerId));
        }
        this.workerId = workerId;
        this.regionId = 0L;
    }
    
    @Override
    public Long generate() {
        return this.nextId(false, 0);
    }
    
    /**
     * 实际产生代码的方法，使用锁来保证多线程状态下的递增性
     */
    private synchronized long nextId(boolean isPadding, long busId) {
        long timestamp = timeGen();
        long paddingnum = regionId;
        if (isPadding) {
            paddingnum = busId;
        }
        if (timestamp < lastTimestamp) {
            try {
                throw new Exception("Clock moved backwards.  Refusing to generate id for " + (lastTimestamp - timestamp) + " milliseconds");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        // 如果上次生成时间和当前时间相同,在同一毫秒内
        if (lastTimestamp == timestamp) {
            // sequence自增，因为sequence只有10bit，所以和sequenceMask相与一下，去掉高位
            sequence = (sequence + 1) & SEQUENCE_MASK;
            // 判断是否溢出,也就是每毫秒内超过1024，当为1024时，与sequenceMask相与，sequence就等于0
            if (sequence == 0) {
                // 自旋等待到下一毫秒
                timestamp = tailNextMillis(lastTimestamp);
            }
        } else {
            // 如果和上次生成时间不同,重置sequence，就是下一毫秒开始，sequence计数重新从0开始累加,
            // 为了保证尾数随机性更大一些,最后两位设置随机数，否则业务量小的情况下绝大多数ID的尾数都为0
            sequence = new SecureRandom().nextInt(10);
        }
        lastTimestamp = timestamp;
        return ((timestamp - twepoch) << TIMESTAMP_LEFT_SHIFT) | (paddingnum << REGION_ID_SHIFT) | (workerId << WORKER_ID_SHIFT) | sequence;
    }
    
    // 防止产生的时间比之前的时间还要小（由于NTP回拨等问题）,保持增量的趋势.
    private long tailNextMillis(final long lastTimestamp) {
        long timestamp = this.timeGen();
        while (timestamp <= lastTimestamp) {
            timestamp = this.timeGen();
        }
        return timestamp;
    }
    
    // 获取当前的时间戳
    protected long timeGen() {
        return System.currentTimeMillis();
    }
    
    public Long getWorkerId() {
        return workerId;
    }
    
    public Long getRegionId() {
        return regionId;
    }
    
    @Override
    public SnowflakeIDElement analyze(Long id) {
        if (id == null) {
            return null;
        }
        SnowflakeIDElement element = new SnowflakeIDElement(id);
        //时间毫秒
        element.setDate(new Date((id >> TIMESTAMP_LEFT_SHIFT) + twepoch));
        //区域号
        element.setRegionId((id ^ (id >> TIMESTAMP_LEFT_SHIFT << TIMESTAMP_LEFT_SHIFT)) >> REGION_ID_SHIFT);
        //机器ID
        element.setWorkerId(
                (id ^ (id >> TIMESTAMP_LEFT_SHIFT << TIMESTAMP_LEFT_SHIFT) ^ ((id ^ (id >> TIMESTAMP_LEFT_SHIFT << TIMESTAMP_LEFT_SHIFT)) >> REGION_ID_SHIFT
                        << REGION_ID_SHIFT)) >> WORKER_ID_SHIFT);
        return element;
    }
    
}
