package strings;

import java.util.Locale;

public class ValidPalindrome {

    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";

        boolean output = isPalindrome(s);
        System.out.println(output);
    }

    private static boolean isPalindrome(String s) {
        String in = s.toLowerCase(Locale.ROOT);
        char[] charr = in.toCharArray();
        String output = "";
        for(char ch : charr) {
            if (isAlpha(ch)) {
                output += String.valueOf(ch);
            }
        }

        StringBuilder sb = new StringBuilder(output);
        sb.reverse();

        return sb.toString().equals(output);
    }

    public static boolean isAlpha(char char1) {
        return (char1 >= 'a' && char1 <= 'z');
    }

}
