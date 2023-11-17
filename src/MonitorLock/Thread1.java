package MultiThreading.MonitorLock;

public class Thread1 implements Runnable{
    private MonitorLockExample monitorLockExample;

    public Thread1(MonitorLockExample monitorLockExample) {
        this.monitorLockExample = monitorLockExample;
    }

    @Override
    public void run() {
        monitorLockExample.task1();
    }
}
