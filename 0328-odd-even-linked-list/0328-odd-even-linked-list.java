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
    public ListNode oddEvenList(ListNode head) {
     
        if(head==null || head.next==null || head.next.next==null) return head;

        ListNode prev=head;
        ListNode mid=head.next;
        ListNode curr=head.next.next;
        ListNode dummy =new ListNode(0);
        ListNode temp=dummy;
        while(prev!=null && mid!=null && curr!=null)
        {

                temp.next=mid;
                temp=mid;
                mid.next=null;

                prev.next=curr;

                prev=curr;
                mid=curr.next;
                if(mid!=null) curr=mid.next;

            
        }

        if(prev.next!=null)
        {
            mid=prev.next;
            temp.next=mid;
            temp=mid;
            mid.next=null;
            prev.next=null;
        }
        
        ListNode tail=head;
        while(tail.next!=null) tail=tail.next;

        tail.next=dummy.next;

        return head;

    }
}