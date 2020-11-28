package com.story.multthread.t10;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author story
 * @CreateTIme 2020/11/28
 **/
public class T01_TicketSeller1 {
    static List<String> tickets = new ArrayList<>();

    static {
        for (int i = 0; i < 1_000; i++) {
            tickets.add("票编号:"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (tickets.size() > 0){
                    System.out.println("票销售了--" + tickets.remove(0));
                }
            },"thread"+i).start();
        }
    }
}
