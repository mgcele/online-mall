package com.online.mall.test.thread;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class Demo {
    
    private static final Object TEST = new Object();
    
    private int i = 0;
    
    private static Demo demo;
    
    public static Demo getInstance(int a){
        if (demo != null){
            return demo;
        } else {
//            try {
//                System.out.println("3..." + Thread.currentThread().getName());
//                Thread.sleep(1000);
//                System.out.println("2..." + Thread.currentThread().getName());
//                Thread.sleep(1000);
//                System.out.println("1..." + Thread.currentThread().getName());
//                Thread.sleep(1000);
//                System.out.println("go..." + Thread.currentThread().getName());
//            } catch (InterruptedException e) {
//                System.out.print("111111111111111111");
//            }
            synchronized(TEST){
                demo = new Demo(a);
            }
            return demo;
        }
    }
    
    private Demo(int a){
        System.out.println("init..." + Thread.currentThread().getName());
        i = a;
    }
    
    public int getI(){
        return i;
    }
    

}
