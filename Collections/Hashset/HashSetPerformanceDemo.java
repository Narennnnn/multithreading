package Collections.Hashset;
import java.util.*;
public class HashSetPerformanceDemo {
    public static void main(String[] args) {
        // Generate a large array of numbers
        int[] numbers = new int[10000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = (int) (Math.random() * 1000000);
        }

        // Measure time to populate the set
        long startTime = System.nanoTime();
        Set<String> prefixes = new HashSet<>();
        int maxLen = 0;
        for (int num : numbers) {
            String s = Integer.toString(num);
            for (int i = 1; i <= s.length(); i++) {
                prefixes.add(s.substring(0, i));
                maxLen = Math.max(maxLen, i);
            }
        }
        long endTime = System.nanoTime();
        long duration = (endTime - startTime) / 1000000;  // Convert to milliseconds

        System.out.println("Number of prefixes stored: " + prefixes.size());
        System.out.println("Time taken to populate the set: " + duration + " ms");

        // Measure time for contains operation
        startTime = System.nanoTime();
        boolean contains = prefixes.contains("123456");
        endTime = System.nanoTime();
        duration = (endTime - startTime);  // Keep in nanoseconds for precision

        System.out.println("Time taken for contains operation: " + duration + " ns");

        // Demonstrate prefix matching
        String testNumber = "123456789";
        startTime = System.nanoTime();
        int longestPrefix = 0;
        for (int i = testNumber.length(); i > 0; i--) {
            if (prefixes.contains(testNumber.substring(0, i))) {
                longestPrefix = i;
                break;
            }
        }
        endTime = System.nanoTime();
        duration = (endTime - startTime);  // Keep in nanoseconds

        System.out.println("Longest matching prefix length for " + testNumber + ": " + longestPrefix);
        System.out.println("Time taken to find longest prefix: " + duration + " ns");
    }
}