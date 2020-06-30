package 线性表.栈;

public class _2链表模拟栈 {
    public static void main(String[] args) {
        LinkedStack linkedStack = new LinkedStack();
        linkedStack.push(new HeroStack("张飞"));
        linkedStack.push(new HeroStack("码云"));
        linkedStack.push(new HeroStack("里斯"));
        linkedStack.push(new HeroStack("汪洋"));
        linkedStack.list();
        System.out.println("====");
        linkedStack.pop();
        linkedStack.list();
        System.out.println("====");
        linkedStack.pop();
        linkedStack.list();
    }
}

class LinkedStack {
    private HeroStack head = new HeroStack("");

    /**
     * push入栈
     *
     * @param stack
     */
    public void push(HeroStack stack) {
        HeroStack temp = head;
        while (true) {
            if (temp.next == null) {
                temp.next = stack;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * pop 出栈
     */
    public HeroStack pop() {
        HeroStack temp = head;
        while (true) {
            if (temp.next.next == null) {
                HeroStack value = temp.next;
                temp.next = null;
                return value;
            }
            temp =temp.next;
        }
    }
    /**
     * 遍历链表
     */
    public void list(){
        HeroStack temp = head.next;
        while (true){
            System.out.println(temp);
            if(temp.next ==null){
                break;
            }
            temp = temp.next;
        }
    }
}

class HeroStack {
    public String name;
    public HeroStack next;

    public HeroStack(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "HeroStack{" +
                "name='" + name + '\'' +
                '}';
    }
}
