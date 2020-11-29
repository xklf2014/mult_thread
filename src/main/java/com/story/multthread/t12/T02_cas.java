package com.story.multthread.t12;


import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/29
 **/
public class T02_cas {
    enum ReadyRun {T1, T2}

    static volatile ReadyRun r = ReadyRun.T1;

    public static void main(String[] args) {
        char[] numbers = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();

        new Thread(() -> {
            for (char c : numbers) {
                while (r != ReadyRun.T1) {
                }
                System.out.print(c);
                r = ReadyRun.T2;

            }
        }, "t1").start();

        new Thread(() -> {
            for (char c : letters) {
                while (r != ReadyRun.T2) {
                }
                System.out.print(c);
                r = ReadyRun.T1;

            }
        }, "t2").start();
    }
}
