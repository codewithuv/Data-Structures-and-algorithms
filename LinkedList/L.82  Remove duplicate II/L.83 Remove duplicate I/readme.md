
---

# 🚀 Remove Duplicates from Sorted Linked List (LeetCode 83)

## 📌 Problem Statement

Given the head of a **sorted linked list**, delete all duplicates such that each element appears only once. Return the linked list **sorted**.

👉 Example:

```
Input:  1 -> 1 -> 2
Output: 1 -> 2
```

```
Input:  1 -> 1 -> 2 -> 3 -> 3
Output: 1 -> 2 -> 3
```

---

## 💡 Approach

* Since the list is **sorted**, duplicates will always appear next to each other.
* Traverse the list using a pointer `current`.
* If `current.val == current.next.val`, skip the duplicate node by updating `current.next = current.next.next`.
* Otherwise, move `current` forward.
* Continue until the end of the list.

---

## 🛠️ Code (Java)

```java
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode current = head;
        while (current != null && current.next != null) {
            if (current.val == current.next.val) {
                current.next = current.next.next; // Skip duplicate
            } else {
                current = current.next; // Move forward
            }
        }
        return head;
    }
}
```

---

## ✅ Example Run

**Input:**

```
1 -> 1 -> 2 -> 3 -> 3
```

**Output:**

```
1 -> 2 -> 3
```

---

## 📊 Complexity Analysis

* **Time Complexity:** O(n) – each node is checked once.
* **Space Complexity:** O(1) – no extra space is used, only pointers.

---

## 🏆 Topics Covered

* Linked List
* Two Pointers
* In-place Modification

---

✨ This problem is a **simpler version** of removing duplicates where **only extra occurrences are removed**, unlike [Remove Duplicates II](https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/) where all duplicates are deleted.

---

