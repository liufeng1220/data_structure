package 线性结构.栈;

import java.util.Scanner;

/**
 * 栈遵行先入后出原则，所以遍历的时候也是从最后一个开始遍历
 */
public class _1数组模拟栈 {
    public static void main(String[] args) {
        //接收一个字符
        char c = ' ';
        arrayStack stack = new arrayStack(3);
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("s显示队列");
            System.out.print("a添加数据push");
            System.out.print("c 出栈pop");
            c = scanner.next().charAt(0);
            switch (c) {
                case 's':
                    stack.listStackByArray();
                    break;
                case 'a':
                    System.out.println("输入一个数");
                    stack.push(scanner.nextInt());
                    break;
                case 'c':
                    try {
                        int i = stack.pop();
                        System.out.printf("出栈数据为%d", i);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                default:
            }
            System.out.println("=============");
        }
    }
}

class arrayStack {
    /**
     * 栈顶
     */
    public int top = -1;
    /**
     * 最大存储容量
     */
    public int maxSize;
    /**
     * 内容存放
     */
    public int[] arr;

    public arrayStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 判断栈是否为空
     */
    public boolean isEmpty() {
        return top == -1;
    }

    /**
     * 判断栈满
     */
    public boolean isFull() {
        return top == maxSize - 1;
    }

    /**
     * 入栈 push
     */
    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        arr[top] = num;
    }

    /**
     * 出栈 pop
     */
    public int pop() {
        if (isEmpty()) {
            new RuntimeException("栈空");
        }
        int value = arr[top];
        top--;
        return value;
    }

    public void listStackByArray() {
        for ( int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
