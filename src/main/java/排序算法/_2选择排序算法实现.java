package 排序算法;

/**
 * 选择式排序也属于内部排序法，是从欲排序的数据中，按指定的规则选出某一元素，再依规定交换位置后达到
 * 排序的目的。
 *
 * 基本思想是：第一次从 arr[0]~arr[n-1]中选取最小值，
 * 与 arr[0]交换，第二次从 arr[1]~arr[n-1]中选取最小值，与 arr[1]交换，第三次从 arr[2]~arr[n-1]中选取最小值，与  arr[2]
 * 交换，…，第 i次从  arr[i-1]~arr[n-1]中选取最小值，与 arr[i-1]交换，…,第  n-1次从  arr[n-2]~arr[n-1]中选取最小值，
 * 与 arr[n-2]交换，总共通过 n-1次，得到一个按排序码从小到大排列的有序序列。
 *
 * ps: 选择排序所消耗的时间远比冒泡排序消耗的时间少
 */
public class _2选择排序算法实现 implements BasicInterface {

    public void speedTest() {
        // int[] array = {11, 2, 1, 55, 6, 7, 88, 87};
        int[] array = CommonUtils.randomInt(80000);
        for (int j = 0; j < array.length; j++) {
            int minIndex = j;
            //首先假定一个最小值
            int minValue = array[j];
            for (int i = j + 1; i < array.length; i++) {
                //当假定的最小值大于遍历到的当前数值时候，将当前值赋值给最小值，当前值的下标赋值给minIndex
                if (minValue > array[i]) {
                    minIndex = i;
                    minValue = array[i];
                }
            }
            //经过一次循环后，如果最小值的下标发生了改变，证明有值比假定的最小值还要小，即两者交换位置
            if (minIndex != j) {
                array[minIndex] = array[j];
                array[j] = minValue;
            }

        }
        //System.out.println(Arrays.toString(array));

    }

}
