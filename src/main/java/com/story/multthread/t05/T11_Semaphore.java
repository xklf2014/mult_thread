package com.story.multthread.t05;

import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/25
 **/
public class T11_Semaphore {
    static Semaphore s = new Semaphore(2);//允许2个线程同时执行

    public static void main(String[] args) {
        new Thread(()->{
            try {
                s.acquire();

                System.out.println("t1 running begin");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("t1 running end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                s.release();
            }
        }).start();

        new Thread(()->{
            try {
                s.acquire();

                System.out.println("t2 running begin");
                TimeUnit.SECONDS.sleep(1);
                System.out.println("t2 running end");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();
    }

}
