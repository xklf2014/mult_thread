package com.story.multthread.t08;

import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/27
 *
 * ThreadLocal线程局部变量
 *
 * ThreadLocal是使用空间换时间，synchronized是使用时间换空间
 **/
public class T05_ThreadLocal1 {
    static volatile Person p = new Person();

    public static void main(String[] args) {
        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(p.name);
        }).start();

        new Thread(()->{
            try {
                TimeUnit.SECONDS.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            p.name = "lisi";
        }).start();
    }
}

class Person{
    String name = "zhangsan";
}