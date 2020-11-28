package com.story.multthread.t11;

import java.util.concurrent.LinkedTransferQueue;

/**
 * @Author story
 * @CreateTIme 2020/11/28
 **/
public class T10_TransferQueue {
    public static void main(String[] args) {
        LinkedTransferQueue<String> strs = new LinkedTransferQueue<>();

        new Thread(()->{
            try {
                System.out.println(strs.take());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }).start();

        try {
            strs.transfer("aaaa");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
