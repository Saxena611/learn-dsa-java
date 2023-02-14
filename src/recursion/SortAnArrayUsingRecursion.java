package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class SortAnArrayUsingRecursion {

    public List<Integer> arrayList;

    public void sortArray(){
        if(arrayList.size() == 1){
            return;
        }

        // Hypothesis
        int temp = arrayList.get(arrayList.size() - 1);
        arrayList.remove(arrayList.size() - 1);
        sortArray();

        // Induction
        insertInArray(temp);
    }

    public void insertInArray(int temp) {
        // Base condition
        if(arrayList.size() == 0 || arrayList.get(arrayList.size() - 1) <= temp){
            arrayList.add(temp);
            return;
        }

        // Hypothesis
        int value = arrayList.get(arrayList.size() - 1);
        arrayList.remove(arrayList.size() - 1);
        insertInArray(temp);

        // Induction
        arrayList.add(value);
    }


    public static void main(String[] args) {
        SortAnArrayUsingRecursion sortAnArrayUsingRecursion = new SortAnArrayUsingRecursion();
        sortAnArrayUsingRecursion.arrayList = new ArrayList<>();
        sortAnArrayUsingRecursion.arrayList.addAll(Arrays.asList(2,3,7,5,4,9));
        sortAnArrayUsingRecursion.sortArray();

        System.out.println(sortAnArrayUsingRecursion.arrayList.toString());
    }



}
