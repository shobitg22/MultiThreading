package MultiThreading.ProducerConsumer;

public class ProducerThread implements Runnable{
    private SharedResource sharedResource;

    public ProducerThread(SharedResource sharedResource) {
        this.sharedResource = sharedResource;
    }

    @Override
    public void run() {
        for(int i=1;i<=5;i++){
            sharedResource.produce(i);
        }
    }
}
