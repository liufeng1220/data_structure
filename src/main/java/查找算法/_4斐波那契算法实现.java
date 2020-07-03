package 查找算法;

import java.util.Arrays;

/**
 * Created by liufeng on 2020/6/30 15:14
 */
public class _4斐波那契算法实现 {
    public static int[] getFibonacciList(){
        int[] array=new int[20];
        array[0]=1;
        array[1]=1;
        for (int i = 2; i <array.length ; i++) {
            array[i]=array[i-1]+array[i-2];
        }
        return array;
    }

    public static void main(String[] args) {
        System.out.println(Arrays.toString(getFibonacciList()));
    }
}
