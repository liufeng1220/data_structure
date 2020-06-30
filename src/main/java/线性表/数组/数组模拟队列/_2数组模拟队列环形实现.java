package 线性表.数组.数组模拟队列;

import java.util.Scanner;

public class _2数组模拟队列环形实现 {
    public static void main(String[] args) {
        //创建数组
        ArrayQueueAnnular arrayQueue = new ArrayQueueAnnular(4);    //设置是三，有效个数只能存两个
        Scanner scanner = new Scanner(System.in);
        //接收一个字符
        char c = ' ';
        while (true) {
            System.out.println("s显示队列");
            System.out.println("a添加数据");
            System.out.println("h查看头数据");
            System.out.println("q取出一个数据");
            c = scanner.next().charAt(0);
            switch (c) {
                case 's':
                    arrayQueue.showQueue();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    arrayQueue.addQueue(scanner.nextInt());
                    break;
                case 'h':
                    try {
                        int i = arrayQueue.showHeadQueue();
                        System.out.printf("头数据为%d", i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'q':
                    try {
                        int queue = arrayQueue.getQueue();
                        System.out.printf("取出来的数据是%d", queue);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());

                    }
                    break;
                default:

            }
        }
    }

}

class ArrayQueueAnnular {
    /**
     * 数组最大容量
     */
    private int maxSize;
    /**
     * 队列头,指向队列第一个元素，初始值为0
     */
    private int front;
    /**
     * 队列尾，指向队列最后一个元素+1，初始值为0
     */
    private int rear;
    /**
     * 存放数据，模拟队列
     */
    private int[] arr;

    ArrayQueueAnnular(int maxSize) {
        this.maxSize = maxSize;
        this.arr = new int[maxSize];
    }

    /**
     * 当队列尾部和数组最大容量相等时候，队列满
     *
     * @return
     */
    public boolean isFull() {
        return (rear + 1) % maxSize == front;
    }

    /**
     * 当首部和尾部指针相等时候，队列为空
     *
     * @return
     */
    public boolean isEmpty() {
        return front == rear;
    }

    /**
     * 添加数据
     *
     * @param n
     */
    public void addQueue(int n) {
        if (isFull()) {
            System.out.println("队列满了，不能再添加数据");
            return;
        }
        arr[rear] = n;
        rear = (rear + 1) % maxSize;
    }

    /**
     * 取数据
     *
     * @return
     */
    public int getQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的");
        }
        int t = front;
        front = (front + 1) % maxSize;
        return arr[t];
    }

    /**
     * 显示队列列表
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的~");
            return;
        }
        for (int i = front; i < front + size(); i++) {
            System.out.printf("arr[%d]=%d\n", i % maxSize, arr[i % maxSize]);
        }
    }

    /**
     * 显示队列头数据
     *
     * @return
     */
    public int showHeadQueue() {
        if (isEmpty()) {
            throw new RuntimeException("队列是空的~~~~");
        }
        return arr[front];
    }

    /**
     * 求出当前队列有效个数
     */
    public int size() {
        return (rear + maxSize - front) % maxSize;
    }
}
