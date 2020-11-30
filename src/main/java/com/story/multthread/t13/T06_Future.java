package com.story.multthread.t13;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/30
 **/
public class T06_Future {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<Integer> task = new FutureTask(()->{
            TimeUnit.MILLISECONDS.sleep(500);
            return 1000;
        });

        new Thread(task).start();
        System.out.println(task.get());
    }
}
