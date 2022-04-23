package arrays;

public class MinimumConsecutiveFlips {

    /*
    *
    * Either group count differ by one
    * 1 1 0 0 0 1 1 1 0 0 1
    * 0 0 1 1 0 0 0 1 1 0 0
    *
    * Either count are same
    * 0 0 1 1 1 0 0 0 0 1 1
    * 0 0 0 0 1 1 1 1
    *
    * We always flip the second group.
    * */

    static void printGroups(int[] arr,int n){
        for(int i = 1; i < n ; i++){
            if(arr[i] != arr[i-1]){
                if(arr[i] != arr[0]){
                    System.out.print("From :" + i + " to");
                }else{
                    System.out.println(i-1);
                }
            }
        }

        if(arr[n-1] != arr[0]){
            System.out.println(n-1);
        }
    }

    public static void main(String[] args) {
        int arr[] = {0, 0, 1, 1, 0, 0, 1, 1, 0}, n = 9;

        printGroups(arr, n);

    }
}
