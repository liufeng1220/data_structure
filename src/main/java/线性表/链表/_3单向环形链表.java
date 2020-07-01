package 线性表.链表;

import lombok.Data;
import org.testng.annotations.Test;

/**
 * 单向环形链表的实现
 * 约瑟夫问题的解决方案
 * 注意：java对象基础类型是值传递，引用类型是对象传递。传递的是地址，值发生改变的时候，对应的也会跟着变化
 */
public class _3单向环形链表 {
    public static void main(String[] args) {
        CircleSingleLinkedList circleSingleLinkedList = new CircleSingleLinkedList();
        circleSingleLinkedList.addBoy(125);
        circleSingleLinkedList.showBoyList();
        System.out.println("======");
        circleSingleLinkedList.removeChildren(2);
    }

    @Test
    public void m() {
        int a = 10;
        int b = a;
        b = 33;
        System.out.println(a);
        System.out.println(b);

        Boy boy = new Boy(2);
        Boy test = null;
        test = boy;
        Boy boy1 = new Boy(7);

        test = boy1;


        test.setNo(55);
        System.out.println(boy.getNo() + "hachod" + boy);
        System.out.println(test.getNo() + "hachod" + test);
        System.out.println(boy1);
        this.tsets(boy);
        boy1.setNo(99);
        System.out.println(boy.getNo());
    }

    public void tsets(Boy b) {
        b.setNo(88);
        System.out.println(b);
    }
}

class CircleSingleLinkedList {
    /**
     * 创建第一个first节点，当前没有编号
     */
    public Boy first = null;

    /**
     * 出列指定的小孩
     * @param num 移除指定位置的小孩
     */
    public void removeChildren(int num) {
        Boy temp = first;
        int m = 1;
        while (true) {
            //说明圈中只有一个人了，结束
            if (temp.getNext() == temp) {
                break;
            }
            if (m == num - 1) {
                temp.setNext(temp.getNext().getNext());
                m = 1;
                temp =temp.getNext();
                continue;
            }
            m++;
            temp =temp.getNext();
        }
        System.out.println("最后的小孩是"+temp.getNo());
    }

    /**
     * 添加小孩到环形链表欧中
     * 对象中是引用传递，当curBoy的值发生变化时候，first也会变化
     *
     * @param nums
     */
    public void addBoy(int nums) {
        if (nums < 1) {
            System.out.println("nums值不正确");
            return;
        }
        //辅助指针，帮助构建环形链表
        Boy curBoy = null;
        for (int i = 1; i <= nums; i++) {
            //根据编号，创建小孩节点
            Boy boy = new Boy(i);
            if (i == 1) {
                this.first = boy;
                first.setNext(first);
                //让curBoy指向第一个小孩
                curBoy = first;
            } else {
                curBoy.setNext(boy);
                boy.setNext(first);
                curBoy = boy;
            }


        }
    }

    /**
     * 打印单向环形链表
     */
    public void showBoyList() {
        Boy temp = this.first;
        while (true) {
            System.out.printf("小孩的编号为%d\n", temp.getNo());
            temp = temp.getNext();
            if (temp == first) {
                break;
            }
        }


    }
}

/**
 * 创建一个Boy类，表示一个节点
 */

class Boy {
    /**
     * 编号
     */
    private int no;
    /**
     * 指向下一个节点，默认为null
     */
    private Boy next;

    public Boy(int no) {
        this.no = no;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public Boy getNext() {
        return next;
    }

    public void setNext(Boy next) {
        this.next = next;
    }
}
