package com.story.multthread.t08;

import java.util.Arrays;

/**
 * @Author story
 * @CreateTIme 2020/11/27
 **/
public class T07_Singleton {

    private T07_Singleton(){
        System.out.println("single");
    }

    private static class Inner{
        private static T07_Singleton s = new T07_Singleton();
    }

    public static T07_Singleton getInstance(){
        return Inner.s;
    }

    public static void main(String[] args) {
        Thread[] threads = new Thread[100];
        for (int i = 0; i < threads.length; i++) {
            threads[i] = new Thread(()->{
                System.out.println(T07_Singleton.getInstance());
            });
        }

        Arrays.asList(threads).forEach(o -> o.start());
    }
}
