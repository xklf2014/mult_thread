package com.story.multthread.t05;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author story
 * @CreateTIme 2020/11/25
 **/
public class T13_LockSupport {
    public static void main(String[] args) {
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 10; i++) {
                System.out.println(i);
                if (i == 5){
                    LockSupport.park();
                }

                try {
                    TimeUnit.SECONDS.sleep(1);
                    //System.out.println("sleep 1s");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        t1.start();

        //LockSupport.unpark(t1);

        try {
            TimeUnit.SECONDS.sleep(8);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("after 8 seconds");
        LockSupport.unpark(t1);
    }
}
