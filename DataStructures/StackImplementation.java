package JavaData.DataStructures;

import java.util.Scanner;

/**
 * Stack
 */
public class StackImplementation<T extends Object> {
    private int maxValue;
    private T[] array;
    private int top;

    /**
     * constructor to create stack with size
     * 
     * @param size
     * 
     */

    @SuppressWarnings({ "unchecked" })
    public StackImplementation(int maxValue) {

        this.maxValue = maxValue;
        this.array = (T[]) new Object[maxValue];
        this.top = -1;

    }

    /**
     * Adds new entry to the top of the stack
     * 
     * @param entry
     * @throws Exception
     */
    public void push(T element) throws Exception {
        if (this.isFull()) {
            System.out.println("Stack Overflow!!");
            this.increaseCapacity();
        }
        this.array[++top] = element;

    }

    /**
     * Removes an entry from the top of the stack.
     * 
     * @return
     * @throws Exception
     */

    public T pop() throws Exception {
        if (this.isEmpty()) {
            System.out.println("Stack underflow!!");
        }
        T element = this.array[top--];
        return element;

    }

    /**
     * Returns top of the stack without removing it.
     * 
     * @return
     */
    public T peek() {
        return this.array[top];
    }

    /**
     * Returns true if the stack is empty
     * 
     * @return
     */

    public boolean isEmpty() {
        return (top == -1);
    }

    /**
     * Returns true if the stack is full
     * 
     * @return
     */
    public boolean isFull() {
        return (top == maxValue - 1);
    }

    /**
     * Increase stack capacity
     */
    @SuppressWarnings({ "unchecked" })
    private void increaseCapacity() {
        T[] newArray = (T[]) new Object[this.maxValue * 2];
        for (int i = 0; i < maxValue; i++) {
            newArray[i] = this.array[i];
        }
        this.array = newArray;
        this.maxValue = this.maxValue * 2;
    }

    public int size() {
        return this.top + 1;
    }

    public void display() {
        if (isEmpty()) {
            System.out.println("[]");
        } else {
            System.out.print("[");
            for (int i = 0; i <= top; i++) {
                System.out.print(array[i] + ", ");
            }
            System.out.print("\b\b]");
        }

    }

    public static void main(String args[]) {
        try (Scanner scanner = new Scanner(System.in)) {
            StackImplementation<Integer> stack = new StackImplementation<Integer>(10);
            try {

                int choice = 0b00000111;

                System.out.println("*********Stack operations using array*********\n");
                System.out.println("------------------------------------------------");
                while (choice != 6) {
                    System.out.println("\nChose one from the below options...");
                    System.out.println("1.Push\n2.Pop\n3.Show\n4.Exit\n5-size");
                    System.out.print(" Enter your choice ");
                    choice = scanner.nextInt();

                    switch (choice) {
                        case 1: {
                            System.out.print("Enter the value of stack: ");
                            stack.push(scanner.nextInt());
                            break;
                        }
                        case 2: {
                            System.out.println("The " + stack.pop() + " is popped!!");
                            break;
                        }
                        case 3: {
                            stack.display();
                            break;
                        }
                        case 4: {
                            System.out.println("Exiting....");
                            choice = 6;
                            break;
                        }
                        case 5:

                            System.out.println(stack.size());
                            break;
                        default: {
                            System.out.println("Please Enter valid choice ");
                        }
                    }

                }

            } catch (Exception e) {

                e.printStackTrace();
            }
        }

    }
}
