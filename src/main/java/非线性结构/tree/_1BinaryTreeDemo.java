package 非线性结构.tree;

import lombok.*;
import org.testng.annotations.Test;

/**
 * 二叉树的三种遍历方法
 * 二叉树的查找
 * Created by liufeng on 2020/7/5 10:46
 */
public class _1BinaryTreeDemo {
    //遍历二叉树
    @Test
    public void test1() {
        HeroNode _1 = new HeroNode(1, "宋江");
        HeroNode _2 = new HeroNode(2, "张飞");
        HeroNode _3 = new HeroNode(3, "关羽");
        HeroNode _4 = new HeroNode(4, "网格");
        HeroNode _5 = new HeroNode(5, "中国");
        HeroNode _6 = new HeroNode(6, "死神");

        HeroNode _7 = new HeroNode(7, "死神");
        HeroNode _8 = new HeroNode(8, "死神");
        HeroNode _9 = new HeroNode(9, "死神");
        HeroNode _10 = new HeroNode(10, "死神");


        _1.setLeft(_2);
        _1.setRight(_3);
        _2.setLeft(_4);
        _4.setRight(_5);
        _4.setLeft(_6);
        _3.setLeft(_7);
        _3.setRight(_8);
        _7.setLeft(_9);
        _7.setRight(_10);
        BinaryTree binaryTree = new BinaryTree(_1);
        System.out.println("前缀遍历");
        binaryTree.preOrder();
        System.out.println("zhong缀遍历");
        binaryTree.midOrder();
        System.out.println("后缀遍历");
        binaryTree.postOrder();

    }

    //查找二叉树中某个元素位置
    @Test
    public void test2() {
        HeroNode _1 = new HeroNode(1, "宋江");
        HeroNode _2 = new HeroNode(2, "张飞");
        HeroNode _3 = new HeroNode(3, "关羽");
        HeroNode _4 = new HeroNode(4, "网格");
        HeroNode _5 = new HeroNode(5, "中国");
        HeroNode _6 = new HeroNode(6, "死神");

        _1.setLeft(_2);
        _1.setRight(_3);
        _2.setLeft(_4);
        _4.setRight(_5);
        _4.setLeft(_6);
        BinaryTree binaryTree = new BinaryTree(_1);

        System.out.println(binaryTree.proOrderSearch(2));
        System.out.println(binaryTree.midOrderSearch(2));
        System.out.println(binaryTree.postOrderSearch(12));
    }

    //删除节点
    @Test
    public void test3() {

        HeroNode _1 = new HeroNode(1, "宋江");
        HeroNode _2 = new HeroNode(2, "张飞");
        HeroNode _3 = new HeroNode(3, "关羽");
        HeroNode _4 = new HeroNode(4, "网格");
        HeroNode _5 = new HeroNode(5, "中国");
        HeroNode _6 = new HeroNode(6, "死神");

        _1.setLeft(_2);
        _1.setRight(_3);
        _2.setLeft(_4);
        _4.setRight(_5);
        _4.setLeft(_6);
        BinaryTree binaryTree = new BinaryTree(_1);
        binaryTree.preOrder();

        binaryTree.deleteNode(4);
        System.out.println("删除后");
        binaryTree.preOrder();


    }
}

@Setter
@AllArgsConstructor
class BinaryTree {
    //根节点
    private HeroNode root;

    /**
     * 删除节点
     * <p>
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点是非叶子节点，则删除该子树
     *
     * @param no 要删除的节点名称
     */
    public void deleteNode(int no) {

        if (this.root != null && this.root.getNo() == no) {
            this.root = null;

        } else {
            this.root.deleteNode(no);
        }
    }


    /**
     * 删除非叶子节点
     * <p>
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点是非叶子节点，则删除该子树
     *
     * @param no 要删除的节点名称
     */
    public void deleteNonleafNode(int no) {

        if (this.root != null && this.root.getNo() == no) {
            this.root = null;

        } else {
            this.root.deleteNonleafNode(no);
        }
    }


    /**
     * 前序遍历
     * 先输出父节点，再遍历左子树和右子树
     */
    public void preOrder() {
        if (this.root != null) {
            this.root.preOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 中序遍历
     * 先遍历左子树，再输出父节点，再遍历右子树
     */
    public void midOrder() {
        if (this.root != null) {
            this.root.midOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }
    }

    /**
     * 后续遍历
     * 先遍历左子树，再遍历右子树，最后输出父节点
     */
    public void postOrder() {
        if (this.root != null) {
            this.root.postOrder();
        } else {
            System.out.println("二叉树为空，无法遍历");
        }

    }

    /**
     * 前置遍历查找指定元素
     *
     * @param no 英雄编号
     * @return 找到就返回该元素，没有找到返回null
     */
    public HeroNode proOrderSearch(int no) {
        return this.root.proOrderSearch(no);
    }

    /**
     * 中置遍历查找指定元素
     *
     * @param no 英雄编号
     * @return 找到就返回该元素，没有找到返回null
     */
    public HeroNode midOrderSearch(int no) {
        return this.root.midOrderSearch(no);
    }

    /**
     * 后置遍历查找指定元素
     *
     * @param no 英雄编号
     * @return 找到就返回该元素，没有找到返回null
     */
    public HeroNode postOrderSearch(int no) {
        return this.root.postOrderSearch(no);
    }

}

/**
 * 创建HeroNode节点
 */
@Getter
@Setter
class HeroNode {
    private int no;
    private String name;
    //默认null
    private HeroNode left;
    //默认null
    private HeroNode right;

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }

    public HeroNode(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 前序遍历
     * 先输出父节点，再遍历左子树和右子树
     */
    public void preOrder() {
        System.out.println(this);
        if (left != null) {
            this.left.preOrder();
        }
        if (right != null) {
            this.right.preOrder();
        }
    }

    /**
     * 中序遍历
     * 先遍历左子树，再输出父节点，再遍历右子树
     */
    public void midOrder() {
        if (this.left != null) {
            this.left.midOrder();
        }
        System.out.println(this);
        if (this.right != null) {
            this.right.midOrder();
        }
    }

    /**
     * 后续遍历
     * 先遍历左子树，再遍历右子树，最后输出父节点
     */
    public void postOrder() {
        if (this.left != null) {
            this.left.postOrder();
        }

        if (this.right != null) {
            this.right.postOrder();
        }
        System.out.println(this);

    }

    /**
     * 前置遍历查找指定元素
     *
     * @param no 英雄编号
     * @return 找到就返回该元素，没有找到返回null
     */
    public HeroNode proOrderSearch(int no) {
        if (this.no == no) {
            return this;
        }
        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.proOrderSearch(no);
        }
        //说明我们左子树找到了，直接返回，就不用在遍历右子树
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.proOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 中置遍历查找指定元素
     *
     * @param no 英雄编号
     * @return 找到就返回该元素，没有找到返回null
     */
    public HeroNode midOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.midOrderSearch(no);
        }
        //说明我们左子树找到了，直接返回，就不用在遍历右子树
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        if (this.right != null) {
            resNode = this.right.midOrderSearch(no);
        }
        return resNode;
    }

    /**
     * 后置遍历查找指定元素
     *
     * @param no 英雄编号
     * @return 找到就返回该元素，没有找到返回null
     */
    public HeroNode postOrderSearch(int no) {

        HeroNode resNode = null;
        if (this.left != null) {
            resNode = this.left.postOrderSearch(no);
        }
        //说明我们左子树找到了，直接返回，就不用在遍历右子树
        if (resNode != null) {
            return resNode;
        }
        if (this.right != null) {
            resNode = this.right.postOrderSearch(no);
        }
        //说明我们右子树找到了，直接返回，就不用在判断当前父节点了
        if (resNode != null) {
            return resNode;
        }
        if (this.no == no) {
            return this;
        }
        return resNode;
    }

    /**
     * 删除节点
     * <p>
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点是非叶子节点，则删除该子树
     *
     * @param no 要删除的节点名称
     */
    public void deleteNode(int no) {


        if (this.left != null && this.left.no == no) {
            this.left = null;
            return;
        }

        if (this.right != null && this.right.no == no) {
            this.right = null;
            return;
        }
        //遍历左子树
        if (this.left != null) {
            this.left.deleteNode(no);
        }
        //遍历右子树
        if (this.right != null) {
            this.right.deleteNode(no);
        }

    }

    /**
     * 删除非叶子节点
     * <p>
     * 1.如果删除的节点是叶子节点，则删除该节点
     * 2.如果删除的节点是非叶子节点，则删除该子节点，非叶子节点的左子节点代替
     *
     * @param no 要删除的节点名称
     */
    public void deleteNonleafNode(int no) {

        //删除左子树
        if (this.left != null && this.left.no == no) {
            if (this.left.left != null) {
                this.left = this.left.left;
            } else {
                this.left = null;
            }
            return;
        }

        if (this.right != null && this.right.no == no) {
            if (this.right.left != null) {
                this.right = this.right.left;
            } else {
                this.right = null;
            }
            return;
        }
        //遍历左子树
        if (this.left != null) {
            this.left.deleteNonleafNode(no);
        }
        //遍历右子树
        if (this.right != null) {
            this.right.deleteNonleafNode(no);
        }

    }
}