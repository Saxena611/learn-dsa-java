package searching;

public class SquareRoot {

    /**
     * Given an integer, we need to find floor of its square root
     * input = 10
     * output = 4
     */
    static int squareRoot(int x){
        int low = 0;
        int high = x;
        int ans = 0;
        while(low <= high){
            int mid = (low + high)/2;
            int msqt = mid*mid;

            if(msqt == x){
                return mid;
            }else if (msqt > x){
                // don't go beyond number , cut the later part of the array.
                high = mid - 1;
            }else{
                // Keep searching for the last occurrence which satisfies the condition.
                low = mid + 1;
                ans = mid;
            }
        }
        return ans;
    }

    public static void main(String[] args) {
        System.out.println(squareRoot(10));
    }
}
