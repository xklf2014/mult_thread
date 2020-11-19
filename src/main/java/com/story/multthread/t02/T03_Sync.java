package com.story.multthread.t02;

/**
 * @Author story
 * @CreateTIme 2020/11/19
 **/
public class T03_Sync {
    public synchronized void t1() {
        System.out.println(Thread.currentThread().getName()+ " t1 start...");
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName()+ " t1 end...");
    }

    public void t2()  {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + " t2...");
    }

    public static void main(String[] args) {
        T03_Sync t = new T03_Sync();
        new Thread(t::t1,"t1").start();
        new Thread(t::t2,"t2").start();
    }
}
