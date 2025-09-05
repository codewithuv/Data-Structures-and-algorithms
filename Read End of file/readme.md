
# 📌 Reading Input Until End-of-File (EOF) in Java

In competitive programming and coding challenges, sometimes the number of input lines is **unknown**. Instead of reading a fixed number of lines, we keep reading input **until EOF (End Of File)**.

Java provides a handy way to achieve this using the **`Scanner.hasNext()`** method.

---

## 🔹 What is `hasNext()`?

* `hasNext()` checks if there is another token (input) available.
* It **returns true** if input is available, otherwise **false** (when EOF is reached).
* Commonly used inside a **while loop** to continuously read data until no more input is left.

---

## 🔹 Example Code

```java
import java.util.Scanner;

public class ReadUntilEOF {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int lineNumber = 1;

        // Keep reading until EOF
        while (sc.hasNext()) {
            String line = sc.nextLine();
            System.out.println(lineNumber + " " + line);
            lineNumber++;
        }
        sc.close();
    }
}
```

---

## 🔹 Input Example

```
Hello world
I am a file
Read me until end-of-file.
```

---

## 🔹 Output Example

```
1 Hello world
2 I am a file
3 Read me until end-of-file.
```

---

## 🔹 Explanation

1. `sc.hasNext()` → checks if there is more input.
2. `sc.nextLine()` → reads the entire line of input.
3. Loop continues until EOF (no more input).
4. Works even when the number of input lines is **not known beforehand**.

---

## 🔹 Where is this useful?

* HackerRank / LeetCode / Codeforces style problems where input ends with EOF.
* Log or file processing.
* Streaming input data until no more data is available.

---

✅ **In short**:
Use `while (sc.hasNext())` in Java to **read input until EOF**, making your program flexible for unknown input sizes.

---

Would you like me to also prepare a **Python version of this README** (using `sys.stdin` for EOF handling) so you can keep both together?
