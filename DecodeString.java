import java.util.Stack;

public class DecodeString {
    public static void main(String[] args) {
        String s = "3[a2[c4[bh]]]";
        // String s = "3[a]2[bc]";
        // String s = "3[a2[c]]";
        // String s = "2[abc]3[cd]ef";
        // String s = "abc3[cd]xyz";
        // String s = "100[leetcode]";
        System.out.println("Decoded string is : " + decodeString(s));
    }

    public static int i = 0;

    public static String decodeString(String s) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        String local_string = "";

        while (i < s.length()) {
            char c = s.charAt(i);
            i++;
            if (c == '[') {
                local_string = decodeString(s);
                for (int j = 0; j < count; j++) {
                    sb.append(local_string);
                }
                count = 0;

            } else if (c == ']') {
                break;

            } else if (Character.isAlphabetic(c)) {
                sb.append(c);
            } else {
                count = count * 10 + c - '0';
            }
        }
        return sb.toString();
    }

    // does not work
    public static String decodeString1(String s) {
        String output = "";
        int count_open = 0;
        StringBuilder op = new StringBuilder();
        StringBuilder local = new StringBuilder();
        StringBuilder n = new StringBuilder();
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ']') {
                while (stack.peek() != '[') {
                    local.append(stack.pop());
                }
                local.reverse();
                stack.pop();
                count_open--;
                n.setLength(0);
                while (!stack.isEmpty() && Character.getNumericValue(stack.peek()) > -1
                        && Character.getNumericValue(stack.peek()) < 10) {
                    n.append(stack.pop());
                }
                int num = Integer.parseInt(n.reverse().toString());
                while (num > 0) {
                    if (stack.isEmpty()) {
                        output += local.toString();
                    } else {
                        op.append(local);
                    }
                    num--;
                }
                if (stack.isEmpty()) {
                    local.setLength(0);
                    op.setLength(0);
                } else if (!stack.isEmpty() && count_open == 0) {
                    local.setLength(0);
                    while (!stack.isEmpty()) {
                        local.append(stack.pop());
                    }
                    output += local.reverse().toString() + op.toString();
                } else {
                    local = new StringBuilder(op.reverse());
                    op.setLength(0);
                }
            } else {
                if (s.charAt(i) == '[') {
                    count_open++;
                }
                stack.push(s.charAt(i));
            }
        }

        if (!stack.isEmpty()) {
            local.setLength(0);
            while (!stack.isEmpty()) {
                local.append(stack.pop());
            }
            local.reverse();
            output += local.toString();
        }

        return output;
    }

}
