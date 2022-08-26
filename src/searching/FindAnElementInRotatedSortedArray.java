package searching;

public class FindAnElementInRotatedSortedArray {


    public static void main(String[] args) {
        // rotated sorted array

        int[] arr = {11,12,15,18,2,5,6,8};
        // int[] arr = {15, 18, 2, 3, 6, 12};

        // calculate the minimum element of a rotated sorted array.
        // This also gives you the count of number of rotations.
        int x = 11;
        int minIdx = findMinimumElementIndex(arr);
        int o1 = binarySearch(0, minIdx, x, arr);
        int o2 = binarySearch(minIdx+1, arr.length - 1, x, arr);
        if(o1 != -1){
            System.out.println("Element was found at idx : " + o1);
        }

        if(o2 != -1){
            System.out.println("Element was found at idx : " + o2);
        }

        if(o1 == -1 && o2 == -1){
            System.out.println("Element was not found.");
        }
    }

    public static int findMinimumElementIndex(int[] arr){

        int start = 0;
        int end = arr.length - 1;
        int n = arr.length;
        int res = -1;
        while(start <= end){

            int mid = start  + (end - start)/2;
            int prev = (mid - 1 + n)%n;
            int next = (mid + 1)%n;
            if(arr[prev] > mid && arr[next] > mid){
                res = mid;
                return res;
            } else if (arr[end] >= arr[mid]) {
                // sorted array condition start with later part
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static int binarySearch(int start,int end, int x, int[] arr){
        int res = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == x){
                res = mid;
                return res;
            }else if(x > arr[mid]){
                start = mid + 1;
            }else {
                end = mid - 1;
            }
        }
        return res;
    }
}
