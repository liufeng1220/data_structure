import java.util.Stack;

/**
 * 测试栈
 * 先进后出
 */
public class TestStack {
    public static void main(String[] args) {
        //创建栈入栈
        Stack<String> stack = new Stack<String>();
        stack.add("小米");
        stack.add("消防");
        stack.add("中国");
        stack.add("promiss");
        //出栈
        while (stack.size()>0){
            System.out.println(stack.pop());
        }
    }
}
