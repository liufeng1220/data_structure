package 线性表.递归;

import org.testng.annotations.Test;

public class _1迷宫问题 {
    @Test
    public void test(){
        int total =0;
        int end =4;
        total = (1+end)*end/2;
        System.out.println(total);
    }
    public static void main(String[] args) {
        int[][] ints = new int[8][7];
        //上下为1
        for (int i = 0; i < 7; i++) {
            ints[0][i] = 1;
            ints[7][i] = 1;
        }
        //左右为1
        for (int i = 0; i < 8; i++) {
            ints[i][0] = 1;
            ints[i][6] = 1;
        }
        //设置挡板
        ints[3][1] = 1;
        ints[3][2] = 1;
        ints[2][2] = 1;
        //输出地图
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(ints[i][j] + "\t");
            }
            System.out.println();
        }

        //使用递归回溯给小球找路
        setWay(ints,1,1);

        System.out.println("=====回溯算法 小球走过后的路=========");
        for (int i = 0; i < ints.length; i++) {
            for (int j = 0; j < 7; j++) {
                System.out.print(ints[i][j] + "\t");
            }
            System.out.println();
        }
    }

    /**
     * 1.如果找到map[6][5]表示终点
     * 2.其中0表示没有走过，1表示墙体，2表示通路，3表示该点走过但是没有走通
     * 3.需要一个策略（方法）——先走下=》不通走右=》不通走上=》最后尝试左右
     *
     * @param map 表示地图
     * @param i   表示从地图哪个位置出发（1,1）
     * @param j
     * @return 如果找到通路返回true，否则false
     */
    public static boolean setWay(int[][] map, int i, int j) {
        //通路已经找到了
        if (map[6][5] == 2) {
            return true;
        } else {
            //如果这个点还没有走过
            if (map[i][j] == 0) {
                //按照策略走
                map[i][j] = 2; //先假定是可以走通的
                if (setWay(map, i + 1, j)) {  //向下走
                    return true;
                } else if (setWay(map, i, j + 1)) { //向右走
                    return true;
                } else if (setWay(map, i - 1, j)) {//向上走
                    return true;
                } else if (setWay(map, i, j - 1)) {//向左边走
                    return true;
                }else {
                    //说明该点走不通
                    map[i][j]=3;
                    return false;
                }
            }else { //如果map[i][j] != 0,可能是1,2,3
                return false;
            }
        }
    }


}
