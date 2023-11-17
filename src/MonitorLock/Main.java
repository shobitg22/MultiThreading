package MultiThreading.MonitorLock;

public class Main {

    public static void main(String[] args) {
        MonitorLockExample monitorLockExample = new MonitorLockExample();
//        Two ways to create a thread
        Thread1 thread1 = new Thread1(monitorLockExample);
        //Thread t1 = new Thread(monitorLockExample::task1);
        Thread t1 = new Thread(thread1);


        Thread t2 = new Thread(monitorLockExample::task2);
        Thread t3 = new Thread(monitorLockExample::task3);
        t1.start();
        t2.start();
        t3.start();
    }

}
