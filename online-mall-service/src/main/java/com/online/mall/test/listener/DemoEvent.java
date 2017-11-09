package com.online.mall.test.listener;

import java.util.EventObject;

/**
 * @author mgcele
 * @since 1.0.0
 */
class DemoEvent extends EventObject{
    /**
     * Constructs a prototypical Event.
     *
     * @param source The object on which the Event initially occurred.
     * @throws IllegalArgumentException if source is null.
     */
    public DemoEvent(Object source) {
        super(source);//source—事件源对象—如在界面上发生的点击按钮事件中的按钮
        //所有 Event 在构造时都引用了对象 "source"，在逻辑上认为该对象是最初发生有关 Event 的对象
    }
    
    public void say() {
        System.out.println("This is say method...");
    }
}
