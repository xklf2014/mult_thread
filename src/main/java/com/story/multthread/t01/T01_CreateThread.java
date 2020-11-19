package com.story.multthread.t01;

/**
 * @Author story
 * @CreateTIme 2020/11/14
 **/
public class T01_CreateThread {
    static class MyThread extends Thread{
        @Override
        public void run() {
            System.out.println("Hello,My Thread");
        }
    }

    static class MyRunnable implements Runnable{

        @Override
        public void run() {
            System.out.println("hello my runnable");
        }
    }

    public static void main(String[] args) {
        MyRunnable runnable = new MyRunnable();
        MyThread thread = new MyThread();

        thread.start();
        new Thread(runnable).start();

        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "hello lambda");
        }).start();

    }



}
