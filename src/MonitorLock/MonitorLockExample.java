package MultiThreading.MonitorLock;

public class MonitorLockExample {

    public synchronized void task1(){
        System.out.println("Inside task 1");
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        System.out.println("Task1 completed");
    }

    public void task2(){
        System.out.println("inside task2");

        synchronized (this){
            System.out.println("inside task2 sync block");
        }
    }

    public void task3(){
        System.out.println("task 3");
    }
}
