package arrays;

public class MajorityElement {

    /*
    * Majority element is an element that appears more than n/2 times in an array of size n .
    * Based out of Moore's Voting Algorithm
    * Its based out of cancel out approach
    * */

    static int findMajority(int[] arr,int n){
        int res = 0;
        int count = 1;

        for(int i = 1; i < n ; i++){
            if(arr[res] == arr[i]){
                count++;
            }else{
                count--;
            }

            if(count == 0){
                res = i;
                count = 1;
            }
        }

        // check if index is actually majority
        count = 0;
        for(int i = 0 ; i < n ; i++){
            if(arr[res] == arr[i]){
                count++;
            }
        }
        if(count <= n/2){
            return -1;
        }
        return arr[res];

    }

    public static void main(String[] args) {
        int arr[] = {8, 8, 6, 6, 6, 4, 6}, n = 7;
        System.out.println(findMajority(arr, n));
    }
}
