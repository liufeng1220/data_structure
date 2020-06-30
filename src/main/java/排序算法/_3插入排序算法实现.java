package 排序算法;

import org.testng.annotations.Test;

/**
 * 插入式排序属于内部排序法，是对于欲排序的元素以插入的方式找寻该元素的适当位置，以达到排序的目的。
 * <p>
 * 插入排序（Insertion Sorting）的基本思想是：把 n个待排序的元素看成为一个有序表和一个无序表，开始时有
 * 序表中只包含一个元素，无序表中包含有 n-1个元素，排序过程中每次从无序表中取出第一个元素，把它的排
 * 序码依次与有序表元素的排序码进行比较，将它插入到有序表中的适当位置，使之成为新的有序表。
 * <p>
 * 看成一个有序表和无序表，开始有序表中只有一个元素。无序表中有n-1个元素
 * 每次从无序表中取出一个数字，和有序表的元素进行从后往前对比。选择合适的位置插入。
 * <p>
 * 如果需要从大到小排序，只需要将while判断时候的条件从小于号变成大于号。
 * <p>
 * ps:插入排序的速度比冒泡，选择排序都要更快。
 */
public class _3插入排序算法实现 implements BasicInterface {

    @Test
    public void test() {
        CGLIB_DynamicAgency.run(this.getClass());
    }

    public void speedTest() {
        // int[] array = {101, 34, 119, 116, 113, 12, -20, 78};
        int[] array = CommonUtils.randomInt(80000);

        int insertVal;  //定义将要插入有序表的值
        int insertIndex; //要插入的位置

        for (int i = 1; i < array.length; i++) {
            insertVal = array[i];
            insertIndex = i - 1;

            while (insertIndex >= 0 && insertVal < array[insertIndex]) {
                array[insertIndex + 1] = array[insertIndex];
                insertIndex--;
            }

            array[insertIndex + 1] = insertVal;
        }
        //  System.out.println(Arrays.toString(array));
    }
}
