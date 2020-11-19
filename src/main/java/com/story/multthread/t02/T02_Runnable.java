package com.story.multthread.t02;

/**
 * @Author story
 * @CreateTIme 2020/11/19
 **/
public class T02_Runnable implements Runnable{
    private  /*volatile*/ int count = 100;

    public synchronized void run(){
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        count--;
        System.out.println(Thread.currentThread().getName() + " count="+count);
    }

    public static void main(String[] args) {
        T02_Runnable t = new T02_Runnable();
        for (int i = 0; i < 100; i++) {
            new Thread(t,"Thread"+i).start();
        }
    }
}
