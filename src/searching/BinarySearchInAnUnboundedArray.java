package searching;

public class BinarySearchInAnUnboundedArray {

    /**
     * Given an infinite sized array, we need to write an efficient solution to search an element.
     */
    static int bsearch(int[] arr,int low,int high,int x){
        if(low > high){
            return -1;
        }

        int mid = (low+high)/2;
        if(arr[mid] == x){
            return mid;
        }else if(arr[mid] > x){
            return bsearch(arr,low , mid - 1, x);
        }else{
            return bsearch(arr,mid + 1,high, x);
        }
    }

    static int search(int[] arr, int x){
        if(arr[0] == x){
            return 0;
        }

        int i = 0;
        while(arr[i] < x){
            i *= 2;
        }

        if(arr[i] == x) return i;

        // since multiply by 2 jumps by 2 , previous jump index can be calculated by dividing the same by 2.
        return bsearch(arr,i/2 + 1,i-1,x);
    }

    public static void main(String[] args) {
        int arr[] = {1, 2, 3, 40, 50};

        int x = 4;

        System.out.println(search(arr, x));
    }

}
