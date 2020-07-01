package 线性结构.数组.数组模拟队列;

import java.util.Scanner;

public class _1数组模拟队列 {
    public static void main(String[] args) {
        //创建数组
        ArrayQueue arrayQueue = new ArrayQueue(3);
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

class ArrayQueue {
    /**
     * 数组最大容量
     */
    private int maxSize;
    /**
     * 队列头
     */
    private int front;
    /**
     * 队列尾
     */
    private int rear;
    /**
     * 存放数据，模拟队列
     */
    private int[] arr;

    ArrayQueue(int maxSize) {
        this.maxSize = maxSize;
        //指向队列头前一个位置
        this.front = -1;
        //指向队列尾最后一个数据
        this.rear = -1;
        this.arr = new int[maxSize];
    }

    /**
     * 当队列尾部和数组最大容量相等时候，队列满
     *
     * @return
     */
    public boolean isFull() {
        return rear == maxSize - 1;
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
        rear++;
        arr[rear] = n;
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
        front++;
        return arr[front];
    }

    /**
     * 显示队列列表
     */
    public void showQueue() {
        if (isEmpty()) {
            System.out.println("队列是空的~");
            return;
        }
        int k = 0;
        for (int i : arr) {
            System.out.printf("arr[%d]==%d\n", k++, i);
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
        return arr[front + 1];
    }


}
