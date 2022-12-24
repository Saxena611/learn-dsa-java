package arrays.windowsliding;

import java.util.*;

public class MaximumOfAllSubArray {

    public static void main(String[] args) {

        int[] arr =  {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;

//        int[] arr = {10, 9 , 8 , 7 , 6 , 5 , 4 ,3 ,2 , 1};
//        int k = 2;

        int[] output = slidingMaximum(arr, k);
        System.out.println(Arrays.toString(output));

        int[] output1 = printMaxOfAllSubArray(arr, k);
        System.out.println(Arrays.toString(output1));
    }

    public static int[] printMaxOfAllSubArray(int[] arr, int k) {

        int i = 0;
        int j = 0;
        Queue<Integer> temp = new LinkedList<>();
        List<Integer> output = new ArrayList<>();
        while (j < arr.length) {
            if (temp.isEmpty()) {
                temp.add(arr[i]);
            } else {
                while (!temp.isEmpty() && temp.peek() < arr[j]) {
                    temp.poll();
                }
                temp.add(arr[j]);
            }

            if ((j - i  + 1) < k) {
                j++;
            } else if ((j - i + 1) == k) {

                output.add(temp.peek());

                if (!temp.isEmpty()) {
                    if (temp.peek() == arr[i]) {
                        temp.poll();
                    }
                }
                i++;
                j++;
            }
        }
        int[] otarr = new int[output.size()];
        for (int m = 0 ; m < output.size() ; m++) {
            otarr[m] = output.get(m);
        }

        return otarr;
    }

    public static int[] slidingMaximum(int[] nums, int k)
    {
        int max = Integer.MIN_VALUE;
        if(k>=nums.length)
        {
            for(int i = 0;i<nums.length;++i)
            {
                max = Math.max(nums[i],max);
            }
            int[] d = new int[1];
            d[0] = max;
            return d;
        }
        int ans[] = new int[nums.length - k + 1];
        Deque<Integer> q = new LinkedList<>();

        int i = 0;
        int j = 0;

        while(j < nums.length) {
            // calculation
            if(q.size() == 0){
                q.add(nums[j]);
            }
            else{
                while(q.size() > 0 && q.peekLast() < nums[j]) {
                    q.removeLast();
                }
                q.add(nums[j]);
            }
            // now move j pointer
            if(j - i + 1 < k) j++;
                // if we hit the window size
            else if(j - i + 1 == k){
                // answer -> calculation;
                ans[i] = q.peek();
                // slide the window
                // calculation
                if(nums[i] == q.peekFirst()){
                    q.removeFirst();
                }
                // now slide the pointer
                i++;
                j++;
            }
        }
        return ans;
    }
}
