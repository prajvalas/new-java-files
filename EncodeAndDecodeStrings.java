
public class EncodeAndDecodeStrings {
    public static void main(String[] args) {
        String[] strs = new String[] { "leet", "#code#", "$&*(love", ";;;;;;you" };
        System.out.println("Performing encoding and decoding of the string in java.");
        int len = strs.length;
        String encoded_string = encode(strs);
        String[] decoded_strings = decode(encoded_string, len);

        int i = 0;
        boolean flag = true;
        for (String string : decoded_strings) {
            if (!string.equals(strs[i++])) {
                System.out.println("The encode-decode algorithm is broken");
                flag = false;
            }
        }
        if (flag) {
            System.out.println("The encode-decode algorithm worked perfectly well.");
        }

    }

    public static String encode(String[] strs) {
        String result = "";
        int len = 0;
        for (String s : strs) {
            len = s.length();
            result += String.valueOf(len) + "#" + s;
        }
        System.out.println("Encoded string is : " + result);
        return result;
    }

    public static String[] decode(String str, int len) {
        String result[] = new String[len];
        int i = 0;
        int j = 0;
        while (i < str.length()) {
            int num = Character.getNumericValue(str.charAt(i));
            i += 2;
            result[j++] = str.substring(i, i + num);
            i += num;
        }
        for (String string : result) {
            System.out.println(string);
        }
        return result;
    }

}