package com.story.multthread.t06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/25
 * 线程间资源不可见
 **/
public class T01_WithoutVolatile {
    List lists = new ArrayList<>();

    public void add(Object o){lists.add(o);}

    public int size(){return lists.size();}

    public static void main(String[] args) {
        T01_WithoutVolatile t = new T01_WithoutVolatile();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add:"+i);

                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            while (true){
                if (t.size() == 5 ){
                    break;
                }
            }
            System.out.println("t2 over");
        },"t2").start();
    }
}
