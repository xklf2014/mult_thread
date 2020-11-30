package com.story.multthread.t13;

import java.util.concurrent.Executor;

/**
 * @Author story
 * @CreateTIme 2020/11/30
 **/
public class T01_MyExecutor implements Executor {
    @Override
    public void execute(Runnable command) {
        command.run();
    }

    public static void main(String[] args) {
        new T01_MyExecutor().execute(()->{
            System.out.println("hello executor");
        });
    }
}
