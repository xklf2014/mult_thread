package com.story.multthread.t12;

/**
 * @Author story
 * @CreateTIme 2020/11/29
 **/
public class T05_Sync_wait_notify {
    public static void main(String[] args) {
        final Object lock = new Object();

        char[] numbers = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();

        new Thread(()->{
            synchronized (lock){
                for (char c : numbers){
                    System.out.print(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }

        },"t1").start();

        new Thread(()->{
            synchronized (lock){
                for (char c : letters){
                    System.out.print(c);
                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }

        },"t2").start();
    }
}
