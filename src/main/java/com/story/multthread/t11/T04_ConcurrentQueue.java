package com.story.multthread.t11;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Author story
 * @CreateTIme 2020/11/28
 **/
public class T04_ConcurrentQueue {
    public static void main(String[] args) {
        Queue<String> strs = new ConcurrentLinkedDeque<>();

        for (int i = 0; i < 10; i++) {
            strs.offer("a"+i);
        }

        System.out.println(strs);
        System.out.println(strs.size());
        System.out.println(strs.peek());
        System.out.println(strs.size());
        System.out.println(strs.poll());
        System.out.println(strs.size());
    }
}
