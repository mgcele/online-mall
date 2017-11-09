package com.online.mall.test.listener;

/**
 * @author mgcele
 * @since 1.0.0
 */
class DemoListener1 implements DemoListener{
    @Override
    public void handleEvent(DemoEvent dm) {
        System.out.println("Inside listener1...");
        dm.say();//回调
    }
}
