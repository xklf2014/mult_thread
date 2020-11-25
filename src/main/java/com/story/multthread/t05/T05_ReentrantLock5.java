package com.story.multthread.t05;

import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author story
 * @CreateTIme 2020/11/24
 **/
public class T05_ReentrantLock5 extends Thread{
    private static ReentrantLock lock = new ReentrantLock(true);//公平锁

    public void run(){
        for (int i = 0; i < 100; i++) {
            lock.lock();
            try {
                System.out.println(Thread.currentThread().getName()+ " 获得锁");
            }finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        T05_ReentrantLock5 t = new T05_ReentrantLock5();
        Thread t1 = new Thread(t);
        Thread t2 = new Thread(t);
        t1.start();
        t2.start();

    }
}
