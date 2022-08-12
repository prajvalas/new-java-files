import java.util.Stack;

public class ValidParenthesis {
    public static void main(String[] args) {
        String s = "((((";
        boolean res = isValid(s);
        System.out.println("Result is : " + res);
    }

    public static boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        if (s.length() % 2 != 0) {
            return false;
        }
        int pop = 0;
        int push = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(' || c == '{' || c == '[') {
                stack.push(c);
                push++;
            } else {
                if (!stack.isEmpty()) {
                    char popped = stack.pop();
                    pop++;
                    if (popped == '(' && c == ')' || popped == '{' && c == '}' || popped == '[' && c == ']') {
                        continue;
                    } else {
                        return false;
                    }
                } else {
                    return false;
                }

            }

        }
        if (push == pop) {
            return true;
        }
        return false;
    }
}