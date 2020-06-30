package 线性表.栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
/**
 * Created by liufeng on 2020/3/21 16:54
 */
public class _5中缀转后缀表达式实现 {

    public static void main(String[] args) {
        String expression = "1+((22+3)*4)-51+4*11-2+8/9";
        //将中缀表达式转集合列表，方便输出
        List<String> strings = infixToArray(expression);
        System.out.println(strings);
        //将中缀表达式的集合转成后缀表达式的集合
        System.out.println(arrayToSuffix(strings));
        //求后缀表达式的结果
        System.out.println(calculate(arrayToSuffix(strings)));

    }

    /**
     * 中缀表达式的集合转成后缀表达式
     *
     * @param list
     */
    public static Stack<String> arrayToSuffix(List<String> list) {
        //符号栈
        Stack<String> operatorStack = new Stack();
        //存储栈====》这里可以用arrayList代替，方便操作
        Stack<String> storeStack = new Stack();
        for (String s : list) {
            //如果是数字直接入存储栈
            if (s.matches("\\d+")) {
                storeStack.push(s);
            } else { //如果不是数字需要考虑几种情况
                //1、当符号栈中没有符号 或者 符号栈顶元素为左括号，直接入符号栈
                if (operatorStack.size() == 0 || operatorStack.peek().equals("(") || s.equals("(")) {
                    operatorStack.push(s);
                    //2、当即将入栈的是右括号时候,依次弹出符号栈的元素入存储栈，知道遇到左括号时候停止，同事丢弃两个括号
                } else if (s.equals(")")) {
                    while (!operatorStack.peek().equals("(")) {
                        storeStack.push(operatorStack.pop());
                    }
                    operatorStack.pop();
                } else {
                    //符号栈中的符号优先级
                    int i;
                    //遍历字符的优先级
                    int m = priority(s);
                    //当当前遍历的符号优先级大于 符号栈顶的 优先级时候，将当前符号 入符号栈
                    //如果不大于则将符号栈顶的元素pop到存储栈，然后在重新比较
                    do {
                        i = priority(operatorStack.peek());
                        if (m > i) {
                            operatorStack.push(s);
                        } else {
                            storeStack.push(operatorStack.pop());
                        }
                    } while (operatorStack.size() != 0 && m > i);
                    operatorStack.push(s);
                }
            }


        }
        //将符号栈剩余元素压入值栈
        while (operatorStack.size() != 0) {
            storeStack.push(operatorStack.pop());
        }


        return storeStack;
    }

    /**
     * 计算后缀表达式
     *
     * @param ls
     * @return
     */
    public static int calculate(Stack<String> ls) {
        //创建栈
        Stack<String> stack = new Stack<String>();
        for (String l : ls) {
            //正则表达式判断数字,如果是多位数组
            if (l.matches("\\d+")) {
                //入栈
                stack.push(l);
            } else {
                //pop两个数运算再入栈
                int num2 = Integer.parseInt(stack.pop());
                int num1 = Integer.parseInt(stack.pop());
                int res = 0; //存放结果
                if (l.equals("+")) {
                    res = num1 + num2;
                } else if (l.equals("-")) {
                    res = num1 - num2;
                } else if (l.equals("*")) {
                    res = num1 * num2;
                } else if (l.equals("/")) {
                    res = num1 / num2;
                } else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res + "");
            }
        }
        //最后留在stack中的就是结果
        return Integer.parseInt(stack.pop());
    }

    /**
     * 返回运算符的优先级,数字越大优先级越高
     */
    public static int priority(String oper) {
        if (oper == "*" || oper == "/") {
            return 1;
        } else if (oper == "+" || oper == "-") {
            return 0;
        } else {
            return -1;
        }
    }

    /**
     * 将中缀转换成list集合，方便操作
     * 1+((2+3)*4)-5 =====> [1, +, (, (, 2, +, 3, ), *, 4, ), -, 5]
     *
     * @param expression
     * @return
     */
    public static List<String> infixToArray(String expression) {
        List<String> ls = new ArrayList<String>();
        int i = 0;
        String str;
        char c;
        do {
            //如果取出去的不是一个数字
            if ((c = expression.charAt(i)) < 48 || (c = expression.charAt(i)) > 57) {
                ls.add("" + c);
                i++;
            } else { //如果是数字，需要考虑多位数问题
                str = "";
                //
                while (i < expression.length() && (c = expression.charAt(i)) >= 48 && (c = expression.charAt(i)) <= 57) {
                    str += c; //拼接
                    i++;
                }
                ls.add(str);
            }
        } while (i < expression.length());
        return ls;
    }
}

