package list;

import java.util.HashSet;

/*

给你一个链表的头节点 head ，判断链表中是否有环。
如果链表中有某个节点，可以通过连续跟踪 next 指针再次到达，则链表中存在环。
为了表示给定链表中的环，评测系统内部使用整数 pos 来表示链表尾连接到链表中的位置（索引从 0 开始）。注意：pos 不作为参数进行传递 。仅仅是为了标识链表的实际情况。
如果链表中存在环 ，则返回 true 。 否则，返回 false 。
 */
public class 环形链表 {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node2 = new Node(1);
        head.next = node2;
        Node node3 = new Node(5);
        node2.next = node3;
        Node node4 = new Node(8);
        node3.next = node4;
        System.out.println(hasSycle(head));
    }

    public static boolean hasSycle(Node head) {
        HashSet<Node> hs = new HashSet<>();
        while (head != null) {
            if (!hs.add(head)) {
                return true;
            }
            head = head.next;
        }
        return false;
    }
}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }
}
