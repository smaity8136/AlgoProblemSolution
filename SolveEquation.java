package com.prep.test.algo.stringcase;

public class SolveEquation {
    public static String solveEquation(String equation) {
        String[] parts = equation.split("=");
        int[] leftPart = evaluate(parts[0]);
        int[] rightPart = evaluate(parts[1]);
        if(leftPart[0] == rightPart[0] && leftPart[1] == rightPart[1]) {
            return "Infinite solutions";
        }else if (leftPart[0] == rightPart[0]){
            return "No solution";
        }
        return "x="+ (rightPart[1]-leftPart[1])/(leftPart[0]-rightPart[0]);
    }

    public static int[] evaluate(String str){
        String[] tokens = str.split("(?=[+-])");  // ()for match group; ?= for match and include in res; [+-] means + or -;
        int[] res = new int[2]; // coefficient for x;  coefficient for constant
        for(String token : tokens) {
            if (token.equals("+x") || token.equals("x")) res[0]++; // x means 1x
            else if (token.equals("-x")) res[0]--;// -x means -1x
            else if (token.contains("x")) {
                res[0] += Integer.parseInt(token.substring(0, token.length()-1));
            }else {
                res[1] += Integer.parseInt(token);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        String equation1 = "x+5-3+x=6+x-2";
        String equation ="2x+3x-6x=x+2";
        String res = solveEquation(equation);

        System.out.println(" result : "+res);

    }
}
