package com.leetcode.amazone.test;

import java.util.Stack;

public class ValidParantheses {
    /*
    * Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.
    * The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.
    * Example 2:
      Input: ()[]{}
      Output: true

      Example 3:
      Input: (]
      Output: false

      Example 4:
      Input: ([)]
      Output: false

      Example 5:
      Input: {[]}
     Output: true
    * */
/*
    public static boolean isValid(String s) {

        if(s.length()==0) return false;
        Stack<Character> st = new Stack<>();
        int l =s.length();
        for(int i=0;i<i;i++){

            char c = s.charAt(i);
            switch(c){
                case '(':
                    st.push(')');
                    break;
                case '[':
                    st.push(']');
                    break;
                case '{':
                    st.push('}');
                    break;
                case ')':
                case ']':
                case '}':
                    if (st.size() == 0 || st.pop() != c)
                        return false;
                    break;
            }

        }
        return st.size() == 0;


    }
*/
public boolean isValid(String sb) {
        char[] arr= sb.toCharArray();
        Stack<Character> s = new Stack<Character>();
        
        for(int i=0;i<arr.length;i++){
            
            if(arr[i]=='{' || arr[i]== '[' || arr[i]=='('){
                s.push(arr[i]);
            }
            else if(arr[i] =='}' || arr[i] == ']' || arr[i]==')'){
    
             if(!s.empty()){ 
                 char ch=s.pop();
                if((arr[i]=='}' && ch !='{') ||
                        (arr[i]==']' && ch !='[')
                          ||(arr[i]==')' && ch !='('))
                   {
                       return false;
                   }
                 }
                else{
                    return false;
                }
            }
        }
        if(s.empty())
         return true;
        return false;
        
    }
    public static void main(String[] args) {

        //String s = "()[]{}";

        String s = "([)]";

       boolean valid =  isValid(s);

        System.out.println("isvalid : "+valid);
    }
}
