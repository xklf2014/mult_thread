package com.story.multthread.t12;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @Author story
 * @CreateTIme 2020/11/29
 **/
public class T04_AtomicInteger {
    static AtomicInteger threadNo = new AtomicInteger(1);

    public static void main(String[] args) {
        char[] numbers = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();

        new Thread(()->{
            for (char c : numbers){
                while (threadNo.get() != 1){}
                System.out.print(c);
                threadNo.set(2);
            }
        },"t1").start();

        new Thread(()->{
            for (char c : letters){
                while (threadNo.get() != 2){}
                System.out.print(c);
                threadNo.set(1);
            }
        },"t2").start();
    }
}
