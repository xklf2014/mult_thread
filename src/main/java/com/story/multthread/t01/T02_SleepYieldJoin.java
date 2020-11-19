package com.story.multthread.t01;

/**
 * @Author story
 * @CreateTIme 2020/11/19
 **/
public class T02_SleepYieldJoin {
    public static void main(String[] args) {
        //testSleep();
        //testYield();
        testJoin();

    }

    static void testSleep() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }

    static void testYield() {
        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("A" + i);
                if (i % 10 == 0) Thread.yield();
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < 100; i++) {
                System.out.println("------B" + i);
                if (i % 10 == 0) Thread.yield();
            }
        }).start();
    }

    static void testJoin(){
        Thread t1 = new Thread(()->{
            for (int i = 0; i < 100; i++) {
                System.out.println("A"+i);
                try {
                    Thread.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread t2 = new Thread(()->{
            try {
                t1.join();
                for (int i = 0; i < 100; i++) {
                    System.out.println("B"+i);
                    Thread.sleep(1);
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        t1.start();
        t2.start();

    }

}
