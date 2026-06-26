//Given a string s containing just the characters '(', ')', '{', '}', '[' and ']',
//determine if the input string is valid.
//
//An input string is valid if:
//
//Open brackets must be closed by the same type of brackets.
//Open brackets must be closed in the correct order.
//Every close bracket has a corresponding open bracket of the same type.
// 
//
//Example 1:
//
//Input: s = "()"
//
//Output: true
//
//Example 2:
//
//Input: s = "()[]{}"
//
//Output: true

import java.util.Stack;

public class Leetcode20_ValidParentheses {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {

            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
            } else {

                if (stack.isEmpty())
                    return false;

                char topElem = stack.pop();

                if ((c == ')' && topElem != '(') ||
                    (c == '}' && topElem != '{') ||
                    (c == ']' && topElem != '['))
                    return false;
            }
        }

        return stack.isEmpty();
    }

    public static void main(String[] args) {

        Leetcode20_ValidParentheses solution =
                new Leetcode20_ValidParentheses();

        String s = "{[()]}";

        boolean result = solution.isValid(s);

        System.out.println("Output : " + result);
    }
}