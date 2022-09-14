package JavaData.DataStructures;

import java.util.Scanner;

/**
 * Stack
 * 
 * stackImplementation
 */
public class Stack<T extends Object> {
    private int capacity;
    private int top;
    private T[] stack;

    /**
     * constructor to create stack with size
     * 
     * @param size
     * 
     */

    @SuppressWarnings({ "unchecked" })
    Stack(int capacity) {
        this.capacity = capacity;
        this.top = -1;
        this.stack = (T[]) new Object[capacity];
    }

    /**
     * Adds new entry to the top of the stack
     * 
     * @param entry
     * @throws Exception
     */
    public void push(T element) throws Exception {
        if (isFull()) {
            System.out.println("Stack overFlow!");
            this.increaseCapacity();
        }

        this.stack[++top] = element;

    }

    /**
     * Removes an entry from the top of the stack.
     * 
     * @return
     * @throws Exception
     */
    public T pop() throws Exception {
        if (isEmpty()) {
            System.out.println("Stack underflow!");
        }
        T element = this.stack[top--];
        return element;

    }

    /**
     * Returns top of the stack without removing it.
     * 
     * @return
     */

    public T peek() {
        return this.stack[top];
    }

    /**
     * Returns true if the stack is empty
     * 
     * @return
     */
    public boolean isEmpty() {
        return top < 0;
    }

    /**
     * Returns true if the stack is full
     * 
     * @return
     */
    public boolean isFull() {
        return (top == capacity - 1);
    }

    /**
     * Increase stack capacity
     * 
     * @param
     * @throws Exception
     * 
     */
    @SuppressWarnings({ "unchecked" })
    private void increaseCapacity() throws Exception {
        T[] newStack = (T[]) new Object[this.capacity * 2];
        for (int i = 0; i < capacity; i++) {
            newStack[i] = this.stack[i];
        }
        this.stack = newStack;
        this.capacity = this.capacity * 2;
    }

    /**
     * Returns number size stack
     * 
     * @return
     */
    public int size() {
        return this.top + 1;
    }

    public static void main(String[] args) {

        try (Scanner scanner = new Scanner(System.in)) {

            try {
                Stack<String> stack = new Stack<String>(10);

                stack.push("stackImplementation");

            } catch (Exception e) {

                e.printStackTrace();
            }
        }
    }
}