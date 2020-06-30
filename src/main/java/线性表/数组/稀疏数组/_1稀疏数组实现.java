package 线性表.数组.稀疏数组;

import org.testng.annotations.Test;

public class _1稀疏数组实现 {
    @Test
    public void test1() {
        int[][] array = new int[8][9];
        this.createArray(array);
        //二维数组转稀疏数组
        int[][] sparse = this.arrayToSparse(array);
        //稀疏数组转二维数组
        int[][] array2 = this.sparseToArray(sparse);
        //打印
        this.printArray(array);
        this.printArray(sparse);
        this.printArray(array2);

    }

    /**
     * 创建二维数组
     *
     * @param array
     */
    public void createArray(int[][] array) {
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 9; j++) {
                array[i][j] = 0;
            }
        }
        array[0][3] = 23;
        array[2][5] = 77;
        array[2][8] = 8;
        array[5][5] = 14;
        array[7][1] = 11;


    }

    /**
     * 二维数组转稀疏数组
     *
     * @param array
     */
    public int[][] arrayToSparse(int[][] array) {
        //二维数组有效元素个数
        int sum = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0) {
                    sum++;
                }
            }
        }
        int[][] sparseArray = new int[sum + 1][3];
        //保存原有二维数组的行
        sparseArray[0][0] = array.length;
        //保存原有二维数组的列
        sparseArray[0][1] = array[0].length;
        //保存原有二维数组的有效个数
        sparseArray[0][2] = sum;

        int row = 1;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[0].length; j++) {
                if (array[i][j] != 0) {
                    sparseArray[row][0] = i;
                    sparseArray[row][1] = j;
                    sparseArray[row][2] = array[i][j];
                    row++;
                }
            }
        }
        return sparseArray;
    }

    public int[][] sparseToArray(int[][] sparse) {
        int[][] array = new int[sparse[0][0]][sparse[0][1]];
        for (int i = 1; i < sparse.length; i++) {
            array[sparse[i][0]][sparse[i][1]] = sparse[i][2];
        }
        return array;

    }

    /**
     * 打印二维数组
     *
     * @param array
     */
    public void printArray(int[][] array) {
        for (int[] ints : array) {
            for (int anInt : ints) {
                System.out.print(anInt + "\t");
            }
            System.out.println();
        }
        System.out.println();
    }
}
