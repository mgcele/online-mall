package com.online.mall.exception.base;

/**
 * @author mgcele
 * @since 1.0.0
 */
public interface IdentifierGenerator<T> {
    
    T generate();
    
}
