package com.story.multthread.t03;

import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/21
 **/
public class T01_Volatile {
    //线程不可见，主线程修改running不会对新启线程有影响
    /*volatile */boolean running = true;

    void t(){
        System.out.println("t start");
        while (running){

        }
        System.out.println("t end");
    }

    public static void main(String[] args) {
        T01_Volatile t = new T01_Volatile();

        new Thread(t::t,"t1").start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        t.running = false;
    }
}
