package MultiThreading.Lock.Reentrant;


import java.util.concurrent.locks.ReentrantLock;

public class Main {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();

        SharedResource sharedResource1 = new SharedResource();
        Thread t1 = new Thread(()->sharedResource1.produce(lock));

        SharedResource sharedResource2 = new SharedResource();
        Thread t2 = new Thread(()->sharedResource2.produce(lock));

        t1.start();
        t2.start();
    }


}
