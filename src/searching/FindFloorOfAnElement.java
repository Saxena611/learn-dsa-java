package searching;

public class FindFloorOfAnElement {


    public static void main(String[] args) {
        int arr[] = {1, 2, 4, 6, 10, 12, 14};
        int n = arr.length;
        int x = 7;
        int index = floorSearch(arr, n - 1, x);
        if (index == -1) {
            System.out.println(
                    "Floor of " + x
                            + " doesn't exist in array ");
        } else {
            System.out.println(
                    "Floor of " + x + " is "
                            + arr[index]);
        }

        int indexCeil = ceilSearch(arr, n - 1, x);
        if (indexCeil == -1){
            System.out.println(
                    "Floor of " + x
                            + " doesn't exist in array ");
        } else {
            System.out.println(
                    "Floor of " + x + " is "
                            + arr[indexCeil]);
        }
    }

    public static int floorSearch(int[] arr, int n, int x) {
        int start = 0;
        int end = n;
        int res = Integer.MIN_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // identifying candidates
            if (arr[mid] <= x) {
                res = Math.max(res, mid);
            }

            if (arr[mid] < x) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return res;
    }

    public static int ceilSearch(int[] arr, int n, int x) {
        int start = 0;
        int end = n;
        int res = Integer.MAX_VALUE;
        while (start <= end) {
            int mid = start + (end - start) / 2;

            // identifying candidates
            if (arr[mid] >= x) {
                res = Math.min(res, mid);
            }

            if (arr[mid] < x) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return res;
    }
}
