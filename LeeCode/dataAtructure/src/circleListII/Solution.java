package circleListII;


public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode fast=head;
        ListNode slow=head;
        ListNode temp=null;
        while(fast!=null && fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            if(fast==slow){
                temp=fast;
            }
        }
        if(temp!=null){
            slow=head;
            while(fast!=slow){
                fast=fast.next;
                slow=slow.next;
            }
            return fast;
        }
        return null;
    }
}
