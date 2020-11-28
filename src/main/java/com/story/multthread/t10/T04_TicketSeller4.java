package com.story.multthread.t10;

import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedDeque;

/**
 * @Author story
 * @CreateTIme 2020/11/28
 **/
public class T04_TicketSeller4 {
    static Queue<String> tickets = new ConcurrentLinkedDeque<>();

    static {
        for (int i = 0; i < 1_000; i++) {
            tickets.add("票编号:"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    String s = tickets.poll();
                    if (s == null) break;
                    else System.out.println("票销售了:"+s);
                }
            }).start();
        }
    }
}
