package 线性结构.链表;

import org.testng.annotations.Test;

import java.util.Stack;

public class _1单链表 {
    /**
     * 初始化链表
     *
     * @return 添加好的元素
     */
    static SingleLinkedList initalizeLinked() {
        HeroNode heroNode1 = new HeroNode(1, "宋江", "及时雨");
        HeroNode heroNode2 = new HeroNode(2, "卢俊义", "玉麒麟");
        HeroNode heroNode3 = new HeroNode(3, "吴用", "智多星");
        HeroNode heroNode4 = new HeroNode(4, "林冲", "豹子头");
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //顺序添加
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode1);
        return singleLinkedList;
    }

    public static void main(String[] args) {
        SingleLinkedList singleLinkedList = initalizeLinked();
        singleLinkedList.list();
        System.out.println("=======================");
        singleLinkedList.update(new HeroNode(7, "张飞", ""));
        singleLinkedList.list();
        System.out.println(singleLinkedList.getCount());
        System.out.println(singleLinkedList.getNode(4));

    }

    @Test
    public void testAdd() {
        SingleLinkedList singleLinkedList = initalizeLinked();
        singleLinkedList.list();
    }

    @Test
    public void delete() {
        SingleLinkedList singleLinkedList = initalizeLinked();
        singleLinkedList.list();
        System.out.println("=============");
        singleLinkedList.delete(88);
        singleLinkedList.list();
    }

    @Test
    public void testReversal() {
        SingleLinkedList singleLinkedList = initalizeLinked();
        singleLinkedList.list();
        System.out.println("链表反转");
        singleLinkedList.reversal();
        singleLinkedList.list();
    }

    @Test
    public void testTailToHead() {
        SingleLinkedList singleLinkedList = initalizeLinked();
        singleLinkedList.tailToHead();
    }

    @Test
    public void testCombineLinked() {
        SingleLinkedList singleLinkedList1 = initalizeLinked();

        HeroNode heroNode1 = new HeroNode(7, "张飞", "五福同心");
        HeroNode heroNode2 = new HeroNode(8, "镜", "战争之影");
        HeroNode heroNode3 = new HeroNode(9, "狮王", "深渊兽王");
        HeroNode heroNode4 = new HeroNode(10, "镇元子", "炎帝");
        SingleLinkedList singleLinkedList = new SingleLinkedList();

        //顺序添加
        singleLinkedList.addByOrder(heroNode2);
        singleLinkedList.addByOrder(heroNode4);
        singleLinkedList.addByOrder(heroNode3);
        singleLinkedList.addByOrder(heroNode1);
        //c
        singleLinkedList1.combineLinked(singleLinkedList);
    }

}


/**
 * 定义SingleLinkedList管理英雄
 */
class SingleLinkedList {
    /**
     * 定义一个头节点，不存储任何数据，主要是为了找到链表第一个
     */
    private HeroNode head = new HeroNode(0, "", "");

    /**
     * 合并两个有序的单链表，合并之后的链表仍然有序
     */
    public void combineLinked(SingleLinkedList list) {
        HeroNode temp = null;
        HeroNode head = this.head;
        HeroNode second = list.head;
        while (true) {
            if (head.next == null) {
                head.next = second.next;
                break;
            }
            head = head.next;
        }
        list();

    }

    /**
     * 从尾到头打印单链表
     * 利用栈这个数据结构的特点，将各个节点压入栈中，利用栈特点先进后出完成逆序打印
     * push和add是一样的
     */
    public void tailToHead() {
        if (head.next == null) {
            return;
        }
        HeroNode temp = this.head.next;
        Stack<HeroNode> stack = new Stack<HeroNode>();
        while (temp != null) {
            stack.add(temp);
            temp = temp.next;
        }
        while (stack.size() > 0) {
            System.out.println(stack.pop());
        }
    }

    /**
     * 单链表反转
     */
    public void reversal() {

        if (head.next == null || head.next.next == null) {
            System.out.println("当前链表是空的");
            return;
        }

        HeroNode linkedTemp = null;
        HeroNode temp = this.head.next;
        HeroNode reverse = new HeroNode(0, "", "");
        while (temp != null) {
            linkedTemp = temp.next; //暂时保存当前节点的下一个节点
            temp.next = reverse.next; //将temp的下一个节点指向新的链表头部
            reverse.next = temp;
            temp = linkedTemp;

        }
        head.next = reverse.next;

    }

    /**
     * 获取单链表中倒数第i个节点
     * 获取当前链表总长度-i=倒数第i个元素再顺序排列的位置
     *
     * @param i
     * @return
     */
    public HeroNode getNode(int i) {
        HeroNode temp = this.head.next;
        if (temp == null) {
            return null;
        }
        //当前链表有效节点个数
        int count = this.getCount();
        int j = 0;
        while (true) {
            if (temp.next == null) {
                System.out.println("没有倒数第" + i + "个元素");
                return null;
            }
            if (j == count - i) {
                return temp;
            }
            j++;
            temp = temp.next;
        }
    }

    /**
     * 添加数据到链表
     *
     * @param heroNode
     */
    public void add(HeroNode heroNode) {
        //因为头节点不能动，所以需要一个临时变量来保存头节点信息，注意此时是引用地址传递。此时操作temp就等于操作head
        HeroNode temp = this.head;
        while (true) {
            if (temp.next == null) {
                temp.next = heroNode;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 顺序添加
     *
     * @param heroNode
     */
    public void addByOrder(HeroNode heroNode) {
        HeroNode temp = head;
        //标志位添加的编号是否存在，默认false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode.no) {
                break;
                //希望
            } else if (temp.next.no == heroNode.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("准备插入的英雄编号已经存在");
        } else {
            heroNode.next = temp.next;
            temp.next = heroNode;
        }
    }

    /**
     * 删除指定节点
     *
     * @param no 要删除的节点编号
     */
    public void delete(int no) {
        HeroNode temp = this.head;
        if (temp.next == null) {
            System.out.println("链表是空的");
            return;
        }
        boolean flag = false;
        while (true) {
            //已经到链表最后了
            if (temp.next == null) {
                break;
            }
            if (temp.next.no == no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            temp.next = temp.next.next;
        } else {
            System.out.println("要删除的节点不存在");
        }
    }

    /**
     * 修改
     */
    public void update(HeroNode heroNode) {
        HeroNode temp = this.head;
        while (true) {
            if (temp.next == null) {
                System.out.println("未找到要修改的元素编号");
                break;
            }
            if (temp.next.no == heroNode.no) {
                temp.next.name = heroNode.name;
                temp.next.nickname = heroNode.nickname;
                System.out.println("修改成功");
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 获取链表中有效节点的个数，如果是带有头节点的不统计头节点
     *
     * @return 返回有效节点个数
     */
    public int getCount() {
        if (this.head == null) {
            return 0;
        }
        HeroNode temp = this.head.next;
        int count = 0;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        return count;
    }

    /**
     * 打印链表
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode temp = head.next;
        while (true) {
            if (temp == null) {
                break;
            }
            System.out.println(temp);
            //将temp后移
            temp = temp.next;
        }
    }
}

/**
 * 定义HeroNode，每一个HeroNode 对象就是一个节点
 */
class HeroNode {
    public int no;
    public String name;
    public String nickname;
    public HeroNode next;

    public HeroNode() {
    }

    public HeroNode(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
