package com.story.multthread.t10;

import java.util.LinkedList;
import java.util.List;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/28
 **/
public class T03_TicketSeller3 {
    static List<String> tickets = new LinkedList<>();

    static {
        for (int i = 0; i < 1_000; i++) {
            tickets.add("票编号:"+i);
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            new Thread(()->{
                while (true){
                    synchronized (tickets){
                        if (tickets.size() <=0){
                            break;
                        }

                        try {
                            TimeUnit.MILLISECONDS.sleep(10);
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }

                        System.out.println("票销售了--"+tickets.remove(0));
                    }
                }
            }).start();
        }
    }
}
