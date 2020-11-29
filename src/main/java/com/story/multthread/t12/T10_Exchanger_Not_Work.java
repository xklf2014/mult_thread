package com.story.multthread.t12;

import java.util.concurrent.Exchanger;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/29
 **/
public class T10_Exchanger_Not_Work {
    private static Exchanger<String> exchanger = new Exchanger<>();

    public static void main(String[] args) {
        char[] numbers = "1234567".toCharArray();
        char[] letterds = "ABCDEFG".toCharArray();

        new Thread(()->{
            for (int i = 0; i < numbers.length; i++) {
                System.out.print(numbers[i]);
                try {
                    exchanger.exchange("t1");
                    TimeUnit.MILLISECONDS.sleep(2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(()->{
            for (int i = 0; i < letterds.length; i++) {
                try {
                    exchanger.exchange("t2");
                    TimeUnit.MILLISECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.print(letterds[i]);
            }
        }).start();


    }
}
