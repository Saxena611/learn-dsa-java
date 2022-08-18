package functionalprogramming;

import java.util.List;

public class FP1 {

    public static void main(String[] args) {

        printAllNumbersInList(List.of(12,9,8,3,2,1));

        // Exercise - 1
        // Out of the below list print only those which consist of word sping
        List<String> liOfwords = List.of("Spring","Not some word","spring");
        liOfwords.stream().filter(word -> word.toLowerCase().contains("spring")).forEach(System.out::println);

        // Exercise - 2
        // print elements which has atleast 4 characters
        liOfwords.stream().filter(word -> word.length() > 4).forEach(System.out::println);

        // Exercise - 3
        // given the below list of numbers print cube of odd numbers
        List<Integer> liOfInt = List.of(1,2,3,4,5,6,7,8,9,10);
        liOfInt.stream().filter(num -> num%2 != 0).map(num -> num * 3).forEach(System.out::println);

        System.out.println("change");
        liOfInt.stream().filter(num -> num%2 != 0);
    }

    public static void printAllNumbersInList(List<Integer> numbers){
        // Traditional approach
//        for(int number : numbers){
//            System.out.println(number);
//        }
        // Functional approach

        /*
            1. Convert list of numbers into streams of numbers.
         */
        numbers.stream().forEach(System.out::println); // Method reference

        // print only even numbers in the list
        // use filter to allow only even numbers
        numbers.stream().filter(FP1::printEvenNumbers); // Method reference

        // using lambda functions
        numbers.stream().filter(number -> number%2 == 0).forEach(System.out::println);
    }

    private static boolean printEvenNumbers(int number){
        return number%2 == 0;
    }


}
