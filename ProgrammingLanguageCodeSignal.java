import java.util.HashSet;

public class ProgrammingLanguageCodeSignal {
    public static void main(String[] args) {
        String[] words = new String[] { "is", "valid", "right" };
        String variableName = "isValid";
        boolean res = isValidVariableName(words, variableName);
        System.out.println("Result is : " + res);
    }

    public static boolean isValidVariableName(String[] words, String variableName) {
        HashSet<String> set = new HashSet<>();
        for (String string : words) {
            set.add(string);
        }
        String[] vars = variableName.split("(?=\\p{Upper})");
        for (String string : vars) {
            if (!set.contains(string.toLowerCase())) {
                return false;
            }
        }
        return true;
    }
}
