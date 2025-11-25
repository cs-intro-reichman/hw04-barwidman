public class KeywordsDetector {
    public static final int CAPITAL_TO_LOWER_CHAR_DELTA = 32;
    public static void main(String[] args) {
        String[] sentences = {
            "Our product will transform the market",
            "Programming is both painful and engaging",
            "This has nothing to do with machine learning",
            "We need to leverage our core competencies",
            "Let's talk about data and algorithms",
            "Chatbots are great but must be used carefully",
            "This blockchain-based solution will disrupt the industry",
            "The team showed great Synergy in the last project",
            "Use simple words without hype and fluff",
            "Our new technology presents a significant paradigm shift",
            "Effective presentations must be clear, concise, and humble"
        };
        // Some keywords that typically signal bullshit contents in business presentations 
        String[] keywords = {"synergy", "disrupt", "leverage", "Paradigm", "transform"};
        detectAndPrint(sentences, keywords);
    }

    // Using this function because I assume I'm not allowed to use `String.toLowerCase`
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

    // Iterates through all the sentences.
    // If a sentence contains one or more of the kewords, prints it.
    public static void detectAndPrint(String[] sentences, String[] keywords) {
        // Replace this comment with your code
        for (int i = 0; i < sentences.length; i++) {
            String currentSentence = sentences[i];
            for (int j = 0; j < keywords.length; j++) {
                if (contains(lowerCase(currentSentence),(lowerCase(keywords[j])))) {
                    System.out.println(currentSentence);
                }
            }
        }
    }
}
