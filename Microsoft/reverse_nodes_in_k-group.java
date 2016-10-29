/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode p = dummy;
        
        while(true){
            int cnt = k;
            ListNode tail = p;
            while(cnt > 0 && tail.next != null){
                tail = tail.next;
                cnt--;
            }
            if (cnt > 0) break;

            ListNode newP = p.next;
            ListNode tmp = p.next;
        
            while(p.next != tail){
                p.next = tmp.next;
                tmp.next = tail.next;
                tail.next = tmp;
                tmp = p.next;
            }
            
            p = newP;
        }
        
        return dummy.next;
    }
}