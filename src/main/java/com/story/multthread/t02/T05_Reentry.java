package com.story.multthread.t02;

import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/19
 **/
public class T05_Reentry {
    synchronized void t1(){
        System.out.println("t1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2();
        System.out.println("t1 end");
    }

     synchronized void t2() {
         try {
             TimeUnit.SECONDS.sleep(1);
         } catch (InterruptedException e) {
             e.printStackTrace();
         }
         System.out.println("t2");
     }

    public static void main(String[] args) {
        T05_Reentry t = new T05_Reentry();
        t.t1();
    }
}
