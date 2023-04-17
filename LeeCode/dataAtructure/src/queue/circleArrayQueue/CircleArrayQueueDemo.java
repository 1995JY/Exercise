package queue.circleArrayQueue;

import java.util.Scanner;

public class CircleArrayQueueDemo {
    public static void main(String[] args) {
        CircleQueue cq = new CircleQueue(5);
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("请选择你需要的操作：");
            System.out.println("a（添加）    ：");
            System.out.println("g（获取）    ：");
            System.out.println("c（查看表头） ：");
            System.out.println("s（展示队列） ：");
            System.out.println("e（退出）    ：");
            System.out.println("b（长度）    ：");
            String s = sc.nextLine();
            switch (s) {
                case "a":
                    System.out.println("请输入添加的数据：");
                    int temp = Integer.parseInt(sc.nextLine());
                    cq.AddQueue(temp);
                    break;
                case "g":
                    System.out.println(cq.GetQueueHead());
                    break;
                case "c":
                    System.out.println(cq.CheckQueueHead());
                    break;
                case "s":
                    cq.showQueue();
                    break;
                case "e":
                    System.exit(0);
                    break;

                case "b":
                    System.out.println(cq.Size());
                    break;

                default:
                    System.out.println("非法输入");


            }
        }

    }
}

class CircleQueue {
    private int maxSize; // 最大容量
    private int rear;       // 队尾 顶部的意思
    private int front;      // 队头 底部的意思
    private int[] arr;

    // 构造器
    public CircleQueue(int maxSize) {
        this.maxSize = maxSize;
        rear = -1;
        front = -1;
        arr = new int[maxSize];
    }

    public boolean isEmpty() {
        if (front == -1) {
            return rear == front;
        }
        return (rear + 1) % maxSize == front;
    }

    public boolean isFull() {
        if (isEmpty()) {
            return false;
        }
        if(front==-1 && rear==maxSize-1){
            return true;
        }
        if(front>-1){
            return rear == front;
        }
        return false;
    }

    public int Size() {
        if (isEmpty()) {
            return 0;
        }
        if (isFull()) {
            return maxSize;
        }
        if (rear > front) {
            return rear - front;
        } else {
            return maxSize - front + rear;
        }
    }

    public boolean AddQueue(int value) {
        if (isFull()) {
            System.out.println("添加失败");
            return false;
        }
        rear = (rear + 1) % maxSize;
        arr[rear] = value;
        return true;
    }

    //    获取队列头
    public int GetQueueHead() {
        front = (front + 1) % maxSize;
        return arr[front];
    }

    //    查看队列头是什么
    public int CheckQueueHead() {

        return arr[(front + 1)%maxSize];
    }

    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列为空");
        }
        for (int i = 0; i < Size(); i++) {
            System.out.print(arr[(front + i + 1) % maxSize] + ",");
        }
        System.out.println();
    }


}
