package arrays;

public class SmallestSubArrayWithSumGreaterThanX {
    public static int smallestSubWithSum(int a[], int n, int x) {
        // Your code goes here

        int minlen = n + 1;

        int curr_sum = 0;
        int start = 0;
        int end = 0;

        while (end < n) {

            while (curr_sum <= x && end < n) {
                curr_sum += a[end++];
            }

            while (curr_sum > x && start < n) {
                if (end - start < minlen) {
                    minlen = end - start;
                }
                curr_sum -= a[start++];
            }
        }
        return minlen;
    }


    public static void main(String[] args) {
        int arr1[] = {1, 4, 45, 6, 10, 19};
        int x = 51;
        System.out.println(smallestSubWithSum(arr1, arr1.length, x));

    }
}
