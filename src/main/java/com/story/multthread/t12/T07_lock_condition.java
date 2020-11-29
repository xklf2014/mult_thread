package com.story.multthread.t12;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author story
 * @CreateTIme 2020/11/29
 **/
public class T07_lock_condition {
    public static void main(String[] args) {
        char[] numbers = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();

        Lock lock = new ReentrantLock();
        Condition condition = lock.newCondition();

        new Thread(()->{
            try {
                lock.lock();

                for (char c : numbers){
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }

                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t1").start();

        new Thread(()->{
            try {
                lock.lock();
                for (char c : letters){
                    System.out.print(c);
                    condition.signal();
                    condition.await();
                }
                condition.signal();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }finally {
                lock.unlock();
            }
        },"t2").start();
    }
}
