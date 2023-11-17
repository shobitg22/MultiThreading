package MultiThreading.Lock.Stamped.ReadWriteLike;


import java.util.concurrent.locks.StampedLock;

public class Main {
    public static void main(String[] args) {
        StampedLock stampedLock = new StampedLock();

        SharedResource sharedResource1 = new SharedResource();
        Thread t1 = new Thread(()->sharedResource1.produce(stampedLock));
        t1.setName("t1");

        SharedResource sharedResource2 = new SharedResource();
        Thread t2 = new Thread(()->sharedResource2.produce(stampedLock));
        t2.setName("t2");

        SharedResource sharedResource3 = new SharedResource();
        Thread t3 = new Thread(()->{sharedResource3.consume(stampedLock);});
        t3.setName("t3");

        t1.start();
        t2.start();
        t3.start();
    }
}
