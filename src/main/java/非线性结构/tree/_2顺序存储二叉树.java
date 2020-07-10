package 非线性结构.tree;

/**
 * 顺序二叉树的遍历，前序、中序、后序遍历。
 * <p>
 * 1)顺序二叉树通常只考虑完全二叉树
 * 2)第    n个元素的左子节点为    2 * n + 1
 * 3)第    n个元素的右子节点为    2 * n + 2
 * 4)第    n个元素的父节点为    (n-1) / 2
 * 5)   n :表示二叉树中的第几个元素(按  0开始编号如图所示)
 * <p>
 * <p>
 * Created by liufeng on 2020/7/7 10:55
 */
public class _2顺序存储二叉树 {
    public static void main(String[] args) {
        int[] array = {1, 2, 3, 4, 5, 6, 7};
        ArrBinaryTree arrBinaryTree = new ArrBinaryTree(array);
        arrBinaryTree.proOrderList();
    }

}

class ArrBinaryTree {
    private int[] array;

    public ArrBinaryTree(int[] array) {
        this.array = array;
    }

    public void proOrderList() {
        this.proOrderList(0);
    }

    /**
     * 顺序二叉树的前序遍历
     *
     * @param index 数组的下标
     */
    public void proOrderList(int index) {
        if (array == null || array.length == 0) {
            System.out.println("数组为空");
            return;
        }
        System.out.println(array[index]);
        //向左递归遍历查找
        if (index * 2 + 1 < array.length) {
            proOrderList(index * 2 + 1);
        }
        //向右递归遍历查找
        if (index * 2 + 2 < array.length) {
            proOrderList(index * 2 + 2);
        }

    }
}
