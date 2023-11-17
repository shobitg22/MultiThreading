package MultiThreading.Lock.ReadWrite;

import java.util.concurrent.locks.ReadWriteLock;

public class SharedResource {

    private boolean isAvailable = false;

    public void produce(ReadWriteLock lock){

        lock.readLock().lock();
        System.out.println("Read Locked Acquired by "+Thread.currentThread().getName());
        isAvailable = true;
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        finally {
            lock.readLock().unlock();
            System.out.println("Read Lock Released by : "+Thread.currentThread().getName());
        }

    }
    public void consume(ReadWriteLock lock){
        lock.writeLock().lock();
        System.out.println("Write Locked Acquired by "+Thread.currentThread().getName());
        lock.writeLock().unlock();
        System.out.println("Write Lock Released by : "+Thread.currentThread().getName());
    }
}
