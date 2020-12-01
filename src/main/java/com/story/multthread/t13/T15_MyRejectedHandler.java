package com.story.multthread.t13;

import java.util.concurrent.*;

/**
 * @Author story
 * @CreateTIme 2020/12/1
 **/
public class T15_MyRejectedHandler {
    public static void main(String[] args) {
        ExecutorService service = new ThreadPoolExecutor(4,4,0, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(6), Executors.defaultThreadFactory(),new MyHandler());
    }

    static class MyHandler implements RejectedExecutionHandler{

        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            if (executor.getQueue().size() < 10){
                System.out.println("ok");
            }
        }
    }
}
