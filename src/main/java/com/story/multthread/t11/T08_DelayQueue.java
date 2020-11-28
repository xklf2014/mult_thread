package com.story.multthread.t11;

import java.util.Random;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/28
 **/
public class T08_DelayQueue {
    static BlockingQueue<MyTask> queue = new DelayQueue<>();
    static Random r = new Random();

    static class MyTask implements Delayed {
        String name;
        long runningTime;

        public MyTask(String name, long runningTime) {
            this.name = name;
            this.runningTime = runningTime;
        }

        @Override
        public long getDelay(TimeUnit unit) {
            return unit.convert(runningTime - System.currentTimeMillis(),TimeUnit.MICROSECONDS);
        }

        @Override
        public int compareTo(Delayed o) {
            if (this.getDelay(TimeUnit.MICROSECONDS) < o.getDelay(TimeUnit.MICROSECONDS)) {
                return -1;
            } else if (this.getDelay(TimeUnit.MICROSECONDS) > o.getDelay(TimeUnit.MICROSECONDS)){
                return 1;
            }else{
                return 0;
            }
        }

        @Override
        public String toString() {
            return "MyTask{" +
                    "name='" + name + '\'' +
                    ", runningTime=" + runningTime +
                    '}';
        }
    }

    public static void main(String[] args) throws InterruptedException {
        long now = System.currentTimeMillis();
        MyTask t1 = new MyTask("t1",now + 1000);
        MyTask t2 = new MyTask("t2",now + 2000);
        MyTask t3 = new MyTask("t3",now + 500);
        MyTask t4 = new MyTask("t4",now + 1500);
        MyTask t5 = new MyTask("t5",now + 3000);

        queue.put(t5);
        queue.put(t4);
        queue.put(t3);
        queue.put(t2);
        queue.put(t1);
        System.out.println(queue);

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.take());
        }

    }
}
