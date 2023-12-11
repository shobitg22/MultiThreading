package MultiThreading.ThreadPool.ThreadPoolExecutor;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(2,4,5, TimeUnit.DAYS,
            new ArrayBlockingQueue<>(2),new CustomThreadFactory(),new CustomExecutionHandler());

        for(int i =1;i<=3;i++){
            executor.submit(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Task Submitted by "+Thread.currentThread().getName());
            });
        }
    }
}
