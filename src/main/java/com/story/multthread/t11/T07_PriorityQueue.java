package com.story.multthread.t11;

import java.util.PriorityQueue;

/**
 * @Author story
 * @CreateTIme 2020/11/28
 **/
public class T07_PriorityQueue {
    public static void main(String[] args) {
        PriorityQueue<String> queue = new PriorityQueue<>();

        queue.add("h");
        queue.add("e");
        queue.add("l");
        queue.add("l");
        queue.add("o");

        for (int i = 0; i < 5; i++) {
            System.out.println(queue.poll());
        }
    }
}
