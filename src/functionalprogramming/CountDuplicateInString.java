package functionalprogramming;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountDuplicateInString {

    public static void main(String[] args) {
        String input = "aaaddcccd";
        Map<Character, Long> duplicateMap = getDuplicateElementMap(input);
        System.out.println(duplicateMap);
    }

    private static Map<Character, Long> getDuplicateElementMap(String input) {
        return input.chars()
                .mapToObj(s -> Character.valueOf((char) s))
                .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    }
}
