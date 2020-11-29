package com.story.multthread.t12;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

/**
 * @Author story
 * @CreateTIme 2020/11/29
 **/
public class T03_BlockingQueue {
    static BlockingQueue<String> q1 = new ArrayBlockingQueue<>(1);
    static BlockingQueue<String> q2 = new ArrayBlockingQueue<>(1);

    public static void main(String[] args) {
        char[] numbers = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();

        new Thread(()->{
            for (char c : numbers){
                System.out.print(c);
                try {
                    q1.put("ok");
                    q2.take();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            for (char c : letters){
                try {
                   q1.take();
                    System.out.print(c);
                    q2.put("ok");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t2").start();
    }
}
