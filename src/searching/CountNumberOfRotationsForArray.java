package searching;

public class CountNumberOfRotationsForArray {

    public static void main(String[] args) {
        int[] arr = {15, 18, 2, 3, 6, 12};
        int n = arr.length;
        System.out.println(countRotations(arr,n));
    }

    /**
     * Returns count of rotations for an array which
     * is first sorted in ascending order, then rotated
     *
     */
    private static int countRotations(int[] arr, int n) {
       int start = 0;
       int end = n - 1;

       while(start <= end){
           /*
           * If the first element is mid or
           * last element is mid then simply use modulo
           * so the array never goes out of bound.
           * */
           int mid = start + (end - start)/2;
           int prev = (mid - 1 + n)%n;
           int next = (mid + 1)%n;

           // Check if the mid element is minimum element
           // rotated sorted array property
           if(arr[prev] >= arr[mid] && arr[next] >= arr[mid]){
               return mid;
           }else if(arr[mid] <= arr[end]){
               // later part of array is sorted search only in the initial part
               // thus making end as mid - 1
               end = mid - 1;
           }else{
               // as the condition is not satified means later part of array is unsorted
               // and needs to be checked for the minimum element
               start = mid + 1;
           }
       }
       return 0;

    }
}