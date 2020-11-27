package com.story.multthread.t08;

import java.io.IOException;

/**
 * @Author story
 * @CreateTIme 2020/11/27
 **/
public class T01_NormalReference {
    public static void main(String[] args) throws IOException {
        M m = new M();
        m = null;
        System.gc();

        System.in.read();
    }
}

class M{
    @Override
    protected void finalize() throws Throwable {
        System.out.println("finalize");
    }
}
