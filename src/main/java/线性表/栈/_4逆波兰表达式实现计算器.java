package 线性表.栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class _4逆波兰表达式实现计算器 {
    public static void main(String[] args) {
        //定义逆波兰表达式  (3+4)*5 -6
        String suffix = "3 4 + 5 * 6 -";
        //思路
        //1、将表达式放入一个arrylist
        //2.将数组传递给一个方法，遍历存入栈
        int calculate = calculate(getListString(suffix));
        System.out.println(calculate);
    }

    public static List<String> getListString(String expression) {
        ArrayList<String> strings = new ArrayList<String>();
        String[] s = expression.split(" ");
        for (String string : s) {
            strings.add(string);
        }
        return strings;
    }

    /**
     * 如果是数字则入栈
     *
     * @param ls
     * @return
     */
    public static int calculate(List<String> ls) {
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
                }else {
                    throw new RuntimeException("运算符有误");
                }
                stack.push(res+"");
            }
        }
        //最后留在stack中的就是结果
        return Integer.parseInt(stack.pop());
    }

}
