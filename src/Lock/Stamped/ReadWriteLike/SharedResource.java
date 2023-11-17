package MultiThreading.Lock.Stamped.ReadWriteLike;

import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    public void produce(StampedLock lock){

        long stamp = lock.readLock();
        System.out.println("Read Locked Acquired by "+Thread.currentThread().getName());
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.unlockRead(stamp);
            System.out.println("Read Lock Released by : "+Thread.currentThread().getName());
        }

    }
    public void consume(StampedLock lock){
        long stamp = lock.writeLock();
        System.out.println("Write Locked Acquired by "+Thread.currentThread().getName());
        lock.unlockWrite(stamp);
        System.out.println("Write Lock Released by : "+Thread.currentThread().getName());
    }
}
