package com.story.multthread.t06;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/26
 **/
public class T02_WithVolatile {
    volatile List lists = Collections.synchronizedList(new LinkedList<>());

    public void add(Object o){lists.add(o);}

    public int size(){return lists.size();}

    public static void main(String[] args) {
        T02_WithVolatile t = new T02_WithVolatile();

        new Thread(()->{
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add"+i);
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        },"t1").start();

        new Thread(()->{
            while (true){
                if (t.size() == 5){
                    break;
                }
            }
            System.out.println("t2 over");
        },"t2").start();

    }

}
