package 查找算法;

import java.util.ArrayList;

/**
 * 二分/折半 查找算法
 * 注意：该查找算法要求，查找时候一定是有序的。。。。否则不能使用
 * Created by liufeng on 2020/6/30 15:14
 */
public class _2二分查找算法实现 {
    public static void main(String[] args) {
        int[] array = {1, 44, 44, 55, 66, 76, 87, 89};
        System.out.println(binarySeach2(array, 0, array.length - 1, 111));
    }

    /**
     * 二分查找====单个查找
     *
     * @param array   原始数组
     * @param left    左索引
     * @param right   右索引
     * @param findVal 要查找的值
     * @return 如果找到返回要查找的值，如果没找到返回-1
     */
    public static int binarySeach(int[] array, int left, int right, int findVal) {
        int mid = (left + right) / 2;
        //没有找到时候推出
        if (left > right) {
            return -1;
        }
        if (findVal < array[mid]) {
            //向左递归
            return binarySeach(array, left, mid - 1, findVal);
        } else if (findVal > array[mid]) {
            //向右递归
            return binarySeach(array, mid + 1, right, findVal);
        } else {
            return mid;
        }
    }

    /**
     * 二分查找====多个查找
     *
     * @param array   原始数组
     * @param left    左索引
     * @param right   右索引
     * @param findVal 要查找的值
     * @return 如果找到返回要查找的值，如果没找到返回null
     */
    public static ArrayList binarySeach2(int[] array, int left, int right, int findVal) {
        ArrayList<Integer> list = new ArrayList<Integer>();
        int mid = (left + right) / 2;
        if (left > right) {
            return null;
        }
        if (findVal < array[mid]) {
            //向左递归
            return binarySeach2(array, left, mid - 1, findVal);
        } else if (findVal > array[mid]) {
            //向右递归
            return binarySeach2(array, mid + 1, right, findVal);
        } else {
            //继续向左查找
            int temp = mid - 1;
            while (true) {
                if (temp < 0 || array[temp] != findVal) {   //退出
                    break;
                }
                list.add(temp);
                temp -= 1;
            }
            //保存中间数
            list.add(mid);
            //继续向右查找
            temp = mid + 1;
            while (true) {
                if (temp > array.length - 1 || array[temp] != findVal) {   //退出
                    break;
                }
                list.add(temp);
                temp += 1;
            }
            return list;
        }
    }

}