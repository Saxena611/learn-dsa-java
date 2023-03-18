package strings;

import java.util.Stack;

public class OutermostParentheses {

    /**
     * https://practice.geeksforgeeks.org/problems/outermost-parentheses/1
     * <p>
     * A valid parentheses string is either empty "", "(" + X + ")", or X + Y, where X and Y are valid parentheses strings,
     * and + represents string concatenation.
     * <p>
     * For example, "", "()", "(())()", and "(()(()))" are all valid parentheses strings.
     * <p>
     * A valid parentheses string s is primitive if it is nonempty,
     * and there does not exist a way to split it into s = X + Y, with X and Y nonempty valid parentheses strings.
     * <p>
     * Given a valid parentheses string s, consider its primitive decomposition: s = P1 + P2 + ... + Pk,
     * where Pi are primitive valid parentheses strings.
     * <p>
     * Return s after removing the outermost parentheses of every primitive string in the primitive decomposition of s.
     */
    public static void main(String[] args) {
        String s = "(()())(())";
        System.out.println(removeOutermostParenthesis(s));
    }


    /**
     * Input:
     * s = "(()())(())"
     * Output:
     * "()()()"
     * Explanation:
     * The input string is "(()())(())", with primitive decomposition "(()())" + "(())".
     * After removing outer parentheses of each part, this is "()()" + "()" = "()()()".
     * <p>
     * Example 2:
     * <p>
     * Input:
     * s = "()()"
     * Output:
     * ""
     * Explanation:
     * The input string is "()()", with primitive decomposition "()" + "()".
     * After removing outer parentheses of each part, this is "" + "" = "".
     */
    public static String removeOutermostParenthesis(String s) {
        Stack<Character> stk = new Stack<>();
        StringBuilder sb = new StringBuilder();
        char[] charr = s.toCharArray();
        for (int i = 0; i < charr.length; i++) {
            if (charr[i] == '(') {
                if (stk.size() > 0) {
                    sb.append(charr[i]);
                }
                stk.push(charr[i]);
            } else {
                stk.pop();
                if (stk.size() > 0) {
                    sb.append(charr[i]);
                }
            }

        }
        return sb.toString();
    }
}
