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
    public void reorderList(ListNode head) {
     
        ListNode mid=findMid(head);
        // System.out.println(mid.val);
        ListNode temp=mid.next;
        mid.next=null;
    
        ListNode newHead=null;
        while(temp!=null)
        {
            
                ListNode newNode=new ListNode(temp.val);
                newNode.next=newHead;
                newHead=newNode;
                
            temp=temp.next;
            
        }
        // ListNode tt=head;
        // while(tt!=null) {
        //     System.out.println(tt.val);
        //     tt=tt.next;
        // }
        ListNode itr=newHead;
        ListNode prev=head;
        
        while(prev!=null )
        {
            ListNode curr=prev.next;
            prev.next=itr;
            temp=itr!=null?itr.next:null;
           if(itr!=null) itr.next=curr;
            itr=temp;
            prev=curr;

        }
        // return head;
    }
    public ListNode findMid(ListNode head)
    {
        ListNode slow=head;
        ListNode fast=head;
        
        while(fast.next!=null && fast.next.next!=null)
        {
            fast=fast.next.next;
            slow=slow.next;
        }
        
        return slow;
    }
}