package com.prep.test.algo.stringcase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class SpecialBinaryString {

    public static String makeLargestSpecial(String S) {
        int count = 0, i = 0;
        List<String> res = new ArrayList<String>();
        for (int j = 0; j < S.length(); ++j) {
            if (S.charAt(j) == '1'){
                count++;
            }
            else {
                count--;
            }
            if (count == 0) {
                String str =  makeLargestSpecial(S.substring(i + 1, j));
                res.add('1' +str+ '0');
                i = j + 1;
            }
        }
        Collections.sort(res, Collections.reverseOrder());
        return String.join("", res);

    }

    public static void main(String[] args) {
       String s ="11011000";
        String r = makeLargestSpecial(s);

        System.out.println("result "+r);

    }

}
