import java.util.*;

public class NokiaKeypadDecoder {

    // Mapping of digits to letters
    private static final String[] KEYPAD = {
        "",     // 0
        "",     // 1
        "ABC",  // 2
        "DEF",  // 3
        "GHI",  // 4
        "JKL",  // 5
        "MNO",  // 6
        "PQRS", // 7
        "TUV",  // 8
        "WXYZ"  // 9
    };

    public static String decodeMessage(String input) {
        StringBuilder result = new StringBuilder();

        // Split by '*' since each '*' marks the end of one letter
        String[] parts = input.split("\\*");

        for (String part : parts) {
            if (part.isEmpty()) continue;

            char digit = part.charAt(0); // same digit
            int count = part.length();

            String letters = KEYPAD[digit - '0'];   //KEYPAD[Integer.valueOf(digit+"")];

            if (!letters.isEmpty()) {
                // wrap around using modulo
                char letter = letters.charAt((count - 1) % letters.length());
                result.append(letter);
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {
        String input1 = "2222*444*5";
        System.out.println(decodeMessage(input1)); // Output: AIJ

        String input2 = "222*2*8";
        System.out.println(decodeMessage(input2)); // Output: CAT
    }
}
