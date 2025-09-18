import java.util.*;

public class Solutions {
    public static int countWords(String str, String word) {
        // Count frequency of str
        Map<Character, Integer> strFreq = new HashMap<>();
        for (char c : str.toCharArray()) {
            if (Character.isLetter(c)) { // ignore spaces/non-letters
                strFreq.put(c, strFreq.getOrDefault(c, 0) + 1);
            }
        }

        // Count frequency of word
        Map<Character, Integer> wordFreq = new HashMap<>();
        for (char c : word.toCharArray()) {
            wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
        }

        // Find minimum ratio
        int min = Integer.MAX_VALUE;
        for (char c : wordFreq.keySet()) {
            if (!strFreq.containsKey(c)) {
                return 0; // missing character
            }
            min = Math.min(min, strFreq.get(c) / wordFreq.get(c));
        }

        return min;
    }

    public static void main(String[] args) {
        String str1 = "This is a test string";
        String word1 = "tsit";
        System.out.println(countWords(str1.toLowerCase(), word1.toLowerCase())); // 2

        String str2 = "Here is HashedIn Technologies";
        String word2 = "neurons";
        System.out.println(countWords(str2.toLowerCase(), word2.toLowerCase())); // 0
    }
}

// Greedy Simulation Approach( )

import java.util.*;

public class Main {
public static int countWords(String str, String word) {
    Map<Character, Integer> strFreq = new HashMap<>();
    for (char c : str.toCharArray()) {
        if (Character.isLetter(c)) {
            strFreq.put(c, strFreq.getOrDefault(c, 0) + 1);
        }
    }

    Map<Character, Integer> wordFreq = new HashMap<>();
    for (char c : word.toCharArray()) {
        wordFreq.put(c, wordFreq.getOrDefault(c, 0) + 1);
    }

    int count = 0;
    while (true) {
        boolean canForm = true;
        for (char c : wordFreq.keySet()) {
            if (strFreq.getOrDefault(c, 0) < wordFreq.get(c)) {
                canForm = false;
                break;
            }
        }
        if (!canForm) break;

        // Deduct characters once
        for (char c : wordFreq.keySet()) {
            strFreq.put(c, strFreq.get(c) - wordFreq.get(c));
        }
        count++;
    }
    return count;
}

    public static void main(String[] args) {
        String str1 = "This is a test string";
        String word1 = "tsit";
        System.out.println(countWords(str1.toLowerCase(), word1.toLowerCase())); // 2

        String str2 = "Here is HashedIn Technologies";
        String word2 = "neurons";
        System.out.println(countWords(str2.toLowerCase(), word2.toLowerCase())); // 0
    }
}
