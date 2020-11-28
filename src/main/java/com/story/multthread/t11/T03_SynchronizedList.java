package com.story.multthread.t11;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author story
 * @CreateTIme 2020/11/28
 **/
public class T03_SynchronizedList {
    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        List<String> lists = Collections.synchronizedList(strs);

        Random r = new Random();
        Thread[] threads = new Thread[100];

        for (int i = 0; i < threads.length; i++) {
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    for (int j = 0; j < 1_000; j++) {
                        lists.add("a"+r.nextInt(10000));
                    }
                }
            };

            threads[i] = new Thread(task);
        }

        runAndComputeTime(threads);
        System.out.println(lists.size());
    }

    static void runAndComputeTime(Thread[] ths){
        long start = System.currentTimeMillis();
        Arrays.asList(ths).forEach(t->t.start());
        Arrays.asList(ths).forEach(t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        long end = System.currentTimeMillis();
        System.out.println("takes:"+(end - start));
    }
}
