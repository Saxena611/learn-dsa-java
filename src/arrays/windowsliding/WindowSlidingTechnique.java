package arrays.windowsliding;

public class WindowSlidingTechnique {

    /*
    * Slide through each window , For calculating the sum of a window
    * Add the next element and substract the first element.
    *
    * */

    /*
    * Given an array of integers and a number k . Find the maximum sum of k consecutive elements.
    * k - size of window
    * */
    static int maxSum(int[] arr,int n,int k){
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;

        for(int i = 0 ; i < k ; i++){
            curr_sum += arr[i];
        }

        for(int j = k ; j < n ; j++) {
           curr_sum += (arr[j] - arr[j-k]); // adding the next element and substracting the first element of the window
           max_sum = Math.max(max_sum,curr_sum);
        }

        return max_sum;
    }

    /*
     * Given an array of integers and a number k . Find the maximum sum of k consecutive elements.
     * k - size of window
     * */
    static int maxSumSecondApproach(int[] arr,int n,int k){
        int curr_sum = 0;
        int max_sum = Integer.MIN_VALUE;

        int i = 0;
        int j = 0;

        while(j < n){
            curr_sum += arr[j];
            if((j - i + 1) < k){
                j++;
            }else if((j - i + 1) == k){
                max_sum = Math.max(curr_sum, max_sum);
                curr_sum -= arr[i];
                i++;
                j++;
            }
        }
        return max_sum;
    }

    /*
    * Find sub-array with the given sum.
    *
    * */
    static void subArraySum(int[] arr,int n,int sum){
        int curr_sum = arr[0];
        int start = 0;
        int i;
        for(i = 1 ; i < n ; i++){
            while(curr_sum > sum && start < i - 1){
                curr_sum -= arr[start];
                start++;
            }
            if(curr_sum == sum){
                int p = i - 1;
                System.out.println("Sum found between " + start + " To " + p );
                return;
            }
            if(i < n){
                curr_sum += arr[i];
            }
        }
    }


    public static void main(String[] args) {

        // Max sum of k consecutive elements
        int arr_1[] = {1, 8, 30, -5, 20, 7}, n1 = 6, k1 = 3;
        System.out.println(maxSum(arr_1, n1, k1));
        System.out.println("Output of second approach.");
        System.out.println(maxSumSecondApproach(arr_1, n1, k1));

        // Find sub-array with the given sum.
        int arr_2[] = {15, 2, 4, 8, 9, 5, 10, 23};
        int n2 = arr_2.length;
        int sum = 23;
        subArraySum(arr_2, n2, sum);
    }
}
