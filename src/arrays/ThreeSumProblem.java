package arrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSumProblem {
     /**
      * https://takeuforward.org/data-structure/3-sum-find-triplets-that-add-up-to-a-zero/
      * Three sum problem based on two pointer approach.
      * a + b + c = target
      *
      * Concept is to sort the array and use two pointer approach to find the sum using
      * (b + c) = target - a
      *
      * a - initial element i
      * (b+c) - are found using two pointer concept.
      * */

    public static void main(String[] args) {
        int arr[]={-1,0,1,2,-1,-4};
        List <List<Integer>> ans;
        ans = threeSum(arr, 0);
        System.out.println("The triplets are as follows: ");
        for (int i = 0; i < ans.size(); i++) {
            for (int j = 0; j < ans.get(i).size(); j++) {
                System.out.print(ans.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }

    private static List<List<Integer>> threeSum(int[] arr, int target) {
        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();
        int n = arr.length;
        for (int i = 0 ; i < n - 2; i++) {

            if (i == 0 || (i > 0 && arr[i] != arr[i+1])) {

                int low = i + 1;
                int hi = n - 1;
                int sum = target - arr[i];

               while (low < hi) {
                   if (arr[low] + arr[hi] == sum) {
                       // add to res
                       List<Integer> list = Arrays.asList(arr[i], arr[low], arr[hi]);
                       res.add(list);

                       // Avoids considering duplicate elements.
                       // only moves low and high pointer till the point
                       // where the value equals to the adjacent element.
                       while (low < hi && arr[low] != arr[low+1]) low++;
                       while(low < hi && arr[hi] != arr[hi-1]) hi--;

                       low++;
                       hi--;
                   } else if (arr[low] + arr[hi] > target) {
                       hi--;
                   } else {
                       low++;
                   }
               }
            }
        }
        return res;
    }
}
