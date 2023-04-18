package list;

public class MyLinkedList {
    public static void main(String[] args) {
        MyLinkedList list=new MyLinkedList();
        list.addAtHead(1);
        list.addAtTail(3);
        list.addAtIndex(1,2);
        System.out.println(list.get(1));
        list.deleteAtIndex(1);
        System.out.println(list.get(1));


    }



    class Node{
        int val;
        Node next;
        Node(int val){
            this.val=val;
        }

    }
    int size;
    Node head;

    public MyLinkedList() {
        this.size=0;
        this.head=null;
    }

    public int get(int index) {

        if(index < 0 || index > size - 1){
            return -1;
        }
        if(index==0){
            return head.val;
        }
        Node node=head;
        while( index > 0 ){
            node=node.next;
            index--;
        }
        return node.val;
    }

    public void addAtHead(int val) {
        if(size==0){
            this.head=new Node(val);

        }else{
            Node node=new Node(val);
            node.next=this.head;
            this.head=node;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node tail=new Node(val);
        tail.next=null;
        if(size==0){
            this.head=tail;
        }else{
            Node node=head;
            while(node.next!=null){
                node=node.next;
            }
            node.next=tail;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if(size==0 || index==0){
            addAtHead(val);
        }else if(index==size){
            addAtTail(val);
        }
        else{
            Node node1=head;
            Node node2=head;

            while(index-1>0){
                node1=node1.next;
                index--;
            }
            while(index>0){
                node2=node2.next;
                index--;
            }
            Node add=new Node(val);
            node1.next=add;
            add.next=node2;
        }
        size++;
    }

    public void deleteAtIndex(int index) {

        if(index<0 || index >= size){
            throw new RuntimeException("索引无效") ;

        }
        else if(index==0){
            if(size!=1){
                this.head=head.next;
                size--;

            }else{
                this.head=null;
                size--;
            }

        }
        else if(index==size-1){
            Node node=head;
            index--;
            while(index>0){
                node=node.next;
                index--;
            }
            node.next=null;
            size--;

        }
        else{

            Node node1=head;
            Node node2=head;
            int temp=index;
            while(index-1>0){
                node1=node1.next;
                index--;
            }
            while(temp+1>0){
                node2=node2.next;
                temp--;
            }
            node1.next=node2;
            size--;
        }

    }
}
