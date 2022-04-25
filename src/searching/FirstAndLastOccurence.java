package searching;

public class FirstAndLastOccurence {
    public static void main(String[] args) {
        int[] arr = {2,4,4,10,10,10,18,20};
        int n = 7;

        int x = 10;

        // Find the first occurence for element x.
        System.out.println(firstOccurence(arr,n,x));
        // Find the last occurence for element x.
        System.out.println(lastOccurence(arr,n,x));

    }

    public static int lastOccurence(int[] arr, int n, int x) {
        // As the array is sorted binary sorted is applied.
        int start = 0;
        int end = n - 1;
        int res = -1;

        while(start <= end){
            int mid = start + (end - start)/2 ;
            if(arr[mid] == x){
                res = mid;
                // As we are looking to find the last element we continue to search in the later part of the array.
                start = mid + 1;
            }else if(arr[mid] > x){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }

    public static int firstOccurence(int[] arr, int n, int x) {
        // As the array is sorted clearly binary search is going to be applied.
        int start = 0;
        int end = n - 1;
        int res = -1;
        while(start <= end){
            int mid = (start + end)/2;

            if(arr[mid] == x){
                // As we are looking to find the first element we continue to search in prior part of the array.
                res = mid;
                end = mid - 1;
            }else if(x < arr[mid]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }
        return res;
    }


}
