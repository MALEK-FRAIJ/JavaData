package DataStructures;

/**
 * Main
 */

public class LinkedList {
    private Node root;

    static class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;

        }

    }

    public void addFirst(int data) {

        Node newRoot = new Node(data);
        newRoot.next = root;
        root = newRoot;

    }

    public void add(int data) {
        // Node newData = new Node(data);
        if (root == null) {
            root = new Node(data); // newData obj
            return;
        }

        Node end = root;

        while (end.next != null) {
            end = end.next;
        }
        end.next = new Node(data);// newData;

    }

    public void addLast(int data) {

        add(data);
    }

    public void addIndex(int data, int index) {
        if (root == null) {
            return;

        }
        Node tmp = root;
        while (index > 1) {
            if (tmp == null) {
                return;
            }
            tmp = tmp.next;
            index--;
        }

        Node nextNode = tmp.next;
        tmp.next = new Node(data);
        tmp.next.next = nextNode;

    }

    public int firstRemove() {
        int data = root.data;
        root = root.next;
        return data;

    }

    public int Remove() {

        Node tmp = root;
        while (tmp.next.next != null) {
            tmp = tmp.next;
        }

        int data = tmp.next.data;
        tmp.next = null;
        return data;
    }

    public int removeFromIndex(int index) {
        int data = 0;
        Node tmp = root;

        if (index < 0)
            return -1;
        if (index == 0) {
            data = root.data;
            root = root.next;
            return data;
        }

        while (index > 0) {
            if (tmp == null) {
                return -1;
            }
            tmp = tmp.next;
            index--;
        }
        data = tmp.data;
        tmp.data = tmp.next.data;
        tmp.next = tmp.next.next;

        return data;
    }

    public void printList() {

        if (root == null) {
            System.out.println("[]");
            return;
        }

        Node tmp = root;
        System.out.print("[");
        while (tmp != null) {
            System.out.print(tmp.data + ",");
            tmp = tmp.next;
        }
        System.out.println("\b]");
    }

    public static void main(String[] args) {
      

     
    }
}