package arrays.neetcode;

public class CanPlaceFlower {


    public static void main(String[] args) {
        int[] arr = {0,0,1,0,0};
        int n = 1;
        boolean output = canPlaceFlowers(arr, n);
        System.out.println(output);
    }

    public static boolean canPlaceFlowers(int[] flowerbed, int n) {
        int m = flowerbed.length;
        if (m == 1) {
            if (flowerbed[0] == 0) {
                flowerbed[0] = 1;
                n--;
            }
        } else {
            for (int i = 0 ; i < flowerbed.length; i++) {
                if (flowerbed[i] == 0) {
                    if (i == 0) {
                        if (flowerbed[i+1] == 0) {
                            flowerbed[i] = 1;
                            n = n - 1;
                        }
                    } else if (i == flowerbed.length - 1) {
                        if (flowerbed[i-1] == 0) {
                            flowerbed[i] = 1;
                            n = n - 1;
                        }
                    } else {
                        if (flowerbed[i-1] == 0 &&
                                flowerbed[i+1] == 0
                        ) {
                            flowerbed[i] = 1;
                            n = n - 1;
                        }
                    }
                }
            }
        }
        if (n == 0) {
            return true;
        }
        return false;
    }
}
