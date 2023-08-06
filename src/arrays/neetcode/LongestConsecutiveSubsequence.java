package arrays.neetcode;

import java.util.Arrays;

public class LongestConsecutiveSubsequence {


    public static void main(String[] args) {
        int[] arr = {0,3,7,2,5,8,4,6,0,1};

        int res = longestConsecutiveSubsequence(arr);
        System.out.println(res);
    }

    public static int longestConsecutiveSubsequence(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        if (nums.length == 1) {
            return 1;
        }

        Arrays.sort(nums);

        // Kaden's Algorithm.
        int mx = 1;
        int res = 1;
        int curr = nums[0];
        for (int i = 1; i < nums.length ; i++) {
            if ((curr + 1) == nums[i]) {
                // array is consecutive
                res += 1;
                curr = nums[i];
                mx = Math.max(mx, res);
            } else if(curr == nums[i]) {
                curr = nums[i];
            } else {
                // start a new array
                res = 1;
                curr = nums[i];
            }
        }
        return mx;
    }
}
