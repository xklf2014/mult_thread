package com.story.multthread.t05;

import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/24
 **/
public class T01_ReentrantLock1 {
    synchronized void t1(){
        for (int i = 0; i < 10; i++) {
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(i);
            if (i == 2) t2();
        }
    }

    synchronized void t2(){
        System.out.println("t2 ....");
    }

    public static void main(String[] args) {
        T01_ReentrantLock1 t = new T01_ReentrantLock1();
        new Thread(t::t1).start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //new Thread(t::t2).start();
    }
}
