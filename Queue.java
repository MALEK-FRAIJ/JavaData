package DataStructures;

import java.util.Scanner;

/**
 * QueueImplantation
 */
public class Queue {
    private int maxValue;
    private int[] arrQueue;
    private int front, rear;

    /**
     * constructor to create Queue with size
     * 
     * @param size
     */
    public Queue(int maxValue) {
        this.maxValue = maxValue;
        this.arrQueue = new int[maxValue];
        this.front = this.rear = -1;

    }

    /**
     * Adds new entry to the top of the Queue
     * 
     * @param entry
     * @throws Exception
     */

    public void offer(int element) throws Exception {
        if (isFull()) {
            System.out.println("Queue OverFlow!!");
            increaseCapacity();
        }
        front = 0;
        this.arrQueue[++rear] = element;
    }

    /**
     * Removes an entry from the top of the Queue.
     * 
     * @return
     * @throws Exception
     */
    public int poll() throws Exception {
        int element;
        if (isEmpty()) {
            System.out.println("Queue UnderFlow!!");
            return -1;
        } else {
            element = this.arrQueue[front];
            if (front >= rear) {
                front = -1;
                rear = -1;
            } else {
                front++;
            }

        }
        return element;
    }

    /**
     * Returns top of the Queue without removing it.
     * 
     * @return
     */
    public int peek() {
        return this.arrQueue[front];
    }

    /**
     * Returns true if the Queue is Full
     * 
     * @return
     */
    public Boolean isFull() {
        return (front == 0 && rear == maxValue - 1);
    }

    /**
     * Returns true if the Queue is empty
     * 
     * @return
     */
    public Boolean isEmpty() {
        return (front == -1);
    }

    /**
     * Increase stack capacity
     */
    private void increaseCapacity() {
        int[] newQueue = new int[this.maxValue * 2];
        for (int i = 0; i < maxValue; i++) {
            newQueue[i] = this.arrQueue[i];
        }
        this.arrQueue = newQueue;
        this.maxValue = this.maxValue * 2;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print('[');
            for (int i = front; i <= rear; i++) {
                System.out.print(this.arrQueue[i] + ", ");
            }
            System.out.println("\b\b]");
    
            
        }
       
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {
            Queue queue = new Queue(10);
            int choice = 0;
            while (choice != 7) {
                System.out.println("***********Queue**********");
                System.out.println("\n1-enQueue\n2-deQueue\n3-peekTop\n4-isFull\n5-isEmpty\n6-print\n7-Exit");
                System.out.print("Enter the choice Option: ");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        System.out.print("Enter the value: ");
                        queue.offer(scanner.nextInt());
                        break;
                    case 2:
                        System.out.println("The " + queue.poll() + " is deQueue!");

                        break;
                    case 3:
                        System.out.println("Top is: " + queue.peek());
                        break;
                    case 4:
                        System.out.println("Is Full: " + queue.isFull());
                        break;
                    case 5:
                        System.out.println("is Empty: " + queue.isEmpty());
                        break;
                    case 6:
                        queue.display();
                        break;
                    case 7:
                        System.out.println("Exiting...");
                        choice = 6;
                        break;

                    default:
                        System.out.println("The Value number is not Valid!!");
                        break;
                }
            }

        } catch (Exception e) {
            System.out.println("ERROR!!");
        }

    }
}