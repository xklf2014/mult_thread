package com.story.multthread.t03;

import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/21
 **/
public class T02_VolatileReference1 {
    boolean running = true;

    static volatile T02_VolatileReference1 T = new T02_VolatileReference1();

    void t(){
        System.out.println("t start");
        while (running){
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("t end");
    }

    public static void main(String[] args) {
        new Thread(T::t,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        T.running = false;
    }
}
