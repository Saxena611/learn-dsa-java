package searching;

public class CountOfAnElementInSortedArray {

    public static void main(String[] args) {
        int[] arr = {2,4,4,10,10,10,18,20};
        int n = 7;
        int x = 10;

        // Expected output : 3 , as 10 has the frequency of 3.
        int first_i = FirstAndLastOccurence.firstOccurence(arr,n,x);
        int last_i = FirstAndLastOccurence.lastOccurence(arr,n,x);
        int count_as_output = (last_i - first_i) + 1;

        System.out.println(String.format("Count of element %d in the input array is %d",x,count_as_output));
    }
}
