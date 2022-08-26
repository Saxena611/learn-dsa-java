package recursion;

import java.util.ArrayList;

public class JosepheusProblem {

    /*
    * Problem statement: https://practice.geeksforgeeks.org/problems/game-of-death-in-a-circle1840/1
    * Input:
      n = 4, k = 2
      Output:
      1
      Explanation:
      The safe position is 1.
    *
    * */


    public static void main(String[] args) {

        int n = 4;
        int k = 2;


        ArrayList<Integer> alist = new ArrayList<>();
        int i = 1;
        while (i <= n) {
            alist.add(i);
            i++;
        }

        // logic starts
        k -= 1; // as k-1 index is to be killed.
        int output = solve(alist, k, 0);

        System.out.println(output);
    }

    static int solve(ArrayList<Integer> arrList, int k, int idx) {


        // base condition
        if (arrList.size() == 1) {
            return arrList.get(0);
        }

        // induction
        idx = (idx + k)% arrList.size();
        arrList.remove(idx);

        // hypothesis
        return solve(arrList, k, idx);
    }
}
