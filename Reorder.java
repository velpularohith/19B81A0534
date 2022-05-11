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
 // Reordering the Linked List from LeetCode
class Reorder {
    public void reorderList(ListNode h) {
    ListNode mid = findmid(h,true);
        ListNode r = mid.next;
        mid.next = null;
        ListNode h1 = null;
        while(r != null)
        {
            ListNode ans = r.next;
            r.next = h1;
            h1 = r;
            r = ans;
        }
        h = merge(h,h1);
    }
    public ListNode findmid(ListNode h, boolean ans)
    {
        ListNode s = h;
        ListNode f = h;
        ListNode prev = null;
        while(f != null && f.next != null)
        {
            prev = s;
            s = s.next;
            f = f.next.next;
        }
        if(f == null && ans == true)
        {
            return prev;
        }
        return s;
    }
    public ListNode merge(ListNode h,ListNode h1)
    {
        ListNode dummy = new ListNode(-1);
        ListNode dummy1 = dummy;
        if(h == null)
        {
            return h1;
        }
        if(h1 == null)
        {
            return h;
        }
        while(h1 != null && h != null)
        {
            dummy.next = h;
            dummy = dummy.next;
            h = h.next;
            dummy.next = h1;
            dummy = dummy.next;
            h1 = h1.next;
            
        }
        if(h1 != null)
        {
            dummy.next = h1;
        }
        if(h != null)
        {
            dummy.next = h;
        }
        return dummy1.next;
    }
}