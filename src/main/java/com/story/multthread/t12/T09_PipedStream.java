package com.story.multthread.t12;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @Author story
 * @CreateTIme 2020/11/29
 **/
public class T09_PipedStream {
    public static void main(String[] args) throws IOException {
        char[] numbers = "1234567".toCharArray();
        char[] letters = "ABCDEFG".toCharArray();

        PipedInputStream i1 = new PipedInputStream();
        PipedInputStream i2 = new PipedInputStream();
        PipedOutputStream o1 = new PipedOutputStream();
        PipedOutputStream o2 = new PipedOutputStream();

        i1.connect(o2);
        i2.connect(o1);

        String msg = "Your turn";

        new Thread(()->{
            byte[] buffer = new byte[9];

            try {
                for (char c : letters){
                    i1.read(buffer);

                    if (new String(buffer).equals(msg)){
                        System.out.print(c);
                    }
                    o1.write(msg.getBytes());
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        },"t1").start();

        new Thread(()->{
            byte[] buffer = new byte[9];

            for (char c : numbers){
                System.out.print(c);

                try {
                    o2.write(msg.getBytes());
                    i2.read(buffer);

                    if (new String(buffer).equals(msg)){
                        continue;
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }


        },"t2").start();
    }
}
