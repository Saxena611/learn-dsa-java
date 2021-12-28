package hashmap;

/*
You have been given two integer arrays/list(ARR1 and ARR2) of size N and M, respectively.
You need to print their intersection; An intersection for this problem can be defined
when both the arrays/lists contain a particular value or to put it in other words,
when there is a common value that exists in both the arrays/lists.

Sample Input:
2
6
2 6 8 5 4 3
4
2 3 4 7
2
10 10
1
10

Sample output:
2 3 4
10

 */

import java.util.HashMap;

public class PrintIntersection {

    public static void intersection(int[] arr1, int[] arr2){

        String myarr = " ";
        HashMap<Integer,Boolean> hmap = new HashMap<>();
        if(arr1.length >= arr2.length){
            myarr = "arr1";
        }else{
            myarr = "arr2";
        }

        if(myarr == "arr1"){
            //add arr1 tp the hashmap
            for(int i = 0  ; i < arr1.length ; i++){
                hmap.put(arr1[i],false);
            }
            for(int j = 0 ; j < arr2.length ; j++){
                if(hmap.containsKey(arr2[j])){
                    System.out.println(arr2[j]);
                }
            }

        }
        if(myarr == "arr2"){
            //add arr2 to the hashmap
            for(int i = 0  ; i < arr2.length ; i++){
                hmap.put(arr2[i],false);
            }
            for(int j = 0 ; j < arr1.length ; j++){
                if(hmap.containsKey(arr1[j])){
                    System.out.println(arr1[j]);
                }
            }
        }
    }
}