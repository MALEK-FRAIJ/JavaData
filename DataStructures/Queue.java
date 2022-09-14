package JavaData.DataStructures;


import java.util.Scanner;

/**
 * Queues
 * 
 * stackImplementation
 */
public class Queue<T extends Object> {
    private T[] queue;
    private int front, rear;
    private int capacity;

    /**
     * constructor to create Queue with size
     * 
     * @param size
     * 
     */

    @SuppressWarnings({ "unchecked" })
    public Queue(int capacity) {
        this.capacity = capacity;
        this.front = this.rear = -1;
        this.queue = (T[]) new Object[capacity];

    }

    /**
     * Adds new entry to the top of the Queue
     * 
     * @param entry
     * @throws Exception
     */
    public void offer(T element) throws Exception {
        if (isFull()) {
            System.out.println("Queue overFlow!");
            this.increaseCapacity();
        }
        front = 0;
        this.queue[++rear] = element;

    }

    /**
     * Removes an entry from the top of the queue.
     * 
     * @return
     * @throws Exception
     */

    public T poll() throws Exception {
        T element;
        if (isEmpty()) {
            System.out.println("Queue UnderFlow!!");
            return null;
        } else {
            element = this.queue[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }
         return element;
        }
       
    }

    /**
     * Returns top of the queue without removing it.
     * 
     * @return
     */

    public T peek() {
        return this.queue[front];
    }

    /**
     * Returns true if the queue is empty
     * 
     * @return
     */
    public boolean isEmpty() {
        return front < 0;
    }

    /**
     * Returns true if the queue is full
     * 
     * @return
     */
    public boolean isFull() {
        return (rear == capacity - 1);
    }

    /**
     * Increase queue capacity
     * 
     * @param
     * @throws Exception
     * 
     */

    @SuppressWarnings({ "unchecked" })
    private void increaseCapacity() throws Exception {
        T[] newQueue = (T[]) new Object[capacity * 2];
        for (int i = 0; i < capacity; i++) {
            newQueue[i] = this.queue[i];
        }
        this.queue = newQueue;
        this.capacity = capacity * 2;

    }

     /**
     * Returns number size stack
     * 
     * @return
     */
    public int size() {
        return (rear - front)+1;
    }




    public static void main(String[] args) {
        try (Scanner scanner = new Scanner(System.in)) {
            Queue<String> queue = new Queue<String>(10);

            queue.offer("queue implement");

           

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
