package arrays;

import java.text.DecimalFormat;

public class DeliveryBoyMyntra {

    public static void main(String[] args) {
        int[][] matrix = {{0,0}, {0,2}, {2,0}};
        int speed = 2;
        double maxTime = Double.MIN_VALUE;

        // row level movement
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i + 1; j < matrix.length; j++) {
                double distance = Math.sqrt(
                  Math.pow(matrix[i][0] - matrix[j][0], 2) +
                  Math.pow(matrix[i][1] - matrix[j][1], 2)
                );
                double time = distance/speed;
                maxTime = Math.max(maxTime, time);
            }
        }

        DecimalFormat df = new DecimalFormat("#.######");
        String rounded = df.format(maxTime);
        System.out.println("Max time in double : " + Double.parseDouble(rounded));
    }
}
