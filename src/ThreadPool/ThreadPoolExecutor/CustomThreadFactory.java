package MultiThreading.ThreadPool.ThreadPoolExecutor;

import java.util.concurrent.ThreadFactory;

public class CustomThreadFactory implements ThreadFactory {
    @Override
    public Thread newThread(Runnable r) {
        Thread thread = new Thread(r);
        thread.setPriority(Thread.MAX_PRIORITY);
        // other properties if needed
        return thread;
    }
}
