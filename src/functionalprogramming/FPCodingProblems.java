package functionalprogramming;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FPCodingProblems {

    public static void main(String[] args) {
        reverseLetterAndWords();
        checkIfStringContainsOnlyDigits();
        countCharacterOccurence();
        checkIfStringIsPalindrome();
    }

    public static void reverseLetterAndWords() {
        String line = "program to reverse each word using functional programming";

        String output = Stream.of(line.split(" "))
                .map(s -> new StringBuilder(s).reverse().toString())
                .collect(Collectors.joining(" "));

        System.out.println(output);
    }

    public static void checkIfStringContainsOnlyDigits() {
        String digit = "1242232443452";

        boolean isOnlyDigit = digit.chars()
                .mapToObj(s -> Character.valueOf((char) s))
                .anyMatch(s -> !Character.isDigit(s));

        System.out.println("Is only digit: " + isOnlyDigit);

    }

    public static void countCharacterOccurence() {
        String s = "aacccssfefffsaasccs";

        char ch = 'a'; // calculate how many times 'a' occurs in input string s.

        long occurence = s.chars().
                mapToObj(m -> Character.valueOf((char) m))
                .filter(k -> k.equals(ch))
                .count();

        System.out.println("Occurence for " + ch + "in " + s + "equals" + occurence);
    }

    public static void checkIfStringIsPalindrome() {
        String input = "madam";

        boolean isPalindrome = IntStream.range(0, input.length())
                .noneMatch(s -> input.charAt(s) != input.charAt(input.length() - s - 1));

        System.out.println("Is input: " + input + "palindrome: " + isPalindrome);

    }

    public static void getFirstNonRepeatingCharacter() {
        String input = "aacbsaabccdde";

        Character ch = input.chars()
                .mapToObj(s -> Character.valueOf((char) s))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .map(s -> s.getKey())
                .findFirst()
                .get();

        System.out.println("First non repeating character: " + ch);
    }


}
