package StringMatchingAlgos;

public class NaiveStringMatching {
    public static void search(String text, String pattern) {
        int n = text.length();
        int m = pattern.length();

        // Slide pattern over text one by one
        for (int i = 0; i <= n - m; i++) {
            int j;
            // Check for pattern match at this position
            for (j = 0; j < m; j++) {
                if (text.charAt(i + j) != pattern.charAt(j)) {
                    break;
                }
            }
            // If j reaches m, a match was found
            if (j == m) {
                System.out.println("Pattern found at index " + i);
            }
        }
    }

    public static void main(String[] args) {
        String text = "AABAACAADAABAABA";
        String pattern = "AABA";
        search(text, pattern);
    }
}

