package com.story.multthread.t12;

import javax.sound.midi.Soundbank;

/**
 * @Author story
 * @CreateTIme 2020/11/29
 **/
public class T06_Sync_wait_notify {
    private static volatile boolean t2Start = false;

    public static void main(String[] args) {
        final Object lock = new Object();

        char[] numbers = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();

        new Thread(() -> {
            synchronized (lock) {
                for (char c : numbers) {
                    System.out.println(c);
                    t2Start = true;

                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "t1").start();

        new Thread(() -> {
            synchronized (lock) {
                while (!t2Start) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                for (char c : letters) {
                    System.out.println(c);

                    try {
                        lock.notify();
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                lock.notify();
            }
        }, "t2").start();
    }
}
