package MultiThreading.Lock.Reentrant;

import java.util.concurrent.locks.ReentrantLock;

public class SharedResource {

    public void produce(ReentrantLock lock){

        lock.lock();
        System.out.println("Locked Acquired by "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlock();
            System.out.println("Lock Released by : "+Thread.currentThread().getName());
        }

    }
}
