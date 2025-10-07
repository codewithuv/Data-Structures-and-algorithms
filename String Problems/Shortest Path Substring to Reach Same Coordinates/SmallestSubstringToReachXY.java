import java.util.*;

public class SmallestSubstringToReachXY {
    public static void main(String[] args) {
        String s = "RLUDRL";
        findSmallestSubstring(s);
    }

    static void findSmallestSubstring(String s) {
        int n = s.length();
        int x = 0, y = 0;

        // Step 1: Find final position
        for (char c : s.toCharArray()) {
            if (c == 'R') x++;
            else if (c == 'L') x--;
            else if (c == 'U') y++;
            else if (c == 'D') y--;
        }

        // Step 2: Find smallest substring that ends at same (x, y)
        Map<String, Integer> map = new HashMap<>();
        map.put("0,0", -1); // starting point before index 0

        int curX = 0, curY = 0;
        int minLen = Integer.MAX_VALUE;
        int start = -1, end = -1;

        for (int i = 0; i < n; i++) {
            char c = s.charAt(i);
            if (c == 'R') curX++;
            else if (c == 'L') curX--;
            else if (c == 'U') curY++;
            else if (c == 'D') curY--;

            // We reached the final destination point (x, y)
            if (curX == x && curY == y) {
                minLen = Math.min(minLen, i + 1);
                start = 0;
                end = i;
            }

            // Check if we’ve seen (curX - x, curY - y) before
            String key = (curX - x) + "," + (curY - y);
            if (map.containsKey(key)) {
                int j = map.get(key);
                if (i - j < minLen) {
                    minLen = i - j;
                    start = j + 1;
                    end = i;
                }
            }

            map.put(curX + "," + curY, i);
        }

        if (minLen == Integer.MAX_VALUE) {
            System.out.println("No substring found");
        } else {
            System.out.println("Smallest Substring: " + s.substring(start, end + 1));
            System.out.println("Length: " + minLen);
        }
    }
}
