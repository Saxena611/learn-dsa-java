package trie;

import java.util.Arrays;
import java.util.List;

public class LongestStringWithAllPrefix {


    public static void main(String[] args) {
        List<String> allString = Arrays.asList("n", "ninja", "ninj", "ni", "nin", "ninga");
        String output = longestStringWithAllPrefix(allString);
        System.out.println(output);
    }

    private static String longestStringWithAllPrefix(List<String> allString) {
        Trie trie = new Trie();
        for (String word:
             allString) {
            trie.insert(word);
        }
        String maxLengthPrefix = "";

        for (String word:
             allString) {
            if (trie.checkIfPrefixExists(word)) {
                if (maxLengthPrefix.length() < word.length()) {
                    maxLengthPrefix = word;
                }
            }
        }
        return maxLengthPrefix;
    }
}
