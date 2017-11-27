package com.online.mall.test.thread;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class MainTest {
    
    public static void main(String[] args) {
        Thread t1 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 2; i++) {
                    System.out.println(Demo.getInstance(1).getI() + "..." + Thread.currentThread().getName());
                }
            }
        }, "test1");
        
        Thread t2 = new Thread(new Runnable() {
            @Override
            public void run() {
                for(int i = 0; i < 2; i++) {
                    System.out.println(Demo.getInstance(2).getI() + "..." + Thread.currentThread().getName());
                }
            }
        }, "test2");
        
        t1.start();
        t2.start();
    
    }
    
}
