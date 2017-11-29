package com.online.mall.framework.identifier;

/**
 * 流水号解析器接口
 * @author mgcele
 * @since 1.0.0
 */
public interface IdentifierAnalyzer<T,E> {
    /**
     * 分析一个流水号
     * @return 流水号组成元素
     */
    public E analyze(T t);
}
