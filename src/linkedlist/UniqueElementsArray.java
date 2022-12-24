package linkedlist;

import java.util.HashMap;
import java.util.Map;

public class UniqueElementsArray {


    public static int unique(String s) {
        int output = 0;
        String[] arr = s.split(",");
        HashMap<Integer, Integer> hmap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            int element;
            try{
               element = Integer.parseInt(arr[i]);
            }catch (Exception e){
                continue;
            }
            if (hmap.containsKey(element)) {
                hmap.put(element, hmap.get(element + 1));
            } else {
                hmap.put(element, 1);
            }
        }
        for (Map.Entry<Integer, Integer> e : hmap.entrySet())
            output += e.getKey();

        return output;
    }

    public static void main(String[] args) {
        String s = "1,1,2,a,3";
        String s2 = "1,1,1,v,c,d,;,3,5,6,3,3";
        System.out.println(unique(s));
    }
}
