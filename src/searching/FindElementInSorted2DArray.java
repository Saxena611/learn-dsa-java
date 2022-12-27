package searching;

public class FindElementInSorted2DArray {

    /**
     * https://takeuforward.org/data-structure/search-in-a-sorted-2d-matrix/
     *
     * Striver - DSA - Sheet
     *
     * */


    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};
        System.out.println(searchMatrix(matrix, 60));
        search(matrix, 12,60);
    }


    public static boolean searchMatrix(int[][] matrix, int target) {
        int lo = 0;
        if(matrix.length == 0) return false;
        int n = matrix.length;  // row count
        int m = matrix[0].length; // column count
        int hi = (n * m) - 1; // element count

        // Idea is to convert the whole array into linear format by getting the element count.
        // Now, as we are considering the whole array linear and sorted we can apply binary search mathematically.

        while(lo <= hi) {
            int mid = (lo + (hi - lo) / 2);
            if(matrix[mid/m][mid % m] == target) {
                return true;
            }
            if(matrix[mid/m][mid % m] < target) {
                lo = mid + 1;
            }
            else {
                hi = mid - 1;
            }
        }
        return false;
    }

    // 2nd approach where we start iterating from last element in a row and compare the same with x.
    // If element is greater than x than we move towards the next row in the same column as all other element
    // in the same column are greater than the current element.
    // if the element is smaller than we move towards the previous column as all other elements are smaller than the
    // compared element.
    // we repeat the above for each element as we traverse through the array.
    private static void search(int[][] mat, int n, int x)
    {

        // set indexes for top right
        int i = 0, j = n - 1;
        // element

        while (i < n && j >= 0) {
            if (mat[i][j] == x) {
                System.out.print("Element found at " + i
                        + " " + j);
                return;
            }
            if (mat[i][j] > x)
                j--;
            else // if mat[i][j] < x
                i++;
        }

        System.out.print("n Element not found");
        return; // if ( i==n || j== -1 )
    }
}
