import java.util.Scanner;

public class Main {

    // Definition for singly-linked list.
    static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    static class Solution {
        public ListNode deleteDuplicates(ListNode head) {
             ListNode current =head;
            while(current !=null && current.next !=null)
            {
                if(current.val == current.next.val)
                {
                    current.next =current.next.next;
                }
                else
                {
                    current=current.next;
                }
        
     }
     return head;
        }
    }

    // Utility method to build linked list from array
    public static ListNode buildList(int[] arr) {
        if (arr.length == 0) return null;
        ListNode head = new ListNode(arr[0]);
        ListNode temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new ListNode(arr[i]);
            temp = temp.next;
        }
        return head;
    }

    // Utility method to print linked list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Input
        System.out.println("Enter number of nodes:");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter " + n + " sorted values:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Build list
        ListNode head = buildList(arr);

        // Solve
        Solution sol = new Solution();
        ListNode result = sol.deleteDuplicates(head);

        // Output
        System.out.println("List after removing duplicates:");
        printList(result);
    }
}
