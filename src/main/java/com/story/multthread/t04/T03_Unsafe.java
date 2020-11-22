package com.story.multthread.t04;

import sun.misc.Unsafe;

/**
 * @Author story
 * @CreateTIme 2020/11/22
 **/
public class T03_Unsafe {
    static class M{
        private M(){}

        int i = 0;
    }

    public static void main(String[] args) {
        Unsafe unsafe = Unsafe.getUnsafe();

        try {
            M m = (M) unsafe.allocateInstance(M.class);
            m.i = 9;
            System.out.println(m.i);
        } catch (InstantiationException e) {
            e.printStackTrace();
        }
    }
}
