package com.story.multthread.t13;

import org.checkerframework.checker.units.qual.C;

import java.util.concurrent.*;
import java.util.function.Function;

/**
 * @Author story
 * @CreateTIme 2020/11/30
 **/
public class T03_Callable {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c = new Callable<String>() {
            @Override
            public String call() throws Exception {
                return "hello callable";
            }
        };

        ExecutorService e = Executors.newCachedThreadPool();
        Future<String> f = e.submit(c);
        System.out.println(f.get());
        e.shutdown();
    }
}
