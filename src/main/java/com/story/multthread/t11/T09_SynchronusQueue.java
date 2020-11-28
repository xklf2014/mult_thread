package com.story.multthread.t11;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.SynchronousQueue;

/**
 * @Author story
 * @CreateTIme 2020/11/28
 **/
public class T09_SynchronusQueue {
    public static void main(String[] args) {
        BlockingQueue<String> strs = new SynchronousQueue<>();

        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            strs.put("aaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(strs.size());
    }
}
