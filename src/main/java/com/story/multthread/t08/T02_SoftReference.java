package com.story.multthread.t08;

import java.lang.ref.SoftReference;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/27
 *
 * 软引用是用来描述一些还有用但并非必须的对象。
 * 对于软引用关联着的对象，在系统将要发生内存溢出异常之前，将会把这些对象列进回收范围进行第二次回收。
 * 如果这次回收还没有足够的内存，才会抛出内存溢出异常。
 * -Xmx20M  -XX:+PrintGC
 **/
public class T02_SoftReference {
    public static void main(String[] args) throws InterruptedException {
        SoftReference<byte[]> m = new SoftReference(new byte[1024 * 1024 * 10]);
        //m = null;
        System.out.println(m.get());

        System.gc();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(m.get());

        byte[] b = new byte[1024 * 1024 * 12];
        System.out.println(m.get());

    }
}
