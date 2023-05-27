package ThreadedBinaryTree;

import java.util.HashMap;
import java.util.Map;

public class ThreadedBinaryTreeDemo {
    public static void main(String[] args) {

    }
}

// 定义ThreadedBinaryTree 实现线索化功能的二叉树

class BinaryTree {
    private Node head;
    private Node pre=null; //在递归的时候需要有一个指针指向前一个节点，保存前一个节点的地址信息。
                            // 不然的话不能把当前节点的的指针指向上一个节点

    Map map =new HashMap();
    public BinaryTree(Node head) {
        this.head = head;
    }

//   编写对二叉树实现线索化的方法。
//    从头节点开始
    public void threadedNode(Node node){

        if(node==null){
            return;
        }
//        先线索化左子支
        threadedNode(node.getLeft());
//        线索化当前节点
        if(node.getLeft()==null){
            node.setLeft(pre);
            node.setLeftType(1);
        }
        if(pre!=null && pre.getRight()==null){
            pre.setRight(node);
            pre.setLeftType(1);
        }

        pre=node;
//        线索化右子支
        threadedNode(node.getRight());
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


class Node{
    private int no;
    private String name;
    private Node left;
    private Node right;
    private int leftType; // 0 为指向左子支，1为指向前驱节点
    private int rightType;// 0 为指向右子支 ，1为指向后继节点

    public Node() {
    }

    public Node(int no, String name) {
        this.no = no;
        this.name = name;
    }

    public int getLeftType() {
        return leftType;
    }

    public void setLeftType(int leftType) {
        this.leftType = leftType;
    }

    public int getRightType() {
        return rightType;
    }

    public void setRightType(int rightType) {
        this.rightType = rightType;
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