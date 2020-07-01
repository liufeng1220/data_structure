package 查找算法;

/**
 * 线性/顺序======查找算法实现
 * 数列有序无序无所谓
 * Created by liufeng on 2020/6/30 15:14
 */
public class _1线性_顺序查找算法实现 {
    public static void main(String[] args) {
        int arr[] = {1, 9, 11, -1, 34, 89};//没有顺序的数组
        int index = seqSearch(arr, -11);
        if (index == -1) {
            System.out.println("没有找到到");
        } else {
            System.out.println("找到，下标为=" + index);
        }

    }

    /**
     * 这里我们实现的线性查找是找到一个满足条件的值，就返回
     * 如果是多个，找到存入数组后继续查找直到最后
     *
     * @param arr
     * @param value
     * @return
     */
    public static int seqSearch(int[] arr, int value) {
        //线性查找是逐一比对，发现有相同值，就返回下标
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == value) {
                return i;
            }
        }
        return -1;
    }
}


