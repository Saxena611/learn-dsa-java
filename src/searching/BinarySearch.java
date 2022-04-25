package searching;

public class BinarySearch {


    public static void main(String[] args) {
        int arr[] = {10, 20, 30, 40, 50, 60}, n = 6;

        int x = 50;

        // Iterative approach
        System.out.println(bSearch(arr, n, x));
        // Recursive approach
        System.out.println(bSearch(arr, 0,n-1, x));
    }

    private static int bSearch(int[] arr, int n, int x) {
        int start = 0;
        int end = n - 1;

        while(start <= end){
            int mid = (start + end)/2 ;
            if(arr[mid] == x){
                return mid;
            }
            else if(x < arr[mid]){
                // element will be in the starting part of the array
                end = mid - 1;
            }else{
                // element will be in the later part of the array
                start = mid + 1;
            }

        }
        return -1;
    }

    private static int bSearch(int[] arr, int low,int high, int x) {
        if(low > high){
            return -1;
        }

        int mid = (low + high)/2;

        if(arr[mid] == x){
            return mid;
        }else if(arr[mid] > x){
            return bSearch(arr,low,mid-1,x);
        }else{
            return bSearch(arr,mid + 1,high,x);
        }
    }
}
