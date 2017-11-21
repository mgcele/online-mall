package com.online.mall.test.production_consumer_model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mgcele
 * @since 1.0.0
 */
public abstract class AbstractProducer implements Producer,Runnable{
    
    private Logger logger = LoggerFactory.getLogger(AbstractProducer.class);
    
    @Override
    public void run() {
        while (true) {
            try {
                produce();
            } catch (InterruptedException e) {
                logger.info("", e);
                break;
            }
        }
    }
}
