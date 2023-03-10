package DataStructures;

public class ArrayList {
    private int size;
    private int capacity;
    private Object[] arrayList;

    public ArrayList() {
        this.size = 0;
        this.capacity = 10;
        this.arrayList = new Object[capacity];
    }

    public ArrayList(int capacity) {
        this.capacity = capacity;
        this.arrayList = new Object[capacity];
    }

    public int size() {
        return this.size;
    }

    public Boolean isEmpty() {
        return (size == 0);
    }

    private Boolean isFull() {
        return (size == capacity - 1);
    }

    public void add(Object element)  {
        if (isFull()) {
            increaseCapacity();
        }
        this.arrayList[++size] = element;

    }

    public void add(int index, Object element) {


    }

    public Object remove() {
        if (isEmpty()) {
            System.out.println("Empty");
        }
        Object element = arrayList[size--];
        return element;
    }

    private void increaseCapacity() {

        Object[] newArrayList = new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            newArrayList[i] = this.arrayList[i];
        }
        newArrayList = this.arrayList;
        this.capacity = this.capacity * 2;

    }

    public void display() {
        if (isEmpty()) 
            System.out.println("[]");
        else {

            System.out.print("[");
            
            for (int i = 0; i <= size; i++) {
                System.out.print(arrayList[i] + ",");
            }
            System.out.println("\b]");

        }

    }

    public static void main(String[] args) {

        ArrayList arrayList = new ArrayList();

       
            arrayList.add(10);
            arrayList.add(2);
            arrayList.add(30);
            arrayList.add(44);

            arrayList.display();

            arrayList.remove();

            arrayList.display();
            System.out.println(arrayList.size());
            System.out.println(arrayList.isEmpty());
            System.out.println(arrayList.isFull());




       

    }

}
