package stack;

public class TrappingRainWater {


    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println("Amount of rain water trapped by brute force: " + trappingRainWaterBruteForce(arr));

        System.out.println("Amount of rain water trapped by prefix sum: " + trappingRainWaterPrefixSum(arr));

        System.out.println("Amount of rain water trapped optimal solution: " + trappingRainWaterOptimal(arr));
    }

    private static int trappingRainWaterBruteForce(int[] arr) {

        int n = arr.length;
        int waterTrapped = 0;
        int leftMax = 0;
        for (int i = 0; i < n; i++) {
            int j = i;
            int rightMax = 0;

            leftMax = Math.max(leftMax, arr[j]);
            while (j < n) {
                rightMax = Math.max(rightMax, arr[j]);
                j++;
            }
            waterTrapped += Math.min(leftMax, rightMax) - arr[i];
        }
        return waterTrapped;


    }

    private static int trappingRainWaterPrefixSum(int[] arr) {
        int n = arr.length;
        int prefix[] = new int[n];
        int suffix[] = new int[n];

        prefix[0] = arr[0];

        for (int i = 1; i < n; i++) {
            prefix[i] = Math.max(prefix[i - 1], arr[i]);
        }

        suffix[n - 1] = arr[n - 1];
        for (int j = n - 2; j >= 0; j--) {
            suffix[j] = Math.max(suffix[j + 1], arr[j]);
        }

        int trap = 0;
        for (int k = 0; k < n; k++) {
            trap += Math.min(prefix[k], suffix[k]) - arr[k];
        }
        return trap;
    }

    private static int trappingRainWaterOptimal(int[] arr) {
        int n = arr.length;
        int left = 0;
        int right = n - 1;

        int trap = 0;

        int maxLeft = 0;
        int maxRight = 0;

        while (left <= right) {
            if (arr[left] <= arr[right]) {
                if (arr[left] >= maxLeft) {
                    maxLeft = arr[left];
                } else {
                    trap += maxLeft - arr[left];
                }
                left++;
            } else {
                if (arr[right] >= maxRight) {
                    maxRight = arr[right];
                } else {
                    trap += maxRight - arr[right];
                }
                right--;
            }
        }
        return trap;
    }


}
