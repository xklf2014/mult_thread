package com.story.multthread.t02;

import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/19
 **/
public class T06_Reentry1 {
    synchronized void t1(){
        System.out.println("t1 start");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("t1 end");
    }

    public static void main(String[] args) {
        new Child().t1();
    }

}

class Child extends T06_Reentry1{
    @Override
    synchronized void t1() {
        System.out.println("child t1 start");
        super.t1();
        System.out.println("child t1 end");
    }
}