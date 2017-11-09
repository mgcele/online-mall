package com.online.mall.test.observer;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class MainTest {
    
    public static void main(String[] args) {
        BeingWatched beingWatched = new BeingWatched();
        Watcher watcher = new Watcher();
        beingWatched.addObserver(watcher);
        beingWatched.counter(10);
    }
    
}
