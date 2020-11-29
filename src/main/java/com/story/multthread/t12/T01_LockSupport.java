package com.story.multthread.t12;

import java.util.concurrent.locks.LockSupport;

/**
 * @Author story
 * @CreateTIme 2020/11/29
 **/
public class T01_LockSupport {
    static Thread t1 = null,t2 = null;

    public static void main(String[] args) {
        char[] number = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();

        t1 = new Thread(()->{
            for (char c : number){
                System.out.println(c);
                LockSupport.unpark(t2);
                LockSupport.park();
            }
        },"t1");

        t2 = new Thread(()->{
            for (char c : letters){
                LockSupport.park();
                System.out.println(c);
                LockSupport.unpark(t1);
            }
        },"t2");

        t1.start();
        t2.start();
    }
}
