package arrays;

public class MaxConsecutiveOnes {


    public static void main(String[] args) {
        // Given an array print the size of max consecutive one's

        int arr[] = {0,0,1,1,1,0,0,1,1};
        int curr = 0;
        int output = 0;

        for(int i = 0 ; i < arr.length ; i++){
            if(arr[i] == 0){
                curr = 0;
            }else{
                curr += 1;
                output = Math.max(output,curr);
            }
        }
        System.out.println(output);
    }
}
