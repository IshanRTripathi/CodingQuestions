package main.java.leetcode;

import java.util.Stack;

public class ValidateParenthesis {
    public static void main(String[] args) {
        ValidateParenthesis ValidateParenthesisObject = new ValidateParenthesis();
        var result = ValidateParenthesisObject.isValid("(([]{}))");
        System.out.println(result);
//        result= ValidateParenthesisObject.isValid("{{{{{{[[[[}}]]]))()");
//        System.out.println(result);
    }
    public boolean isValid(String s){
        Stack<Character> stack= new Stack<>();

        for(char c: s.toCharArray()){
            System.out.println(stack);
            if(c=='(')
                stack.push(')');
            else if(c=='{')
                stack.push('}');
            else if(c=='[')
                stack.push(']');
            else if(stack.isEmpty() || stack.pop()!=c)
                return false;
        }
        return true;
    }
}
/*
Link : https://leetcode.com/problems/valid-parentheses/

Problem Description: 
Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

An input string is valid if:

Open brackets must be closed by the same type of brackets.
Open brackets must be closed in the correct order.


Example 1:

Input: s = "()"
Output: true
Example 2:

Input: s = "()[]{}"
Output: true
Example 3:

Input: s = "(]"
Output: false
Example 4:

Input: s = "([)]"
Output: false
Example 5:

Input: s = "{[]}"
Output: true


Constraints:

1 <= s.length <= 10^4
s consists of parentheses only '()[]{}'
*/