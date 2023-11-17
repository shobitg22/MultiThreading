package MultiThreading.Lock.Stamped.Optimistic;

import java.util.concurrent.locks.StampedLock;

public class SharedResource {

    int a = 10;

    public void produce(StampedLock lock){

        long stamp = lock.tryOptimisticRead();
        System.out.println("Optimistic Locked Acquired by "+Thread.currentThread().getName());
        a= 11;
        try {
            Thread.sleep(5000);

            if(lock.validate(stamp)){
                System.out.println("value updated");
            }else{
                a = 10;
                System.out.println("Rollback");
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

    }
    public void consume(StampedLock lock){
        long stamp = lock.writeLock();
        System.out.println("Write Locked Acquired by "+Thread.currentThread().getName());
        lock.unlockWrite(stamp);
        System.out.println("Write Lock Released by : "+Thread.currentThread().getName());
    }
}
