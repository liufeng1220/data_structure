package 排序算法;

/**
 * Created by liufeng on 2020/6/21 19:45
 */
public class CommonUtils {
    /**
     * 返回一个指定位数的随机整数数组
     *
     * @param num
     * @return
     */
    public static int[] randomInt(int num) {
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = (int) (Math.random() * num) + 1;
        }
        return array;
    }

    /**
     * 返回代码所花费的时间
     * @return
     */
    public static long spendTime() {
        long begin = System.currentTimeMillis();


        long end = System.currentTimeMillis();
        return begin - end;
    }
}
