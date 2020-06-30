package 排序算法;

import org.testng.annotations.Test;

import java.util.Arrays;

/**
 * 1)基数排序（radix    sort）属于“分配式排序”（distribution sort），又称“桶子法”（bucket sort）或 bin sort，顾
 * 名思义，它是通过键值的各个位的值，将要排序的元素分配至某些“桶”中，达到排序的作用
 * 2)基数排序法是属于稳定性的排序，基数排序法的是效率高的稳定性排序法
 * <p>
 * 3)基数排序(Radix    Sort)是桶排序的扩展
 *
 * <p>
 * 基数排序基本思想
 * 1)将所有待比较数值统一为同样的数位长度，数位较短的数前面补零。然后，从最低位开始，依次进行一次排序。
 * 这样从最低位排序一直到最高位排序完成以后,数列就变成一个有序序列。
 *
 * <p>
 * ps:
 * 1)基数排序是对传统桶排序的扩展，速度很快.
 * 2)基数排序是经典的空间换时间的方式，占用内存很大,当对海量数据排序时，容易造成      OutOfMemoryError。
 * 3)基数排序时稳定的。[注:假定在待排序的记录序列中，存在多个具有相同的关键字的记录，若经过排序，这些
 * 记录的相对次序保持不变，即在原序列中，r[i]=r[j]，且 r[i]在 r[j]之前，而在排序后的序列中，r[i]仍在 r[j]之前，
 * 则称这种排序算法是稳定的；否则称为不稳定的]
 */
public class _7基数排序算法实现 implements BasicInterface {

    @Test
    public void test() {
        CGLIB_DynamicAgency.run(this.getClass());
    }

    public void speedTest() {

        int[] array = CommonUtils.randomInt(800000);

        //1、得到数组中最大的位数
        int max = array[0];
        for (int i = 0; i < array.length; i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        //2、得到最大的位数
        int maxLengh = (max + "").length();

        //3、定义一个二位数组，表示10个桶，每个桶就是一个一维数组，每个一维数组中存放固定位数的数
        int[][] bucket = new int[10][array.length];
        //4、定义一个一维数组，记录每个桶实际存放的个数
        int[] bucketElementCounts = new int[10];

        for (int i = 0, n = 1; i < maxLengh; i++, n *= 10) {

            for (int j = 0; j < array.length; j++) {
                //取出每一个元素对应位的值 如：234 个位是4，十位是3...
                int digitOfElement = array[j] / n % 10;
                //放去对应的桶中 如用 234 用个位举例： 存入4号桶的第 bucketElementCounts[digitOfElement] 个位置，该值会变化。
                bucket[digitOfElement][bucketElementCounts[digitOfElement]] = array[j];
                //将digitOfElement下标处的元素个数加1
                bucketElementCounts[digitOfElement]++;
            }
            // index 是 array的下标索引 ‘’按照这个桶的顺序(一维数组的下标依次取出数据，放入原来数组)
            int index = 0;
            for (int k = 0; k < bucketElementCounts.length; k++) {
                //如果桶中有数据，才放入原数组中
                if (bucketElementCounts[k] != 0) {
                    //循环该桶即第 k个桶(即第 k个一维数组),放入
                    for (int l = 0; l < bucketElementCounts[k]; l++) {
                        array[index++] = bucket[k][l];
                    }
                }
                //第 i+1轮处理后，需要将每个  bucketElementCounts[k] = 0！！！！
                bucketElementCounts[k] = 0;
            }
        }

    }

}
