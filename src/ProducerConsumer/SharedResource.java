package MultiThreading.ProducerConsumer;

import java.util.LinkedList;
import java.util.Queue;

public class SharedResource {

    private Queue<Integer> queue;
    private int bufferSize;

    public SharedResource(int bufferSize) {
        this.bufferSize = bufferSize;
        queue = new LinkedList<>();
    }

    public synchronized void produce(int element){
        if(queue.size() == bufferSize){
            System.out.println("SIZE FULL");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        queue.add(element);
        System.out.println("Element inserted: "+element);
        notify();
    }

    public synchronized int consume(){
        if(queue.isEmpty()){
            System.out.println("EMPTY");
            try {
                wait();
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        int ele = queue.poll();
        notify();
        return ele;
    }
}
