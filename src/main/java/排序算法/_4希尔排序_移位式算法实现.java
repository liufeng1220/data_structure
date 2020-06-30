package 排序算法;

import org.testng.annotations.Test;

/**
 * Created by liufeng on 2020/6/24 21:49
 * ps:一千百八万条五秒
 */
public class _4希尔排序_移位式算法实现 implements BasicInterface {
    @Test
    public void test() {
        CGLIB_DynamicAgency.run(this.getClass());
    }
    public void speedTest() {
        int[] array = CommonUtils.randomInt(18000000);
        for (int gap = array.length / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < array.length; i++) {
                int j = i;
                int temp = array[j];
                if (array[j] < array[j - gap]) {
                    while (j - gap >= 0 && temp < array[j - gap]) {
                        array[j] = array[j - gap];
                        j -= gap;
                    }
                    array[j] = temp;
                }
            }
        }
       // System.out.println(Arrays.toString(array));
    }

}
