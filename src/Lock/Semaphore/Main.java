package MultiThreading.Lock.Semaphore;

import java.util.concurrent.Semaphore;

public class Main {
    public static void main(String[] args) {

        Semaphore lock = new Semaphore(2);

        SharedResource sharedResource1 = new SharedResource();
        Thread t1 = new Thread(()->sharedResource1.produce(lock));

        SharedResource sharedResource2 = new SharedResource();
        Thread t2 = new Thread(()->sharedResource2.produce(lock));

        SharedResource sharedResource3 = new SharedResource();
        Thread t3 = new Thread(()->sharedResource3.produce(lock));

        SharedResource sharedResource4 = new SharedResource();
        Thread t4 = new Thread(()->sharedResource4.produce(lock));

        t1.start();
        t2.start();
        t3.start();
        t4.start();
    }
}
