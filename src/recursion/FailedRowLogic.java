package recursion;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FailedRowLogic {


    public static void main(String[] args) {

        int n = 10;
        List<Integer> list = Arrays.asList(1,51,3,4,5,6,7,8,52,53);

        List<Integer> failedRow = new ArrayList<>();
        FailedRowLogic fd = new FailedRowLogic();
        fd.findFailedRow(failedRow, list);

        System.out.println(failedRow);


    }


    public void findFailedRow(List<Integer> failedRow, List<Integer> row) {

        if (executeSql(row)) {
            return;
        }

        if (row.size() == 1) {
            failedRow.add(row.get(0));
            return;
        }


        int len = row.size();
        int mid = len/2;
        
        findFailedRow(failedRow, row.subList(0, mid));
        findFailedRow(failedRow, row.subList(mid, row.size()));

    }

    public boolean executeSql(List<Integer> row) {
        for (Integer integer : row) {
            if (integer > 50) {
                return false;
            }
        }
        return true;
    }
}
