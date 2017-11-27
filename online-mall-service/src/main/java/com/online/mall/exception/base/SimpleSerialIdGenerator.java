package com.online.mall.exception.base;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

/**
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
    
    private Long getSerialId() {
        //AtomicLong value = null
        //synchronized(valueMap) {
        //value = valueMap.get(seed);
        //if (value == null){
        //    value = new AtomicLong(0L);
        //    valueMap.put(seed, value);
        //}
        //}
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
