package linkedlist;

import java.util.HashMap;

public class SnippetTest {


    public static void main(String[] args) {
        try {
            HashMap<String, Integer> hmap = new HashMap<>();
            hmap.put("key", 1);
            for (int i = 0; i < 10; i++) {
                System.out.println(hmap.get("key2"));
                String k = "ss";
                String s = k != null ? getValue() : String.join("_", "il_something", "hello");
                System.out.println(s);
                String val = "aLDMOrder.SrcOrderItem".split("\\.")[0];
                System.out.println(val);

            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Here I am");
        }
    }

    private static String getValue() {
        return "some";
    }

    private static void increment(int value) {
        // do nothing
        System.out.println("do nothing");
    }
}
