package 排序算法;

import org.testng.annotations.Test;

/**
 * 快速排序（Quicksort）是对冒泡排序的一种改进。基本思想是：通过一趟排序将要排序的数据分割成独立的两
 * 部分，其中一部分的所有数据都比另外一部分的所有数据都要小，然后再按此方法对这两部分数据分别进行快速排
 * 序，整个排序过程可以递归进行，以此达到整个数据变成有序序列
 * <p>
 * ps:时间换空间 ==一千八百万条只要3秒
 */
public class _5快速排序算法实现{
    @Test
    public void main() {
        long begin = System.currentTimeMillis();

        int[] array = CommonUtils.randomInt(18000000);
        quickSort(array, 0, array.length - 1);

        long end = System.currentTimeMillis();
        System.out.println(end - begin);
    }

    /**
     * 快速排序
     *
     * @param array 数组
     * @param left  左值
     * @param right 右值
     */
    public void quickSort(int[] array, int left, int right) {
        int l = left;
        int r = right;
        //选择一个中轴，一般是第一个。避免了运算。
        int pivot = array[(left + right) / 2];
        int temp = 0;
        while (l < r) {
            while (array[l] < pivot) {
                l++;
            }
            while (array[r] > pivot) {
                r--;
            }
            if (l >= r) {
                break;
            }
            temp = array[l];
            array[l] = array[r];
            array[r] = temp;

            // 这里的判断是为了当两个数中极端情况下等于 pivot 时候可以继续下去，不然就会形成死循环。永远得不到  l < r
            if (array[l] == pivot) {
                l++;
            }
            if (array[r] == pivot) {
                r--;
            }
        }
        //如果 l==r,必须l++,r--,否则为栈溢出。因为下面退出左右递归的条件是，left >=r,right<=l
        if (l == r) {
            l++;
            r--;
        }
        //向左递归 ====
        if (left < r) {
            quickSort(array, left, r);
        }
        //向右递归
        if (right > l) {
            quickSort(array, l, right);
        }
    }


}
