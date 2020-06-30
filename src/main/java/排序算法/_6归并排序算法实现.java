package 排序算法;

import java.util.Arrays;

/**
 * 归并排序（MERGE-SORT）是利用归并的思想实现的排序方法，该算法采用经典的分治（divide-and-conquer）
 * 策略（分治法将问题分(divide)成一些小的问题然后递归求解，而治(conquer)的阶段则将分的阶段得到的各答案"修
 * 补"在一起，即分而治之)。
 * <p>
 * ps:速度可以和快速排序披靡
 */
public class _6归并排序算法实现 {
    public static void main(String[] args) {
        int[] array = {8, 3, 2, 7, 4, 1, 9, 6, 5};
        int[] temp = new int[array.length];
        mergeSort(array, 0, array.length - 1, temp);
        System.out.println(Arrays.toString(array));
    }

    /**
     * 分 + 合
     *
     * @param array 原始数组
     * @param left  左索引，默认为0
     * @param right 右索引，固定传入默认数组的最大下标
     * @param temp  临时数组
     */
    public static void mergeSort(int[] array, int left, int right, int[] temp) {
        if (left < right) {
            int mid = (left + right) / 2;
            //向左递归分解
            mergeSort(array, left, mid, temp);
            //向右递归分解
            mergeSort(array, mid + 1, right, temp);
            //合并
            merge(array, left, mid, right, temp);
        }
    }

    /**
     * 合并的方法
     *
     * @param array 原始数组
     * @param left  左边有序序列的索引
     * @param mid   中间索引
     * @param right 右边索引
     * @param temp  中转数组
     */
    public static void merge(int[] array, int left, int mid, int right, int[] temp) {
        int i = left; //左边有序序列的初始索引
        int j = mid + 1; //右边有序序列的初始索引
        int t = 0;//临时数组temp的索引

        //1、先把左右两边的（有序）数据填充到temp数组。
        while (i <= mid && j <= right) {
            //如果左边数大于右边数，将左边的数据存入临时数组temp,左边索引和临时数组的索引都加 1
            //如果右边数大于左边数，将右边的数据存入临时数组temp,右边索引和临时数组的索引都加 1
            if (array[i] <= array[j]) {
                temp[t] = array[i];
                i++;
                t++;
            } else {
                temp[t] = array[j];
                j++;
                t++;
            }
        }
        //2、把剩余数据一次性填充到temp
        while (i <= mid) {
            temp[t] = array[i];
            i++;
            t++;
        }
        while (j <= right) {
            temp[t] = array[j];
            j++;
            t++;
        }
        //3.将temp拷贝回原始数组array
        t = 0;
        int tempLeft = left;
        while (tempLeft <= right) {
            array[tempLeft] = temp[t];
            t++;
            tempLeft++;
        }
    }
}
