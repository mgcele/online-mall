package com.online.mall.test.production_consumer_model;

/**
 * @author mgcele
 * @since 1.0.0
 */
public interface Model {

    Runnable newRunnableConsumer();
    
    Runnable newRunnableProducer();

}
