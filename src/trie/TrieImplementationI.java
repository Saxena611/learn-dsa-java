package trie;


class Node {
    Node[] links = new Node[26];
    boolean flag = false;

    int countStartWith = 0;
    int countEndWith = 0;

    public Node() {

    }

    public boolean containsKey(char ch) {
        return this.links[ch - 'a'] != null;
    }

    Node get(char ch) {
        return this.links[ch - 'a'];
    }

    void put(char ch, Node node) {
        this.links[ch - 'a'] = node;
    }

    void setEnd() {
        this.flag = true;
    }

    boolean isEnd() {
        return this.flag;
    }

    void increasePrefix() {
        this.countStartWith++;
    }

    void reducePrefix() {
        this.countStartWith--;
    }

    void increaseEnd() {
        this.countEndWith++;
    }

    void reduceEnd() {
        this.countEndWith--;
    }

    int getCountEndWith() {
        return countEndWith;
    }

    int getPrefix() {
        return this.countStartWith;
    }
}


class Trie {
    private static Node root;

    public Trie () {
        Trie.root = new Node();
    }

    public static void insert(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                node.put(word.charAt(i), new Node());
            }
            node = node.get(word.charAt(i));
            node.increasePrefix();
        }
        node.setEnd();
        node.increaseEnd();
    }

    public static boolean search (String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        if (node.isEnd()) {
            return true;
        }
        return false;
    }

    public static boolean startsWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (!node.containsKey(word.charAt(i))) {
                return false;
            }
            node = node.get(word.charAt(i));
        }
        return true;
    }

    public static int countWordsEqualTo(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        return node.getCountEndWith();
    }

    public static int countWordStartingWith(String word) {
        Node node = root;
        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            } else {
                return 0;
            }
        }
        return node.getPrefix();
    }

    public static boolean checkIfPrefixExists(String word) {
        Node node = root;

        for (int i = 0; i < word.length(); i++) {
            if (node.containsKey(word.charAt(i))) {
                node = node.get(word.charAt(i));
            }
            if (node.isEnd() == false) {
                return false;
            }
        }
        return true;
    }
}
public class TrieImplementationI {
    public static void main(String[] args) {
        int n = 5;
        int type[] = {1, 1, 2, 3, 2};
        String value[] = {"hello", "help", "help", "hel", "hel"};
        Trie trie=new Trie();
        for (int i = 0; i < n; i++) {
            if (type[i] == 1) {
                trie.insert(value[i]);
            }
            else if (type[i] == 2) {
                if (trie.search(value[i])) {
                    System.out.println( "true" );
                }
                else {
                    System.out.println("false");
                }
            }
            else {
                if (trie.startsWith(value[i])) {
                    System.out.println("true" );
                }
                else {
                    System.out.println("false");
                }
            }
        }
    }
}
