package 排序算法;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 1)堆排序是利用堆这种数据结构而设计的一种排序算法，堆排序是一种选择排序，它的最坏，最好，平均时间复
 * 杂度均为 O(nlogn)，它也是不稳定排序。
 * 2)堆是具有以下性质的完全二叉树：每个结点的值都大于或等于其左右孩子结点的值，称为大顶堆,注意:没有要求结点的左孩子的值和右孩子的值的大小关系。
 * 3)每个结点的值都小于或等于其左右孩子结点的值，称为小顶堆
 * 一般升序采用大顶堆，降序采用小顶堆
 * <p>
 * 堆排序的基本思想是：
 * 1)将待排序序列构造成一个大顶堆
 * 2)此时，整个序列的最大值就是堆顶的根节点。
 * 3)将其与末尾元素进行交换，此时末尾就为最大值。
 * 4)然后将剩余    n-1个元素重新构造成一个堆，这样会得到  n个元素的次小值。如此反复执行，便能得到一个有序序列了。
 * 可以看到在构建大顶堆的过程中，元素的个数逐渐减少，最后就得到一个有序序列了.
 * <p>
 * ps:完全二叉树的最后一个非叶子节点的计算方式 arr.length/2-1
 * <p>
 * Created by liufeng on 2020/6/21 16:54
 */
public class _8堆排序算法实现 {
    @Test
    public void test(){
        speedTest();
    }

    public void speedTest() {
        int[] arr ={34,55,9,5,12,1};
        int temp = 0;
        System.out.println("堆排序");
        for (int i = arr.length / 2 - 1; i >= 0; i--) {
            adjustHeap(arr, i, arr.length);
        }
        System.out.println("打印"+Arrays.toString(arr));
        for (int j = arr.length - 1; j > 0; j--) {
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr, 0, j);
        }
        System.out.println(Arrays.toString(arr));
    }

    /**
     * 将一个数组转换成一个大顶堆
     *
     * @param arr    将调整的数组
     * @param i      非叶子节点在数组中的索引
     * @param length 表示有多少个元素继续调整，length会逐渐减少
     */
    public void adjustHeap(int[] arr, int i, int length) {
        int temp = arr[i];
        //k =i*2+1是i节点的左子节点
        for (int k = i * 2 + 1; k < arr.length; k = k * 2 + 1) {
            //当左子节点小于右子节点的时候
            if (k + 1 < length && arr[k] < arr[k + 1]) {
                k++;    //将k指向右子节点
            }
            //如果子节点大于父节点
            if (arr[k] > temp) {
                arr[i] = arr[k];
                i = k;
            } else {
                break;
            }
        }
        //当for循环结束，将最开始以i为父节点的最大值，放到最顶端
        arr[i] = temp;
    }


}
