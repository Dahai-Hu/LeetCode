package aimoffer;

/**
 * @hurusea
 * @create2020-03-20 9:10
 */
public class findNumberIn2DArray {


    /**
     *
     * @param matrix
     * @param target
     * @return
     * 1.定义temp维度为1*1，对于一个n*m的matrix矩阵，先从矩阵最小值matrix[i][j]开始判断，
     * 2.如果target等于matrix[i][j]，break，return true
     *    2.1如果target大于matrix[i][j]，i++，j++，
     *    2.2如果target小于matrix[i][j]，遍历最后一行和列
     *        2.2.1  如果存在，return true
     *        2.2.1  如果不存在，return false
     */
    public boolean findNumberIn2DArray(int[][] matrix, int target) {
        for (int i = 0; i <matrix.length ; i++) {
            for (int j = 0; j <matrix[i].length ; j++) {
                if (target==matrix[i][j]){
                    return true;
                } else if (target>matrix[i][j]) {
                    System.out.println("需要下一步扩容");
                }else{
                    for (int k = 0; k <j; k++) {
                        if (target==matrix[i][k]){
                            return true;
                        }
                    }
                    for (int k = 0; k <i; k++) {
                        if (target==matrix[k][j]){
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
