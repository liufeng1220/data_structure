package 线性表.数组.稀疏数组;

import org.testng.annotations.Test;
import org.yaml.snakeyaml.reader.StreamReader;

import java.io.*;

public class _2稀疏数组存文件实现 {
    @Test
    public void test1() throws IOException {

        int[][] array = new int[8][9];
        this.createArray(array);
        //打印创建的二维数组
        this.printArray(array);


        //二维数组转稀疏数组存入文件
        this.arrayToSparse(array);
        //读取文件中的稀疏数组转二维数组
        int[][] array2 = this.sparseToArray();
        //打印存入磁盘后的稀疏数组后再从磁盘读取出来的二维数组
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
     * 二维数组转稀疏数组存入文件
     *
     * @param array
     */
    public void arrayToSparse(int[][] array) throws IOException {
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
        //1、保存原有二维数组的行
        sparseArray[0][0] = array.length;
        //2、保存原有二维数组的列
        sparseArray[0][1] = array[0].length;
        //3、保存原有二维数组的有效个数
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
        //创建文件存入
        /* File file = new File("D:\\MyIdea\\data_structure\\src\\main\\resources\\sparse.txt");
           file.createNewFile();*/

        FileWriter fileWriter = new FileWriter("D:\\MyIdea\\data_structure\\src\\main\\resources\\sparse.txt", true);
        for (int[] ints : sparseArray) {
            for (int anInt : ints) {
                fileWriter.write(String.valueOf(anInt) + "\t");
            }
            fileWriter.write("\n");
        }
        fileWriter.flush();
        fileWriter.close();
    }

    /**
     * 读取文件中的稀疏数组转二维数组
     *
     * @return
     */
    public int[][] sparseToArray() throws IOException {
        BufferedReader read = new BufferedReader(new FileReader("D:\\MyIdea\\data_structure\\src\\main\\resources\\sparse.txt"));

        //1、读取文件中稀疏数组第一行恢复创建二维数组
        String line = read.readLine();
        String[] split = line.split("\t");
        int[][] array = new int[Integer.valueOf(split[0])][Integer.valueOf(split[1])];
        // end

        //2、读取文件中每一行的输入，恢复值存入二维数组中
        while ((line = read.readLine()) != null) {
            split = line.split("\t");
            array[Integer.valueOf(split[0])][Integer.valueOf(split[1])] = Integer.valueOf(split[2]);
        }
        read.close();
        //end


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
