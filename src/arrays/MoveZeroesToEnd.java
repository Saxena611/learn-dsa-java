package arrays;

public class MoveZeroesToEnd {

    public static void main(String[] args) {
        int[] arr = {1, 0, 2, 3, 2, 0, 0, 4, 5, 1};
        int n = 10;
        int[] ans = moveZeros(n, arr);
        for (int i = 0; i < n; i++) {
            System.out.print(ans[i] + " ");
        }
        System.out.println("");
    }

    private static int[] moveZeros(int n, int[] arr) {
        // two pointer approach.
        int left = 0;
        int right = 0;
        while (right < arr.length) {
            if (arr[right] != 0) {
                int temp = arr[left];
                arr[left] = arr[right];
                arr[right] = temp;
                left++; // move left to the right as we need to keep zeroes at the end.
            }
            right++; // increment right to keep checking for non-zeroes and zeores.

        }
        return arr;
    }
}
