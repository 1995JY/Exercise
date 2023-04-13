package sparseArray;

public class SparseArray {
    public static void main(String[] args) {

        /*
             黑子为1，蓝子为2
         0  0  0  0  0  0  0  0  0  0  0
         0  0  1  0  0  0  0  0  0  0  0
         0  0  0  2  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0  0  0  0
         0  0  0  0  2  0  0  0  0  0  0
         0  0  0  0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0  0  0  0
         0  0  0  0  0  0  0  0  0  0  0

         */
        //创建棋盘  黑子为1，蓝子为2，未落子为0
        int chessArray[][] = new int[11][11];
        chessArray[1][2] = 1;
        chessArray[2][3] = 2;
        chessArray[4][4] = 2;
        //打印棋盘
        for (int[] ints : chessArray) {
            for (int a : ints) {
                System.out.print(a + "\t");
            }
            System.out.println();
        }
        System.out.println("****************");
        int count = 0;
        // 统计棋盘元素个数
        for (int[] ints : chessArray) {
            for (int a : ints) {
                if (a != 0) {
                    count++;
                }
            }
        }
        System.out.println(count);
        int num = 0;
        //创建稀疏数组
        int[][] sparseArray = new int[count + 1][3];
        sparseArray[0][0] = 11;
        sparseArray[0][1] = 11;
        sparseArray[0][2] = 3;
        num++;
        // 给稀疏数组填充数据
        for (int i = 0; i < 11; i++) {
            for (int j = 0; j < 11; j++) {
                if (chessArray[i][j] != 0) {
                    sparseArray[num][0] = i;
                    sparseArray[num][1] = j;
                    sparseArray[num][2] = chessArray[i][j];
                    num++;
                }
            }
        }
        // 遍历打印稀疏数组
        for (int[] ints : sparseArray) {
            for (int a : ints) {
                System.out.print(a + "\t");
            }
            System.out.println();
        }
        System.out.println("****************");
        // 还原稀疏数组
        int[][] rebuildSparse = new int[sparseArray[0][0]][sparseArray[0][1]];
        for (int i = 1; i < sparseArray.length; i++) {
            rebuildSparse[sparseArray[i][0]][sparseArray[i][1]] = sparseArray[i][2];
        }
        // 打印还原后的数组
        for (int[] a : rebuildSparse) {
            for (int b : a) {
                System.out.print(b+"\t");
            }
            System.out.println();
        }
    }
}
