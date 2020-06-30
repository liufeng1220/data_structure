package 排序算法;

import org.testng.annotations.Test;

/**
 * 希尔排序是希尔（Donald Shell）于 1959年提出的一种排序算法。希尔排序也是一种插入排序，它是简单插入排序经过改进之后的一个更高效的版本，也称为缩小增量排序。
 *
 * 希尔排序 [交换式] 实现
 * 缩小增量排序======
 * 是将整个数组分组，除以2，使用直接插入算法交换位置后,再分组 /2,以此类推，直至增量缩减到1后进行最后一次排序后终止
 * <p>
 * ps:此方法思想虽好，但是使用交换式算法实际效果大不如人意，与插入排序相差甚远。所以使用移位式
 */
public class _4希尔排序_交换式算法实现 implements BasicInterface {

    @Test
    public void test() {
        CGLIB_DynamicAgency.run(this.getClass());
    }

    public void speedTest() {
        int temp = 0;
         int[] array = CommonUtils.randomInt(80000);
        //对当前数组除以2，以此类推，直至到最后
        for (int step = array.length / 2; step > 0; step /= 2) {
            //得到当前数量的一半，开始自增
            for (int i = step; i < array.length; i++) {
                //以每次一半的固定步长，获得与之相对的数据进行比较，如果前面的数据大于后面的数据，则两者交换位置。
                for (int j = i - step; j >= 0; j -= step) {
                    if (array[j] > array[j + step]) {
                        temp = array[j];
                        array[j] = array[j + step];
                        array[j + step] = temp;
                    }
                }
            }
        }

    }

}
