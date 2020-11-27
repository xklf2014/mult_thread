package com.story.multthread.t08;

import java.lang.ref.WeakReference;

/**
 * @Author story
 * @CreateTIme 2020/11/27
 *
 * 弱引用遭到gc就会回收
 * -XX:+PrintGC
 **/
public class T03_WeakReference {
    public static void main(String[] args) {
        WeakReference<M> m = new WeakReference(new M());

        System.out.println(m.get());
        System.gc();
        System.out.println(m.get());

        ThreadLocal<M> tl = new ThreadLocal<>();
        tl.set(new M());
        tl.remove();

    }
}
