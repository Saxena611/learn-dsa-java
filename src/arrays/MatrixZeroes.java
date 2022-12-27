package arrays;

import java.util.Arrays;

public class MatrixZeroes {

    /**
     * Input:
     * matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]
     *
     * Output:
     * [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
     *
     * Explanation:
     * Since matrix[0][0]=0 and matrix[0][3]=0.
     * Therefore, 1st row, 1st column and 4th column will be set to 0.
     *
     * */
    public static void main(String[] args) {

        int[][] matrix = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        System.out.println(Arrays.toString(setZeroes(matrix)));
    }

    private static int[][] setZeroes(int[][] matrix) {
        int rows = matrix.length, cols = matrix[0].length;
        int dummy1[]=new int[rows];
        int dummy2[]=new int[cols];
        Arrays.fill(dummy1,-1);
        Arrays.fill(dummy2,-1);
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (matrix[i][j] == 0) {
                    dummy1[i] = 0;
                    dummy2[j] = 0;
                }
            }

        }
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (dummy1[i] == 0 || dummy2[j]==0) {
                    matrix[i][j] = 0;
                }
            }
        }
        return matrix;
    }
}
