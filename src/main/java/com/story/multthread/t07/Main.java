package com.story.multthread.t07;

import java.util.concurrent.locks.Lock;

/**
 * @Author story
 * @CreateTIme 2020/11/26
 **/
public class Main {
    public static int m = 0;
    public static Lock lock = new MLock();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                try {
                    lock.lock();
                    for (int j = 0; j < 100; j++) {
                        m++;
                    }
                }finally {
                    lock.unlock();
                }
            });
        }

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        System.out.println(m);
    }
}
