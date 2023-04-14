package crossList;

public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode nodeA=headA;
        ListNode nodeB=headB;
        // 起点相同的情况
        if(nodeA==nodeB){
            return nodeA;
        }
        //
        while(nodeA.next==null || nodeB.next==null ){
            nodeA=nodeA.next;
            nodeB=nodeB.next;
            // 长度相同的情况，必定相遇
            if(nodeA==nodeB){
                return nodeA;
            }
        }
        int i=0;
        // 长度不同，A先走到尽头
        if(nodeA.next==null){
            // 计算B还需要走多少步
            while(nodeB.next!=null){
                nodeB=nodeB.next;
                i++;
            }
            // 同步AB起点
            nodeA=headA;
            nodeB=headB;
            // B先走i步
            for(int j=0;j<i;j++){
                nodeB=nodeB.next;
            }
            // 再同步前进
            while(nodeA!=null){
                nodeA=nodeA.next;
                nodeB=nodeB.next;
                // 相同则证明相交，任意返回一个都是相交点。
                if (nodeA==nodeB){
                    return nodeA;
                }
            }
            // 走到底都没有相等的，则说明不相交，返回null
            return null;
        } else{
            while(nodeA.next!=null){
                nodeA=nodeA.next;
                i++;
            }
            nodeA=headA;
            nodeB=headB;
            for(int j=0;j<i;j++){
                nodeA=nodeA.next;
            }
            while(nodeA.next!=null){
                nodeA=nodeA.next;
                nodeB=nodeB.next;
                if (nodeA==nodeB){
                    return nodeA;
                }
            }
            return null;
        }
    }
}
