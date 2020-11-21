package com.story.multthread.t03;

/**
 * @Author story
 * @CreateTIme 2020/11/21
 **/
public class T03_VolatileReference2 {

    private static class Data{
        int a,b;

        public Data(int a, int b) {
            this.a = a;
            this.b = b;
        }
    }

    static volatile Data data;

    public static void main(String[] args) {
        Thread writer = new Thread(()->{
            for (int i = 0; i < 10_000; i++) {
                data = new Data(i,i);
            }
        });

        Thread reader = new Thread(()->{
            while (data == null){}
            int x = data.a;
            int y = data.b;

            if (x != y){
                System.out.printf("a= %s,b= %s",x,y);
            }
        });

        reader.start();
        writer.start();

        try {
            reader.join();
            writer.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("end");
    }

}
