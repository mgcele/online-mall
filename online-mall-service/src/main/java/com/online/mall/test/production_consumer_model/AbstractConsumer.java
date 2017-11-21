package com.online.mall.test.production_consumer_model;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author mgcele
 * @since 1.0.0
 */
public abstract class AbstractConsumer implements Consumer, Runnable{
    
    private Logger logger = LoggerFactory.getLogger(AbstractConsumer.class);
    
    @Override
    public void run() {
        while (true) {
            try {
                consume();
            } catch (InterruptedException e) {
                logger.info("", e);
                break;
            }
        }
    }
}
