package com.story.multthread.t11;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentSkipListMap;
import java.util.concurrent.CountDownLatch;

/**
 * @Author story
 * @CreateTIme 2020/11/28
 **/
public class T01_ConcurrentMap {
    public static void main(String[] args) {
        Map<String,String> map = new ConcurrentHashMap<>();   //61
        //Map<String,String> map = new ConcurrentSkipListMap<>();   //高并发且排序   //55
        //Map<String,String> map = new Hashtable<>();      // 56
        //Map<String,String> map = new HashMap<>();    // 56

        Thread[] threads = new Thread[100];
        CountDownLatch latch = new CountDownLatch(threads.length);

        long start = System.currentTimeMillis();
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                for (int j = 0; j < 10_000; j++) {
                    latch.countDown();
                }
            });
        }
        Arrays.asList(threads).forEach(t->t.start());

        try {
            latch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        long end = System.currentTimeMillis();
        System.out.println("takes: "+ (end - start));
        System.out.println(map.size());

    }
}
