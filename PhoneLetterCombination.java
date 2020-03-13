package com.leetcode.amazone.test;

import java.util.LinkedList;

public class PhoneLetterCombination{

    public static LinkedList<String> getLetterCombination(String digits){


        LinkedList<String> res = new LinkedList<String>();
        if (digits == null || digits.length()==0) return res;

        String [] mapping = new String []{"0","1","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};

        res.add("");

        for (int i=0; i<digits.length();i++){
            int x = Character.getNumericValue(digits.charAt(i));
            while(res.peek().length() == i){
                String t = res.remove();
                char []  chars = mapping[x].toCharArray();
                for (char c : chars){
                    res.add(t+c);
                }

            }

        }

        return res;
    }


    public static void main(String[] args) {

        String digits = "23";
        LinkedList<String> lst =  getLetterCombination(digits);

        lst.forEach(c-> System.out.println(""+c));
    }

}
