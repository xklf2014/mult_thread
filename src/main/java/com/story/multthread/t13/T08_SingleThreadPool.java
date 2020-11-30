package com.story.multthread.t13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author story
 * @CreateTIme 2020/11/30
 **/
public class T08_SingleThreadPool {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();

        for (int i = 0; i < 5; i++) {
            int finalI = i;
            service.execute(()->{
                System.out.println(finalI + " " + Thread.currentThread().getName());
            });
        }

        service.shutdown();
    }
}
