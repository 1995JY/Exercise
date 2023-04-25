package queue.arrayqueue;

public class ArrayQueueDemo {
    public static void main(String[] args) {

    }
}

class ArrayQueue {
    private int maxSize; // 最大容量
    private int rear;       // 队尾 顶部的意思
    private int front;      // 队头 底部的意思
    private int[] arr;

    // 构造器
    public ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        rear = -1;
        front = -1;
        arr = new int[maxSize];
    }

    public boolean isFull() {
        return rear == maxSize - 1;
    }

    public boolean isEmpty() {
        return rear == front;
    }

    public boolean addQueue(int newElement) {
        if (rear == maxSize - 1) {
            return false;
        }
        rear++;
        arr[rear] = newElement;
        return true;
    }

    public int getQueue() {
        if (rear == front) {
            throw new RuntimeException("当前队列为空");
        }
        front++;
        return arr[front];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("当前队列为空");
            return;
        }
        for (int i = 0; i < rear - front; i++) {
            System.out.println(arr[front + 1 + i]);
        }
    }
}
