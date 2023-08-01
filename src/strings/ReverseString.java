package strings;

public class ReverseString {

    public static void main(String[] args) {
        String s = "My name is animesh";
        char[] sChar = s.toCharArray();

        for (int i = 0, j = sChar.length-1; i < j; i++,j-- ) {
            char temp = sChar[i];
            sChar[i] = sChar[j];
            sChar[j] = temp;
        }

        StringBuffer sb = new StringBuffer();
        for (char ch: sChar) {
            sb.append(ch);
        }
        System.out.println(sb);
    }
}
