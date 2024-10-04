package az.edu.turing;

public class LinkedList_Methods {

    private Node head;
    private int size;

    // Node class representing each element in the linked list
    private static class Node {
        int data;
        Node next;

        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }

    public LinkedList_Methods() {
        head = null;
        size = 0;
    }

    // Method to add an element at the head of the list
    public void addHead(int data) {
        Node newNode = new Node(data);
        newNode.next = head;
        head = newNode;
        size++;
    }

    // Method to add an element at the tail of the list
    public void addTail(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = newNode;
        } else {
            Node current = head;
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
    }

    // Method to remove the head element
    public int removeHead() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        int removedData = head.data;
        head = head.next;
        size--;
        return removedData;
    }

    // Method to remove the tail element
    public int removeTail() {
        if (head == null) {
            throw new IllegalStateException("List is empty");
        }
        if (head.next == null) {
            int removedData = head.data;
            head = null;
            size--;
            return removedData;
        }
        Node current = head;
        while (current.next.next != null) {
            current = current.next;
        }
        int removedData = current.next.data;
        current.next = null;
        size--;
        return removedData;
    }

    // Method to insert an element at a specific position
    public void insert(int index, int data) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            addHead(data);
            return;
        }
        Node newNode = new Node(data);
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        newNode.next = current.next;
        current.next = newNode;
        size++;
    }

    // Method to update the value of a node at a specific position
    public void update(int index, int newData) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.data = newData;
    }

    // Method to delete an element at a specific position
    public void delete(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index out of range");
        }
        if (index == 0) {
            removeHead();
            return;
        }
        Node current = head;
        for (int i = 0; i < index - 1; i++) {
            current = current.next;
        }
        current.next = current.next.next;
        size--;
    }

    // Method to get the size of the list
    public int size() {
        return size;
    }

    // Method to delete all elements in the list
    public void deleteAll() {
        head = null;
        size = 0;
    }

    // Method to convert the list to a string
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Node current = head;
        while (current != null) {
            sb.append(current.data).append(" -> ");
            current = current.next;
        }
        sb.append("null");
        return sb.toString();
    }

    // Method to convert the list to an array
    public int[] toArray() {
        int[] array = new int[size];
        Node current = head;
        int i = 0;
        while (current != null) {
            array[i++] = current.data;
            current = current.next;
        }
        return array;
    }

    public static void main(String[] args) {
        LinkedList_Methods list = new LinkedList_Methods();

        // Testing the methods
        list.addHead(10);
        list.addTail(20);
        list.addTail(30);
        System.out.println("List after adding elements: " + list);
        System.out.println("Size: " + list.size());

        list.insert(1, 15);
        System.out.println("List after inserting 15 at index 1: " + list);

        list.update(2, 25);
        System.out.println("List after updating index 2 to 25: " + list);

        list.removeHead();
        System.out.println("List after removing head: " + list);

        list.removeTail();
        System.out.println("List after removing tail: " + list);

        list.delete(1);
        System.out.println("List after deleting element at index 1: " + list);

        int[] array = list.toArray();
        System.out.print("List to array: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        list.deleteAll();
        System.out.println("List after deleting all elements: " + list);
    }
}
