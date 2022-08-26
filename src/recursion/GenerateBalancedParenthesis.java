package recursion;

import java.util.ArrayList;


public class GenerateBalancedParenthesis {

    public static void main(String[] args) {
        GenerateBalancedParenthesis generateBalancedParenthesis = new GenerateBalancedParenthesis();
        ArrayList<String> output = new ArrayList<>();

        int n = 3;
        int open = n;
        int close = n;
        String outputStr = "";
        outputStr += "(";
        open -= 1;

        generateBalancedParenthesis.solve(open,close,outputStr, output);
        System.out.println(output);

    }


    public void solve(int open, int close, String outputStr, ArrayList<String> output){

        if(open == 0 && close == 0){
            output.add(outputStr);
            return;
        }

        if(open != 0) {
            String op1 = outputStr;
            op1 += "(";
            solve(open - 1,close, op1, output);
        }

        if(close > open){
            String op2 = outputStr;
            op2 += ")";
            solve(open, close - 1, op2, output);
        }
    }

}
