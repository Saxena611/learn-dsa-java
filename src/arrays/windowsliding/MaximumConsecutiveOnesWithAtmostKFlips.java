package arrays.windowsliding;

public class MaximumConsecutiveOnesWithAtmostKFlips {


    public static void main(String[] args) {
        int arr[] = new int[]{1,1,1,0,0,0,1,1,1,1,0};
        //int arr[] = new int[]{1,0,0,1};
        // int[] arr = new int[]{0 ,0 ,1 ,1 ,0 ,0 ,1 ,1 ,1 ,0 ,1 ,1 ,0 ,0 ,0 ,1, 1, 1, 1};
        System.out.println(findZeroes(arr, 2));

    }
    /**
     * An Efficient Solution can solve the problem in O(n) time and O(1)  space. The idea is to use Sliding Window for the given array.
     *
     * Let us use a window covering from index wL to index wR. Let the number of zeros inside the window be zeroCount.
     * We maintain the window with at most m zeros inside.
     *
     * The main steps are:
     *
     * While zeroCount is no more than m: expand the window to the right (wR++) and update the count zeroCount.
     * While zeroCount exceeds m, shrink the window from left (wL++), update zeroCount;
     * Update the widest window along the way. The positions of output zeros are inside the best window.
     *
     *
     * */
    private static int findZeroes(int[] arr, int k) {
        int l = 0;
        int r = 0;
        int zeroCount = 0;
        int bestWindow = Integer.MIN_VALUE;


        while (r < arr.length) {
            if (zeroCount <= k) {
                if (arr[r] == 0) {
                    zeroCount++;
                }
                r++;
            }

            if (zeroCount > k) {
                if (arr[l] == 0) {
                    zeroCount--;
                }
                l++;
            }

            if (zeroCount <= k) {
                bestWindow = Math.max(r-l, bestWindow);
            }
        }
        return bestWindow;
        



    }
}
