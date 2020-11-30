package com.story.multthread.t13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/30
 **/
public class T09_CachedPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newCachedThreadPool();
        System.out.println(service);

        for (int i = 0; i < 2; i++) {
            int finalI = i;
            service.execute(()->{
                try {
                    TimeUnit.MILLISECONDS.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " " + finalI);
            });
        }

        System.out.println(service);
        service.shutdown();
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(service);
    }
}
