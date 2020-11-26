package com.story.multthread.t06;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.LockSupport;

/**
 * @Author story
 * @CreateTIme 2020/11/26
 **/
public class T07_LockSupport_WithoutSleep {
    volatile List lists = new ArrayList();

    public void add(Object o){lists.add(o);}

    public int size(){return lists.size();}

    static Thread t1 = null,t2 = null;

    public static void main(String[] args) {
        T07_LockSupport_WithoutSleep t = new T07_LockSupport_WithoutSleep() ;

        t1 = new Thread(()->{
            System.out.println("t1启动");
            for (int i = 0; i < 10; i++) {
                t.add(new Object());
                System.out.println("add"+i);

                if (t.size() == 5){
                    LockSupport.unpark(t2);
                    LockSupport.park();
                }
            }
        },"t1");

        t2 = new Thread(()->{
            //if (t.size() != 5){
                LockSupport.park();
            //}
            System.out.println("t2 over");
            LockSupport.unpark(t1);
        },"t2");

        t2.start();
        t1.start();
    }
}
