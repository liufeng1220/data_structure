package 线性结构.链表;

import org.testng.annotations.Test;

public class _2双向链表 {
    public static void main(String[] args) {
        HeroNode2 heroNode1 = new HeroNode2(7, "张飞", "五福同心");
        HeroNode2 heroNode2 = new HeroNode2(8, "镜", "战争之影");
        HeroNode2 heroNode3 = new HeroNode2(9, "狮王", "深渊兽王");
        HeroNode2 heroNode4 = new HeroNode2(10, "镇元子", "炎帝");
        DoubleLinkedList dubleLinked = new DoubleLinkedList();
        //添加
        dubleLinked.add(heroNode2);
        dubleLinked.add(heroNode4);
        dubleLinked.add(heroNode3);
        dubleLinked.add(heroNode1);
        System.out.println("++++++++++遍历+++++++++");
        dubleLinked.list();
        System.out.println("++++++++++修改+++++++++");
        dubleLinked.update(new HeroNode2(8, "吴刚", "月宫骑士"));
        dubleLinked.list();
        System.out.println("++++++++++删除++++++++++");
        dubleLinked.delete(8);
        dubleLinked.delete(7);
        dubleLinked.delete(9);
        dubleLinked.delete(10);
        dubleLinked.list();
    }

    @Test
    public void testOrder() {
        HeroNode2 heroNode1 = new HeroNode2(7, "张飞", "五福同心");
        HeroNode2 heroNode2 = new HeroNode2(8, "镜", "战争之影");
        HeroNode2 heroNode3 = new HeroNode2(9, "狮王", "深渊兽王");
        HeroNode2 heroNode4 = new HeroNode2(10, "镇元子", "炎帝");
        DoubleLinkedList dubleLinked = new DoubleLinkedList();
        //添加
        dubleLinked.addByOrder(heroNode2);
        dubleLinked.addByOrder(heroNode4);
        dubleLinked.addByOrder(heroNode3);
        dubleLinked.addByOrder(heroNode1);
        dubleLinked.list();
    }
}

class DoubleLinkedList {
    /**
     * 定义一个头节点，不存储任何数据，主要是为了找到链表第一个
     */
    private HeroNode2 head = new HeroNode2(0, "", "");

    /**
     * 顺序添加
     *
     * @param heroNode2
     */
    public void addByOrder(HeroNode2 heroNode2) {
        HeroNode2 temp = head;
        //标志位添加的编号是否存在，默认false
        boolean flag = false;
        while (true) {
            if (temp.next == null) {
                break;
            }
            if (temp.next.no > heroNode2.no) {
                break;
                //希望
            } else if (temp.next.no == heroNode2.no) {
                flag = true;
                break;
            }
            temp = temp.next;
        }
        if (flag) {
            System.out.println("准备插入的英雄编号已经存在");
        } else {
            heroNode2.next = temp.next;
            temp.next = heroNode2;
        }
    }

    /**
     * 删除指定节点
     * 找到双向链表实现自我删除
     *
     * @param no 要删除的节点编号
     */
    public void delete(int no) {
        HeroNode2 temp = this.head;
        if (temp == null) {
            System.out.println("链表是空的");
            return;
        }
        while (true) {
            //已经到链表最后了
            if (temp == null) {
                break;
            }
            if (temp.no == no) {
                temp.pre.next = temp.next;
                if (temp.next == null) {
                    break;
                }
                temp.next.pre = temp.pre;
            }
            temp = temp.next;
        }

    }

    /**
     * 添加数据到双向链表最后
     *
     * @param HeroNode2
     */
    public void add(HeroNode2 HeroNode2) {
        //因为头节点不能动，所以需要一个临时变量来保存头节点信息，注意此时是引用地址传递。此时操作temp就等于操作head
        HeroNode2 temp = this.head;
        while (true) {
            if (temp.next == null) {
                temp.next = HeroNode2;
                temp.next.pre = temp;
                break;
            }
            temp = temp.next;
        }
    }

    /**
     * 修改，和单向链表一样
     */
    public void update(HeroNode2 heroNode) {
        HeroNode2 temp = this.head;
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
     * 打印链表
     */
    public void list() {
        //判断链表是否为空
        if (head.next == null) {
            System.out.println("链表为空");
            return;
        }
        HeroNode2 temp = head.next;
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
 * 定义HeroNode2，每一个HeroNode2 对象就是一个节点
 */
class HeroNode2 {
    public int no;
    public String name;
    public String nickname;
    //指向当前节点的下一个节点
    public HeroNode2 next;
    /**
     * 指向当前节点的上一个节点
     */
    public HeroNode2 pre;

    public HeroNode2() {
    }

    public HeroNode2(int no, String name, String nickname) {
        this.no = no;
        this.name = name;
        this.nickname = nickname;
    }

    @Override
    public String toString() {
        return "HeroNode2{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}
