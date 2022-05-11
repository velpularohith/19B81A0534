/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

 // Rotating the Linked List from LeetCode
class RotateList {
    public ListNode rotateRight(ListNode A, int B) {
        ListNode head = A;
        int c = 0;
        if(head == null || head.next == null)
        {
            return head;
        }
        while(head != null)
        {
            c++;
            head = head.next;
        }
        if(B % c == 0)
        {
            return A;
        }
        B = B % c;
        head = A;
        for(int i = 0; i < c - B - 1; i++)
        {
            head = head.next;
        }
        ListNode right = head.next;
        ListNode right1 = right;
        head.next = null;
        while(right1 != null && right1.next != null)
        {
            right1 = right1.next;
        }
        right1.next = A;
        return right;
    }
}