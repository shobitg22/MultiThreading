package MultiThreading.ProducerConsumer;

public class Main {

    public static void main(String[] args) {
        SharedResource sharedResource = new SharedResource(3);

        ProducerThread producerThread = new ProducerThread(sharedResource);
        Thread producer = new Thread(producerThread);

        Thread consumer = new Thread(()->{
           for (int i=1;i<=5;i++){
               System.out.println(sharedResource.consume());
           }
        });

        producer.start();
        consumer.start();
    }
}
