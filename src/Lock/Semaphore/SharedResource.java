package MultiThreading.Lock.Semaphore;

import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    public void produce(Semaphore lock){
        try {
        lock.acquire();
        System.out.println("Locked Acquired by "+Thread.currentThread().getName());

            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.release();
            System.out.println("Lock Released by : "+Thread.currentThread().getName());
        }

    }
}
