package 排序算法;

import java.util.Arrays;

/**
 * 冒泡排序（Bubble Sorting）的基本思想是：通过对待排序序列从前向后（从下标较小的元素开始）,依次比较
 * 相邻元素的值，若发现逆序则交换，使值较大的元素逐渐从前移向后部，就象水底下的气泡一样逐渐向上冒。
 *
 * 三种解决方案
 * 1、使用原始的，双重循环
 * 2、使用双重循环，由于第一次已经将最大的值求出来了，第二次又将第二大值求出来了，所以第二重循环每次循环次数都逐步递减。
 * 3、使用一个标记，由于在中途可能已经数组已经顺序排列好，后面的循环都是没有必要的，所以使用标记当某一次循环时候标记没
 *    有改变，则证明已经排列好，直接跳出。不执行后面循环操作
 *
 * 注意：使用了第三步，虽然遍历的次数变少了，但实际上所消耗的时间会变长。
 */
public class _1冒泡排序算法实现 implements BasicInterface {

    public void speedTest(){
        //  int[] array ={88,12,14,5,1,77,33,34,18,16,11,99,46,86,50,70,71,69,69,91,92,93};
        int[] array= CommonUtils.randomInt(80000);
        int temp =0;
        for (int j = 0; j < array.length-1; j++) {
            //此时减去j的目的是最后最大的一个数已经求出来了，就没有必要再比对了。
            for (int i = 0; i < array.length-1-j; i++) {
                if (array[i] > array[i + 1]) {
                    temp = array[i + 1];
                    array[i + 1] = array[i];
                    array[i] = temp;
                }
            }

        }
         System.out.println(Arrays.toString(array));
    }
}
