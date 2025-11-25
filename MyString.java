public class MyString {
    public static final int CAPITAL_TO_LOWER_CHAR_DELTA = 32;
    public static void main(String[] args) {
        System.out.println("Testing lowercase:");
        System.out.println("UnHappy : " + lowerCase("UnHappy"));
        System.out.println("This costs 15 Sheksls : " + lowerCase("This costs 15 Sheksls"));
        System.out.println("TLV : " + lowerCase("TLV"));
        System.out.println("lowercase : " + lowerCase("lowercase"));

        System.out.println("Testing contains:");
        System.out.println(contains("unhappy", "happy")); // true
        System.out.println(contains("happy", "unhappy")); // false
        System.out.println(contains("historical", "story")); // false
        System.out.println(contains("psychology", "psycho")); // true
        System.out.println(contains("personality", "son")); // true
        System.out.println(contains("personality", "dad")); // false
        System.out.println(contains("resignation", "sign")); // true
    }

    /** Returns the lowercase version of the given string. */
    public static String lowerCase(String str) {
        // Replace the following statement with your code
        String outStr = "";
        for (int i = 0; i < str.length(); i++) {
            char currentChar = str.charAt(i);
            if (currentChar >= 'A' && currentChar <= 'Z' ) {
                outStr += (char)(currentChar + CAPITAL_TO_LOWER_CHAR_DELTA);
            }
            else {
                outStr += currentChar;
            }
        }
        return outStr;
    }

    /** If str1 contains str2, returns true; otherwise returns false. */
    public static boolean contains(String str1, String str2) {
        if (str1.length() < str2.length()) {
            return false;
        }

        // For some reason, containing an empty string is fine...
        if (str2.length() == 0) {
            return true;
        }

        for (int i = 0; i < str1.length(); i++) {
            boolean found = true;
            for (int j = 0; j < str2.length() ; j++) {
                // Annoying edge case.
                if (i + j >= str1.length()) {
                    return false;
                }
                if (str1.charAt(i + j) != str2.charAt(j)) {
                    found = false;
                    break;
                }
            }
            if (found) {
                return true;
            }
        }
        return false;
    }
}
