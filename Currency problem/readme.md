
---

````markdown
# 💵 Java Currency Formatter

This project demonstrates how to format a monetary value into different currency formats using Java's **`NumberFormat`** and **`Locale`** classes.

---

## 📌 Problem Statement
Given a double-precision number representing an amount of money, convert it into the **US, Indian, Chinese, and French** currency formats using the `NumberFormat.getCurrencyInstance` method.

Since Java does not provide a built-in **India Locale**, you must construct one with:
```java
Locale indiaLocale = new Locale("en", "IN");
````

---

## 📂 Example

### Input

```
12324.134
```

### Output

```
US: $12,324.13
India: ₹12,324.13
China: ￥12,324.13
France: 12 324,13 €
```

---

## 📝 Solution

```java
import java.util.*;
import java.text.*;

public class Solution {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double payment = scanner.nextDouble();
        scanner.close();

        // US Locale
        NumberFormat usFormat = NumberFormat.getCurrencyInstance(Locale.US);
        String us = usFormat.format(payment);

        // India Locale (custom)
        Locale indiaLocale = new Locale("en", "IN");
        NumberFormat indiaFormat = NumberFormat.getCurrencyInstance(indiaLocale);
        String india = indiaFormat.format(payment);

        // China Locale
        NumberFormat chinaFormat = NumberFormat.getCurrencyInstance(Locale.CHINA);
        String china = chinaFormat.format(payment);

        // France Locale
        NumberFormat franceFormat = NumberFormat.getCurrencyInstance(Locale.FRANCE);
        String france = franceFormat.format(payment);

        // Output
        System.out.println("US: " + us);
        System.out.println("India: " + india);
        System.out.println("China: " + china);
        System.out.println("France: " + france);
    }
}
```

---

## ▶️ How to Run

1. Save the code in a file named `Solution.java`
2. Compile:

   ```bash
   javac Solution.java
   ```
3. Run:

   ```bash
   java Solution
   ```
4. Provide input (double value) in the console:

   ```
   12324.134
   ```

---

## 📌 Notes

* `NumberFormat.getCurrencyInstance(Locale.US)` → formats currency for the US.
* `Locale indiaLocale = new Locale("en", "IN")` → custom locale for India.
* `NumberFormat.getCurrencyInstance(Locale.CHINA)` → formats currency in Chinese Yuan.
* `NumberFormat.getCurrencyInstance(Locale.FRANCE)` → formats currency in Euros.

---

```

---
