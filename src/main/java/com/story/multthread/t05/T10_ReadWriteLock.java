package com.story.multthread.t05;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @Author story
 * @CreateTIme 2020/11/25
 **/
public class T10_ReadWriteLock {
    static Lock lock = new ReentrantLock();
    private static int value;

    static ReadWriteLock readWriteLock = new ReentrantReadWriteLock();
    static Lock readLock = readWriteLock.readLock();
    static Lock writeLock = readWriteLock.writeLock();

    public static void read(Lock lock){
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(1);
            System.out.println("read over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void write(Lock lock,int v){
        try {
            lock.lock();
            TimeUnit.SECONDS.sleep(1);
            value = v;
            System.out.println("write over");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            lock.unlock();
        }
    }

    public static void main(String[] args) {
        Runnable readR = ()->{
            read(readLock);
        };

        Runnable writeR = ()->{
            write(writeLock,new Random().nextInt(10));
        };

        for (int i = 0; i < 18; i++) {
            new Thread(readR).start();
        }

        for (int i = 0; i < 2; i++) {
            new Thread(writeR).start();
        }
    }



}
