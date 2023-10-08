package matrix;

import java.util.ArrayList;
import java.util.Arrays;

public class SetMatrixZeroes {

    static void markRow(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        for (int i = 0; i < col; i++) {
            if (matrix.get(row).get(i) != 0) {
                matrix.get(row).set(i, -1);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> zeroMatrix(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        for (int i = 0; i <  row ; i ++) {
            for (int j = 0; j < col; j++) {
                if (matrix.get(i).get(j) == 0) {
                    markRow(matrix, i, col);
                    markCol(matrix, j, row);
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0;  j < col; j++) {
                if (matrix.get(i).get(j) == -1) {
                    matrix.get(i).set(j, 0);
                }
            }
        }
        return matrix;
    }

    private static void markCol(ArrayList<ArrayList<Integer>> matrix, int col, int row) {
        for (int i = 0; i < row; i++) {
            if (matrix.get(i).get(col) != 0) {
                matrix.get(i).set(col, -1);
            }
        }
    }

    static ArrayList<ArrayList<Integer>> setZeroesOptimal(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        int[] n_row = new int[row];
        int[] m_col = new int[col];

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix.get(row).get(col) == 0) {
                    n_row[i] = 1;
                    m_col[j] = 1;
                }
            }
        }

        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (n_row[i] == 1 || m_col[j] == 1) {
                    matrix.get(i).set(0, j);
                }
            }
        }
        return matrix;
    }

    static ArrayList<ArrayList<Integer>> setZeroesMostOptimal(ArrayList<ArrayList<Integer>> matrix, int row, int col) {
        int col0 = 0;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (matrix.get(i).get(j) == 0) {
                    matrix.get(i).set(0, 0);
                    if (j != 0) {
                        matrix.get(0).set(j, 0);
                    } else {
                        col0 = 0;
                    }
                }
            }
        }

        for (int i = 1; i < row; i++) {
            for (int j = 1; j < col; j++) {
                if (matrix.get(i).get(j) != 0) {
                    // check for col & row:
                    if (matrix.get(i).get(0) == 0 || matrix.get(0).get(j) == 0) {
                        matrix.get(i).set(j, 0);
                    }
                }
            }
        }

        if (matrix.get(0).get(0) == 0) {
            for (int j = 0; j < col; j++) {
                matrix.get(0).set(j, 0);
            }
        }
        if (col0 == 0) {
            for (int i = 0; i < row; i++) {
                matrix.get(i).set(0, 0);
            }
        }

        return matrix;
    }



    public static void main(String[] args) {
        ArrayList<ArrayList<Integer>> matrix = new ArrayList<>();
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 0, 1)));
        matrix.add(new ArrayList<>(Arrays.asList(1, 1, 1)));

        int n = matrix.size();
        int m = matrix.get(0).size();

        // brute force approach.
        ArrayList<ArrayList<Integer>> ans = zeroMatrix(matrix, n, m);

        System.out.println("The Final matrix is: ");
        for (ArrayList<Integer> row : ans) {
            for (Integer ele : row) {
                System.out.print(ele + " ");
            }
            System.out.println();
        }
    }
}
