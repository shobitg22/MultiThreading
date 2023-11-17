package MultiThreading.Lock.ReadWrite;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class Main {
    public static void main(String[] args) {
        ReadWriteLock readWriteLock = new ReentrantReadWriteLock();

        SharedResource sharedResource = new SharedResource();
        Thread t1 = new Thread(()->sharedResource.produce(readWriteLock));
        t1.setName("t1");

        Thread t2 = new Thread(()->sharedResource.produce(readWriteLock));
        t2.setName("t2");

        SharedResource sharedResource1 = new SharedResource();
        Thread t3 = new Thread(()->{sharedResource1.consume(readWriteLock);});
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
