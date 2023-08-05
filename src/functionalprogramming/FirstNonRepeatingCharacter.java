package functionalprogramming;

import java.util.LinkedHashMap;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FirstNonRepeatingCharacter {
    public static void main(String[] args) {
        Character c = getFirstNonRepeatingCharacter("abcbce");
        System.out.println(c);
    }

    /**
     *  mapToObject is utilized to convert stream of integer as ascii values into character object.
     *  Collectors.groupingBy helps to create a specific implementation of hashmap
     *  Collectors.counting help to do the accumulation for count of values specific to a key.
     *
     * */
    public static Character getFirstNonRepeatingCharacter(String input) {
        return input.chars().
                mapToObj(s -> Character.toLowerCase(Character.valueOf((char) s)))
                .collect(Collectors.groupingBy(Function.identity(), LinkedHashMap::new, Collectors.counting()))
                .entrySet()
                .stream()
                .filter(s -> s.getValue() == 1)
                .map(k -> k.getKey())
                .findFirst().get();
    }
}
