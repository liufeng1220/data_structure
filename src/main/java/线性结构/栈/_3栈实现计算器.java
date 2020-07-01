package 线性结构.栈;

/**
 * 利用栈实现计算器功能
 */
public class _3栈实现计算器 {
    public static void main(String[] args) {
        String expression = "51+3*2*2-3";
        //创建两个栈，一个数栈，一个符号栈
        CalculatorStack numStack = new CalculatorStack(10);
        CalculatorStack operStack = new CalculatorStack(10);
        //用于扫描
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int res = 0;
        //将每次扫描得到的char保存到C
        char c = ' ';
        //开始扫描
        while (true) {
            c = expression.substring(index, index + 1).charAt(0);
            //如果是运算符
            if (operStack.isOper(c)) {
                //判断运算符是否为空
                if (!operStack.isEmpty()) {
                    //如果符号栈中有数据，比较两个符号的优先级，如果当前操作符的优先级小于或等于栈中的操作符，就需要从栈中pop两个数。
                    //从符号栈中pop出一个符号，进行运算，将结果入数栈，当前操作符入符号栈。
                    if (operStack.priority(c) <= operStack.priority(operStack.peek())) {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        res = numStack.cal(num1, num2, oper);
                        //把运算结果入数栈
                        numStack.push(res);
                        //将符号入栈
                        operStack.push(c);
                    } else {
                        //如果当前符号优先级大于栈中的操作符，直接入符号栈
                        operStack.push(c);
                    }
                } else {
                    //如果为空，直接入符号栈
                    operStack.push(c);
                }
            } else {
                //如果是数，直接入栈,因为字符在ascci码表中的位置相差，所有减去48
                numStack.push(c - 48);
            }
            //让index+1,并判断是否到末尾
            index++;
            if (index >= expression.length()) {
                break;
            }
        }
        //扫描完毕
        while (true) {
            //如果符号栈为空，则计算到最后的结果，数栈中只有一个结果
            if (operStack.isEmpty()) {
                break;
            } else {
                num1 = numStack.pop();
                num2 = numStack.pop();
                oper = operStack.pop();
                res = numStack.cal(num1, num2, oper);
                numStack.push(res); //入栈
            }
        }
        System.out.println("表达式等于" + numStack.pop());
    }

}

class CalculatorStack {
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

    public CalculatorStack(int maxSize) {
        this.maxSize = maxSize;
        arr = new int[maxSize];
    }

    /**
     * 查看栈顶的元素，不是真正出栈
     */
    public int peek() {
        return arr[top];
    }

    /**
     * 返回运算符的优先级,数字越大优先级越高
     */
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 判断是否是一个运算符号
     *
     * @param val
     * @return
     */
    public boolean isOper(char val) {
        return val == '+' || val == '-' || val == '*' || val == '/';
    }

    /**
     * 计算
     *
     * @param num1 参数1
     * @param num2 参数2
     * @param oper 运算符号
     * @return 计算结果
     */
    public int cal(int num1, int num2, int oper) {
        //存放计算结果
        int res = 0;
        switch (oper) {
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 + num1;
                break;
        }
        return res;
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
        for (int i = top; i >= 0; i--) {
            System.out.println(arr[i]);
        }
    }
}
