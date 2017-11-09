package com.online.mall.test.listener;

import java.util.Enumeration;
import java.util.Vector;

/**
 * @author mgcele
 * @since 1.0.0
 */
class DemoSource {
    
    private Vector repository = new Vector();//监听自己的监听器队列
    
    public DemoSource() {
    }
    
    public void addDemoListener(DemoListener dl) {
        repository.addElement(dl);
    }
    
    public void notifyDemoEvent() {//通知所有的监听器
        Enumeration enumeration = repository.elements();
        while (enumeration.hasMoreElements()) {
            DemoListener dl = (DemoListener) enumeration.nextElement();
            dl.handleEvent(new DemoEvent(this));
        }
    }
    
}
