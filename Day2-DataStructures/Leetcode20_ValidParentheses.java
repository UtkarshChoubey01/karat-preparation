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

        System.out.println("Input  : " + s);
        System.out.println("Output : " + result);
    }
}