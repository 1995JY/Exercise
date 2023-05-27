package BinarySortTree;

public class BinarySortTreeDemo {
    public static void main(String[] args) {

        int[] arr={7,3,10,12,5,1,9};
        BinarySortTree tree = new BinarySortTree();
        for (int i : arr) {
            tree.add(new Node(i));
        }
        tree.infixOrder();
    }
}

//二插排序树
class BinarySortTree{
    Node head;

    public BinarySortTree() {
    }
//二插排序树添加节点
    public void add(Node node){
        if(head == null){
            head=node;
        }else {
            this.head.add(node);
        }
    }
//    二叉排序树的遍历
    public void infixOrder(){
        if(head==null){
            System.out.println("当前树为空");
        }else {
            head.infixOrder();
        }
    }
}
//节点
class Node{
    int val;
    Node left;
    Node right;

    public Node() {
    }

    public Node(int val) {
        this.val = val;
    }

    public String toString() {
        return "Node{val = " + val + ", left = " + left + ", right = " + right + "}";
    }

//    二叉树的查找要删除的节点
    public Node search(int val){

        if(this.val==val){
            return this;
        }else if(this.val>val){
            if(this.left==null){
                return null;
            }
            return this.left.search(val);

        }else {
            if(this.right==null){
                return null;
            }
            return this.right.search(val);
        }

    }
//    二叉树查找要删除的节点的parent节点
    public Node searchParent(int val){
        if((this.left!=null && this.left.val==val)||
                (this.right!=null && this.right.val==val)){
            return this;
        }else if(this.left!=null && this.val>val){
            return this.left.searchParent(val);
        }else if(this.right!=null && this.val<val){
            return this.right.searchParent(val);
        }else {
            return null;
        }


    }

//   二插排序树的插入
    public void add(Node node){

//      相等往右添加
        if(node.val<this.val){
            if(this.left==null){
                this.left=node;
            }else{
                this.left.add(node);
            }
        }else {
            if(this.right==null){
                this.right=node;
            }else{
                this.right.add(node);

            }
        }
    }
//    二叉树的中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this.val);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
}
