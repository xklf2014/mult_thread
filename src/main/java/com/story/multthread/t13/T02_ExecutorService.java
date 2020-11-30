package com.story.multthread.t13;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @Author story
 * @CreateTIme 2020/11/30
 **/
public class T02_ExecutorService {
    public static void main(String[] args) {
        ExecutorService executorService = Executors.newCachedThreadPool();
        executorService.submit(new Runnable() {
            @Override
            public void run() {
                System.out.println("hello executor service");
            }
        });
    }
}
