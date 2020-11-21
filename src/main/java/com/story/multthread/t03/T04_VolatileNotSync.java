package com.story.multthread.t03;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author story
 * @CreateTIme 2020/11/21
 **/
public class T04_VolatileNotSync {
    volatile int count = 0;
    void t(){
        for (int i = 0; i < 10_000; i++) {
            count++;
        }
    }

    public static void main(String[] args) {
        T04_VolatileNotSync t = new T04_VolatileNotSync();

        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            threads.add(new Thread(t::t,"thread"+i));
        }

        threads.forEach((o)->o.start());

        threads.forEach((o)->{
            try {
                o.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        System.out.println(t.count);
    }
}
