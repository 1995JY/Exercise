package binaryTree;

import java.util.*;

public class BinaryTreeDemo {
    public static void main(String[] args) {
        Node head=new Node(1,"宋江");
        Node node2=new Node(2,"吴用");
        Node node3=new Node(3,"晁盖");
        Node node4=new Node(4,"武松");
        Node node5=new Node(5,"林冲");
        head.setLeft(node2);
        head.setRight(node3);
        node3.setLeft(node4);
        node3.setRight(node5);
        BinaryTree bt=new BinaryTree(head);


//        bt.foreOrder();
//        bt.infixOrder();
        bt.postOrder();
        System.out.println("----------------");
        List<Node> nodes = bt.iteratePostOrder();
        for (Node node : nodes) {
            System.out.println(node);
        }
//        Node node = bt.foreOrderSearch(4);
//        System.out.println(node.getName());

    }
}
// 二叉树
class BinaryTree {
    private Node head;

    public BinaryTree(Node head) {
        this.head = head;
    }

    //    前序遍历
    public void foreOrder() {
        if (head == null) {
            System.out.println("二叉树为空");
        } else {
            head.foreOrder();
        }
    }

    //    中序遍历
    public void infixOrder() {
        if (head == null) {
            System.out.println("二叉树为空");
        } else {
            head.infixOrder();
        }
    }

    //    后续遍历
    public void postOrder() {
        if (head == null) {
            System.out.println("二叉树为空");
        } else {
            head.postOrder();
        }
    }

//    前序遍历查找
    public Node foreOrderSearch(int no){
        if(head!=null){
            return this.head.foreOrderSerach(no);
        }else{
            return null;
        }
    }
    //    中序遍历查找
    public Node infixOrderSearch(int no){
        if(head!=null){
            return this.head.infixOrderSearch(no);
        }else{
            return null;
        }
    }
    //    后序遍历查找
    public Node postOrderSearch(int no){
        if(head!=null){
            return this.head.postOrderSearch(no);
        }else{
            return null;
        }
    }

    //迭代法前序遍历
    public List<Node> iterateForeOrder(){
        List<Node> list=new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        if(head==null){
            return list;
        }
        stack.push(head);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            list.add(node);
            if(node.getRight()!=null){
                stack.push(node.getRight());
            }
            if(node.getLeft()!=null){
                stack.push(node.getLeft());
            }
        }
        return list;
    }
    //迭代法中序遍历
    public List<Node> iterateInfixOrder() {
        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();
        while (!stack.isEmpty() || head != null){
            if(head!=null){
                stack.push(head);
                head=head.getLeft();
            }else{
                Node temp = stack.pop();
                list.add(temp);
                head=temp.getRight();
            }
        }
        return list;

    }
    // 迭代法的后序遍历
    public List<Node> iteratePostOrder() {
        List<Node> list = new ArrayList<>();
        Stack<Node> stack = new Stack<>();

        while(head != null || (!stack.empty())){
            if(head != null){
                stack.push(head);
                list.add(0,head);
                head = head.getRight();
            }else{//右子树为空
               Node temp = stack.pop();
                head = temp.getLeft();
            }
        }
        return list;
    }
    // 二叉树的层序遍历迭代
    public List<Node> iterateOrderByFloor(){
        List<Node> list = new ArrayList<>();
        Queue<Node> queue = new LinkedList<>();
        queue.add(head);
        while (!queue.isEmpty()){
            Node node = queue.poll();
            list.add(node);
            if(node.getLeft()!=null){
                queue.add(node.getLeft());
            }
            if(node.getRight()!=null){
                queue.add(node.getRight());
            }
        }


        return list;
    }


    //    删除节点
    /**
     * 删除节点（约定，如果删除的节点是叶节点，就直接删除该节点 如果该节点不是叶结点，就直接删除该分支）
     * @param no
     */
    public void delNode(int no){
        if(this.head==null || this.head.getNo()==no){
            this.head=null;
        }else {
            this.head.delNode(no);
        }
    }


}
// 节点
class   Node{
    private int no;
    private String name;
    private Node left;
    private Node right;

    public Node() {
    }

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    /**
     * 获取
     * @return no
     */
    public int getNo() {
        return no;
    }

    /**
     * 设置
     * @param no
     */
    public void setNo(int no) {
        this.no = no;
    }

    /**
     * 获取
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * 设置
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 获取
     * @return left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * 设置
     * @param left
     */
    public void setLeft(Node left) {
        this.left = left;
    }

    /**
     * 获取
     * @return right
     */
    public Node getRight() {
        return right;
    }

    /**
     * 设置
     * @param right
     */
    public void setRight(Node right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return "Node{no = " + no + ", name = " + name + "}";
    }

    /**
     * 删除节点
     * @param no
     */
    public void delNode(int no){
        if( this.left!=null && this.left.no==no){
            this.left=null;
            return;
        }
        if(this.right !=null && this.right.no==no){
            this.right=null;
            return;
        }
        if(this.left!=null){
            this.left.delNode(no);
        }

        if(this.right!=null){
            this.right.delNode(no);
        }
    }
//    前序遍历
    public void foreOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.foreOrder();
        }
        if(this.right!=null){
            this.right.foreOrder();
        }
    }
//    中序遍历
    public void infixOrder(){
        if(this.left!=null){
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null){
            this.right.infixOrder();
        }
    }
//    后序遍历
    public void postOrder(){
        if(this.left!=null){
            this.left.postOrder();
        }
        if(this.right!=null){
            this.right.postOrder();
        }
        System.out.println(this);
    }

    /**
     * 前序遍历查找
     * @param no
     * @return
     */
    public Node foreOrderSerach(int no){
        if(this.no==no){
            return this;
        }
        Node result=null;
        if(this.left!=null){
           result= this.left.foreOrderSerach(no);
        }
        if(result!=null){
            return result;
        }
        if(this.right!=null){
            result=this.right.foreOrderSerach(no);
        }
        if(result!=null){
            return result;
        }
        System.out.println(this.no);
        return result;
    }

    /**
     * 中序遍历查找
     * @param no
     * @return
     */
    public Node infixOrderSearch(int no){
        Node result=null;
        if(this.left!=null){
            result=this.left.infixOrderSearch(no);
        }
        if(result!=null){
            return result;
        }
        if(this.no==no){
            return this;
        }
        if(this.right!=null){
            result=this.right.infixOrderSearch(no);
        }
        if (result!=null){
            return result;
        }
        System.out.println(this.no);
        return null;
    }

    /**
     * 后续遍历查找
     * @param no
     * @return
     */
    public Node postOrderSearch(int no){
        Node result=null;
        if(this.left!=null){
            result=this.left.infixOrderSearch(no);
        }
        if(result!=null){
            return result;
        }
        if(this.right!=null){
            result=this.right.infixOrderSearch(no);
        }
        if (result!=null){
            return result;
        }
        if(this.no==no){
            return this;
        }
        System.out.println(this.no);
        return null;
    }
}

