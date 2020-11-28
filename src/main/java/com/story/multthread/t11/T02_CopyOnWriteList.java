package com.story.multthread.t11;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @Author story
 * @CreateTIme 2020/11/28
 * 写时复制容器 copy on write
 * 多线程环境下，写时效率低，读时效率高
 * 适合写少读多的环境
 **/
public class T02_CopyOnWriteList {
    public static void main(String[] args) {
        //List<String> lists = new ArrayList<>();
        //List<String> lists = new Vector<>();
        List<String> lists = new CopyOnWriteArrayList<>();

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
