import java.util.Stack;

public class BackSpaceStringCompare {
    public static void main(String[] args) {
        String s = "y#fo##f";
        String t = "y#f#o##f";
        // String s = "ab##";
        // String t = "ad##";
        System.out.println("Result is : " + backspaceCompare(s, t));
    }

    // Time O(n) and space O(n)
    public static boolean backspaceCompare(String s, String t) {
        return cleanString(s).equals(cleanString(t));

    }

    public static String cleanString(String s) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (sb.length() > 0) {
                    sb.deleteCharAt(sb.length() - 1);
                }
            } else {
                sb.append(s.charAt(i));
            }
        }
        System.out.println(sb.toString());
        return sb.toString();
    }

    // Time - O(n) and space O(n)
    public static boolean backspaceCompare1(String s, String t) {
        Stack<Character> stack = new Stack<>();
        String s1 = "", t1 = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '#') {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.add(s.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            s1 += stack.pop();
        }
        for (int i = 0; i < t.length(); i++) {
            if (t.charAt(i) == '#') {
                if (stack.size() > 0) {
                    stack.pop();
                }
            } else {
                stack.add(t.charAt(i));
            }
        }
        while (!stack.isEmpty()) {
            t1 += stack.pop();
        }
        if (s1.equals(t1)) {
            return true;
        }
        return false;
    }
}
