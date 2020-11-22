package com.story.multthread.t04;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;

/**
 * @Author story
 * @CreateTIme 2020/11/22
 **/
public class T02_AtomicVsSyncVsLongAdder {
    static long count1 = 0L;
    static AtomicLong count2 = new AtomicLong(0L);
    static LongAdder count3 = new LongAdder();

    public static void main(String[] args) throws InterruptedException {
        Thread[] threads = new Thread[1000];

        long start;
        long end;

        Object lock = new Object();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100_000; j++) {
                    synchronized (lock) {
                        count1++;
                    }
                }
            });
        }
        start = System.currentTimeMillis();

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        end = System.currentTimeMillis();

        System.out.println("Sync: " + count1 + " takes: " + (end - start));

        System.out.println("---------------------------");

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100_000; j++) {
                    count2.incrementAndGet();
                }
            });
        }

        start = System.currentTimeMillis();

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        end = System.currentTimeMillis();

        System.out.println("Atomic:" + count2.get() + " takes: " + (end - start));

        System.out.println("---------------------------");

        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(() -> {
                for (int j = 0; j < 100_000; j++) {
                    count3.increment();
                }
            });
        }

        start = System.currentTimeMillis();

        for (Thread t : threads) t.start();
        for (Thread t : threads) t.join();

        end = System.currentTimeMillis();

        System.out.println("LongAdder: " + count3.longValue() + " takes: " + (end - start));
    }


}
