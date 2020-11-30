package com.story.multthread.t13;

import java.sql.Time;
import java.util.Random;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.TimeUnit;

/**
 * @Author story
 * @CreateTIme 2020/11/30
 **/
public class T07_CompletableFuture {
    public static void main(String[] args) {
        long start, end;

        start = System.currentTimeMillis();

        CompletableFuture<Double> futureTM = CompletableFuture.supplyAsync(() -> priceOfTM());
        CompletableFuture<Double> futureTB = CompletableFuture.supplyAsync(() -> priceOfTB());
        CompletableFuture<Double> futureJD = CompletableFuture.supplyAsync(() -> priceOfJD());

        CompletableFuture.allOf(futureTM, futureTB, futureJD).join();
        CompletableFuture.supplyAsync(() -> priceOfTM()).thenApply(String::valueOf)
                .thenApply(str -> "price" + str)
                .thenAccept(System.out::println);

        end = System.currentTimeMillis();
        System.out.println("use complatefuture " + (end - start));
    }

    private static double priceOfTM() {
        delay();
        return 1.0;
    }

    private static double priceOfTB() {
        delay();
        return 2.0;
    }

    private static double priceOfJD() {
        delay();
        return 3.0;
    }


    public static void delay() {
        int time = new Random().nextInt(500);
        try {
            TimeUnit.MILLISECONDS.sleep(time);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.printf("After %s sleep \n", time);
    }
}
