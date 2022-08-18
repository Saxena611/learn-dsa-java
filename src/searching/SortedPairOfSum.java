package searching;

public class SortedPairOfSum {

    /**
     *
     * Find pair in sorted array which gives sum X
     * Since the array is sorted two pointer approach can be applied.*
     */
    static boolean isPair(int[] arr, int x){
        int left = 0;
        int right = arr.length - 1;

        while(left <= right){
            if(arr[right] + arr[left] == x){
                return true;
            }else if (arr[right] + arr[left] > x){
                right--;
            }else{
                left++;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = new int[]{2, 3, 7, 8, 11};
        int sum = 14;
        System.out.println(isPair(arr,sum));
    }
}
