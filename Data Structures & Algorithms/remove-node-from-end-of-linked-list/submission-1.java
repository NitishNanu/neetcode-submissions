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

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = getLen(head);
        int k = len - n;

        if (k == 0) {
            return head.next;
        }
        int cnt=0;
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null && cnt<k){
            prev = curr;
            curr = curr.next;
            cnt++;
        }
        if(prev == null) return curr.next;
        prev.next = curr.next;
        return head;
    }

    public int getLen(ListNode curr){
        int cnt=0;
        while(curr!=null){
            cnt++;
            curr=curr.next;
        }
        return cnt;
    }
}
