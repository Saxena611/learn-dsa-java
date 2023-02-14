package arrays.windowsliding;

public class CountSubarrayWithKOdds {

    /**
     * https://practice.geeksforgeeks.org/problems/count-subarray-with-k-odds
     *
     * Input:
     * n = 5
     * nums = [1,1,2,1,1]
     * k = 3
     * Output:
     * 2
     * Explanation:
     * There are 2 subarrays with k odds [1,1,2,1] and [1,2,1,1]
     * */


    public static void main(String[] args) {
        int n = 10;
        int[] arr = {76, 68, 92, 23, 82, 95, 91, 89, 42, 79};
        int k = 4;

        System.out.println(countSubarray(n, arr, k));
        
    }


    public static int countSubarray(int n, int[] nums, int k) {
        // code here
        int i=0,j=0,odd=0,cnt=0;
        int temp=0;
        while(j <n){
            if(nums[j]%2 !=0){
                odd++;
                temp=0;
            }
            while(odd == k){
                temp++;
                if(nums[i]%2 !=0){
                    odd--;
                }
                i++;
            }
            cnt+=temp;
            j++;
        }
        return cnt;
    }
}
