package com.online.mall.test.observer;

import java.util.Observable;
import java.util.Observer;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class Watcher implements Observer {
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("Update() called, count is " + ((Integer) arg).intValue());
    }
    
}
