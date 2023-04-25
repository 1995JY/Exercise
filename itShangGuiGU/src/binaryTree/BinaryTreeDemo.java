package binaryTree;

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

}
// 节点
class Node{
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
}

