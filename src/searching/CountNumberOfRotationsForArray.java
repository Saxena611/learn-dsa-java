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
           int mid = start + (end -start)/2;
           int prev = (mid - 1 + n)%n;
           int next = (mid + 1)%n;

           if(arr[prev] >= arr[mid] && arr[next] >= arr[mid]){
               return mid;
           }else if(arr[mid] <= arr[end]){
               end = mid - 1;
           }else{
               start = mid + 1;
           }
       }
       return 0;

    }

}
