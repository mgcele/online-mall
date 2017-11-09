package com.online.mall.test.listener;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class MainTest {
    
    DemoSource ds;
    public MainTest(){
        try{
            ds = new DemoSource();
            //将监听器在事件源对象中登记：
            DemoListener1 listener1 = new DemoListener1();
            ds.addDemoListener(listener1);
            ds.addDemoListener(new DemoListener() {
                @Override
                public void handleEvent(DemoEvent event) {
                    System.out.println("Method come from 匿名类...");
                }
            });
            ds.notifyDemoEvent();//触发事件、通知监听器
        }catch(Exception ex){
            ex.printStackTrace();
        }
    }
    
    public static void main(String args[]) {
        //创建资源对象--> 加入带有事件的监听器 -- > 执行
        new MainTest();
    }
    
}
