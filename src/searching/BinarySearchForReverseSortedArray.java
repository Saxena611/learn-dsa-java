package searching;

public class BinarySearchForReverseSortedArray {


    public static void main(String[] args) {
        int arr[] = {60, 50, 40, 30, 20, 10}, n = 6;

        int x = 30;

        // Iterative approach
        System.out.println(bSearch(arr, n, x));
    }

    private static int bSearch(int[] arr, int n, int x) {
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int mid = (start + end)/2;
            if(arr[mid] == x){
                return mid;
            }else if(x < arr[mid]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }
        return -1;
    }
}
