
---

```markdown
# Java Date and Time - Find Day of the Week

This project demonstrates how to determine the **day of the week** for a given date using Java's `Calendar` class.

---

## 📌 Problem Statement
You are given a date in the format **MM DD YYYY**.  
Write a program to return the **day of the week** corresponding to that date.

### Example:
Input:
```

08 05 2015

```

Output:
```

WEDNESDAY

````

---

## 📂 Solution

We use Java's built-in **`Calendar`** class:
- Set the date with `cal.set(year, month - 1, day)`  
  *(Months are zero-based in Calendar, i.e., January = 0)*  
- Retrieve the weekday using:
  ```java
  cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH)
````

* Convert it to uppercase to match the required output format.

---

## 📝 Code

```java
import java.util.*;

public class Solution {
    
    public static String findDay(int month, int day, int year) {
        Calendar cal = Calendar.getInstance();
        cal.set(year, month - 1, day); // Month is 0-based
        String dayOfWeek = cal.getDisplayName(Calendar.DAY_OF_WEEK, Calendar.LONG, Locale.ENGLISH);
        return dayOfWeek.toUpperCase();
    }
    
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int month = in.nextInt();
        int day = in.nextInt();
        int year = in.nextInt();
        in.close();
        
        System.out.println(findDay(month, day, year));
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
4. Provide input in the format:

   ```
   MM DD YYYY
   ```

---

## ✅ Sample Run

Input:

```
08 05 2015
```

Output:

```
WEDNESDAY
```

---

## 📌 Notes

* This solution uses the **`Calendar`** class.
* For Java 8+, you can use the **`LocalDate`** and **`DayOfWeek`** classes from `java.time` for a cleaner approach.

```

---

