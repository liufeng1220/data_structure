package 非线性结构.tree;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.testng.annotations.Test;

/**
 * 中序线索化二叉树实现
 * 线索化二叉树不用递归
 *
 *
 * 1)   n个结点的二叉链表中含有  n+1【公式     2n-(n-1)=n+1 】个空指针域。利用二叉链表中的空指针域，存放指向
 * 该结点在某种遍历次序下的前驱和后继结点的指针（这种附加的指针称为"线索"）
 * 2)这种加上了线索的二叉链表称为线索链表，相应的二叉树称为线索二叉树(Threaded    BinaryTree)。根据线索性质
 * 的不同，线索二叉树可分为前序线索二叉树、中序线索二叉树和后序线索二叉树三种
 * 3)一个结点的前一个结点，称为前驱结点
 * 4)一个结点的后一个结点，称为后继结点
 * Created by liufeng on 2020/7/7 13:26
 */
public class _3线索化二叉树 {
    /**
     * 中序线索化二叉树测试
     */
    @Test
    public void midTest(){
        HeroNode1 _1 = new HeroNode1(1, "宋江");
        HeroNode1 _2 = new HeroNode1(2, "张飞");
        HeroNode1 _3 = new HeroNode1(3, "关羽");
        HeroNode1 _4 = new HeroNode1(4, "网格");
        HeroNode1 _5 = new HeroNode1(5, "中国");
        HeroNode1 _6 = new HeroNode1(6, "死神");
        HeroNode1 _7 = new HeroNode1(7, "死神");
        HeroNode1 _8 = new HeroNode1(8, "死神");
        HeroNode1 _9 = new HeroNode1(9, "死神");
        HeroNode1 _10 = new HeroNode1(10, "死神");
        _1.setLeft(_2);
        _1.setRight(_3);
        _2.setLeft(_4);
        _2.setRight(_5);
        _4.setLeft(_6);
        _3.setLeft(_7);
        _3.setRight(_8);
        _7.setLeft(_9);
        _7.setRight(_10);
        ThreadedBinaryTree threadedBinaryTree = new ThreadedBinaryTree(_1);
        threadedBinaryTree.threadedNodes(_1);
        System.out.println(_5.getRight());
        System.out.println("======遍历=====");
        threadedBinaryTree.listMidThreadeTree();
    }
}


@Setter
class ThreadedBinaryTree {
    //根节点
    private HeroNode1 root;
    //指向前一个节点，pre总是保留前一个节点
    private HeroNode1 pre;

    public ThreadedBinaryTree(HeroNode1 root) {
        this.root = root;
    }

    /**
     * 中序遍历线索化二叉树
     */
    public void listMidThreadeTree(){
        HeroNode1 node =root;
        while (node!=null){
            //循环找打leftType==1的节点，找到第一个
            while (node.getLeftType()==0){
                node = node.getLeft();
            }
            //打印当前节点
            System.out.println(node);
            //如果当前节点的右指针是后继节点，就一直输出
            while (node.getRightType() ==1){
                //获取到当前节点的后继节点
                node = node.getRight();
                System.out.println(node);
            }
            //替换这个节点便利
            node = node.getRight();
        }
    }
    /**
     * 中序线索化二叉树
     * 中序对节点进行线索化
     *
     * @param node 当前需要线索化的节点
     */
    public void threadedNodes(HeroNode1 node) {
        if (node == null) {
            return;
        }
        //一、先线索化左子树
        threadedNodes(node.getLeft());
        //二、begin*********线索化当前节点**********
        //1、处理当前节点的前驱节点
        if (node.getLeft() == null) {
            //让当前节点的左指针指向前驱节点
            node.setLeft(pre);
            node.setLeftType(1);
        }
        //2、处理后继节点
        if (pre != null && pre.getRight() == null) {
            //让前驱节点的右指针指向当前节点
            pre.setRight(node);
            //修改前驱节点的右指针类型
            pre.setRightType(1);
        }
        //每次处理一个节点之后，让当前节点是下一个节点的前驱节点
        pre = node;
        //**************end**************
        //三、线索化右子树
        threadedNodes(node.getRight());
    }

}

/**
 * 创建HeroNode节点
 */
@Getter
@Setter
class HeroNode1 {
    private int no;
    private String name;
    //默认null
    private HeroNode1 left;
    //默认null
    private HeroNode1 right;
    //如果leftType==0,表示左子树，如果为1表示指向前驱节点
    private int leftType;
    //如果rightType==0,表示右子树，如果为1表示指向后继节点
    private int rightType;

    @Override
    public String toString() {
        return "HeroNode1{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public HeroNode1(int no, String name) {
        this.no = no;
        this.name = name;
    }

}