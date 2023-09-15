package org.example;

public class MinQueue {
    public Integer[] Minqueue;
    public Integer size;
    public Integer front;
    public Integer rear;

    //Constructor
    public MinQueue(int capacity) {
        Minqueue = new Integer[capacity];
        front = 0;
        rear = -1;
        size = 0;
    }

    //Method to insert element in the queue
    public void enqueue(int data) {
        //Check condition if queue is full
        if (isFull()) {
            System.out.println("Queue full");
            return;
        }
        rear = (rear + 1) % Minqueue.length;
        Minqueue[rear] = data;
        size++;
    }

    //Method to return the current size of the queue
    public int size() {
        return size;
    }

    //Method to remove the element from the queue
    public int dequeue() {
        //Condition check if the queue is empty
        if (isEmpty()) {
        System.out.println("Queue is empty");
        return -1;
        }
        //Logic to find the minimum element
        int minIndex = front;
        for (int i = 1; i < size; i++) {
            int index = (front + i) % Minqueue.length;
            if (Minqueue[index] < Minqueue[minIndex]) {
            minIndex = index;
            }
        }
        int data = Minqueue[minIndex];
        for (int i = minIndex; i < size - 1; i++) {
            Minqueue[i] = Minqueue[i + 1];
        }
        rear = (rear - 1 + Minqueue.length) % Minqueue.length;
        size--;
        return data;
    }

    //Method to return the minimum element
    public int top() {
        if (isEmpty()) {
            System.out.println("Queue is empty");
            return -1;
        }
        int minIndex = front;
        for (int i = 1; i < size; i++) {
            int index = (front + i) % Minqueue.length;
            if (Minqueue[index] < Minqueue[minIndex]) {
                minIndex = index;
            }
        }
        return Minqueue[minIndex];
    }

    public boolean isFull() {
        return size == Minqueue.length;
    }
    public boolean isEmpty() {
        return size == 0;
    }

}

