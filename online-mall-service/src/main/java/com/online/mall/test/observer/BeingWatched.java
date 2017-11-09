package com.online.mall.test.observer;

import java.util.Observable;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class BeingWatched extends Observable {
    
    void counter(int period) {
        for (; period >= 0; period--) {
            setChanged();
            notifyObservers(new Integer(period));
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                System.out.println("Sleep interrupeted");
            }
        }
    }
    
}
