package list;

public class Main {
    public static void main(String[] args) {
        Node head = new Node(0);
        Node node2 = new Node(1);
        head.next=node2;
        Node node3=new Node(5);
        node2.next=node3;
        Node node4=new Node(8);
        node3.next=node4;
        Node node5=new Node(15);
        node5.next=head;

        Node temp=head;
        head=node5;
        node5=temp;
        //----------
        int result1 = lastk(head,3);

        System.out.println(result1);

    }
    static class Node{
        int val;
        Node next;

        public Node(int val) {
            this.val=val;
        }
    }
    //
    public static int len(Node node){
        return node == null ? 0 : (len(node.next)+1);
    }

    public static int lastNodeVal(Node node){
        return node.next == null ? node.val:lastNodeVal(node.next);
    }

    public static int len2(Node node) {
        int i=1;
        while (node.next != null) {
            System.out.print(node.val+",");
            node=node.next;
            i++;
        }
        return i;
    }
    public static int lastNodeVal2(Node node){
        while (node.next != null) {
            node = node.next;
        }
        return node.val;
    }
    public static int lastk(Node node,int last_k){
        int fast=1;
        int slow=1;
        Node  node1=node;
        Node  node2=node;

        while(node1.next!=null){
            node1=node1.next;
            fast++;
            if(fast-slow==last_k){
                node2=node2.next;
                slow++;
            }
        }
        return node2.val;
    }
}
