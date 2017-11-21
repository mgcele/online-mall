package com.online.mall.test.production_consumer_model.blocking_queue;

import com.online.mall.test.production_consumer_model.AbstractConsumer;
import com.online.mall.test.production_consumer_model.AbstractProducer;
import com.online.mall.test.production_consumer_model.Consumer;
import com.online.mall.test.production_consumer_model.Model;
import com.online.mall.test.production_consumer_model.Producer;
import com.online.mall.test.production_consumer_model.Task;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author mgcele
 * @since 1.0.0
 */
public class BlockingQueueModel implements Model{
    
    private final BlockingQueue<Task> queue;
    
    private final AtomicInteger increTaskNo = new AtomicInteger(0);
    
    public BlockingQueueModel(int cap) {
        this.queue = new LinkedBlockingDeque<>(cap);
    }
    
    @Override
    public Runnable newRunnableConsumer() {
        return new ConsumerImpl();
    }
    
    @Override
    public Runnable newRunnableProducer() {
        return new ProducerImpl();
    }
    
    private class ConsumerImpl extends AbstractConsumer {
        @Override
        public void consume() throws InterruptedException {
            Task task = queue.take();
            // 固定时间范围的消费，模拟相对稳定的服务器处理过程
            Thread.sleep(500 + (long) (Math.random() * 500));
            System.out.println("consume: " + task.no);
        }
    }
    
    private class ProducerImpl extends AbstractProducer {
        @Override
        public void produce() throws InterruptedException {
            // 不定期生产，模拟随机的用户请求
            Thread.sleep((long) (Math.random() * 1000));
            Task task = new Task(increTaskNo.getAndIncrement());
            queue.put(task);
            System.out.println("produce: " + task.no);
        }
    }
    
    public static void main(String[] args) {
        Model model = new BlockingQueueModel(3);
        for (int i = 0; i < 2; i++) {
            new Thread(model.newRunnableConsumer()).start();
        }
        for (int i = 0; i < 5; i++) {
            new Thread(model.newRunnableProducer()).start();
        }
    }
    
}
