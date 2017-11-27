package com.online.mall.framework.identifier;

import com.online.mall.framework.identifier.IdentifierGenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
 * 系统内序列号生成器
 * 一个MaxValue以内，获取系统内不重复序号的方式如下
 * <p>
 * Create...
 * Object object = new Object();
 * SimpleSerialIdGenerator idgenerator = new SimpleSerialIdGenerator(maxValue);
 * Thread 1...
 * Long s1 = idgenerator.getId(object);
 * Thread 2...
 * Long s2 = idgenerator.getId(object);
 * <p>
 * 可以期待的是，在确保递增maxValue以内的发生,s1 != s2
 *
 * @author mgcele
 * @since 1.0.0
 */
public class SimpleSerialIdGenerator implements IdentifierGenerator<Long> {
    
    private long maxValue;
    
    private Object seed = new Object();
    
    private final Map<Object, AtomicLong> valueMap = new HashMap<>();
    
    public SimpleSerialIdGenerator(long maxValue) {
        this.maxValue = maxValue;
    }
    
    public long getMaxValue() {
        return this.maxValue;
    }
    
    public void clear() {
        synchronized(valueMap) {
            AtomicLong value = valueMap.get(seed);
            if (value != null || value.get() != 0) {
                valueMap.put(seed, new AtomicLong(0));
            }
        }
    }
    
    public  void clearAll(){
        synchronized(valueMap){
            valueMap.clear();
        }
    }
    
    private Long getSerialId() {
        AtomicLong value = valueMap.computeIfAbsent(seed, k -> new AtomicLong(0L));
        if (value.addAndGet(1L) > maxValue) {
            value.set(0L);
        }
        return value.get();
    }
    
    @Override
    public Long generate() {
        return getSerialId();
    }
}
