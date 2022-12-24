package arrays;

import java.util.Arrays;

public class ValidAnagram {

    public static void main(String[] args) {
        String s1 = "anagram";
        String s2 = "nagaram";

        System.out.println(solve(s1, s2));
    }

    public static boolean solve(String s1, String s2) {
        char[] ch1 = s1.toCharArray();
        Arrays.sort(ch1);
        char[] ch2 = s2.toCharArray();
        Arrays.sort(ch2);
        return Arrays.toString(ch1).equals(Arrays.toString(ch2));
    }
}
