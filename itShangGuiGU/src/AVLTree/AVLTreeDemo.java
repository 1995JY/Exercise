package AVLTree;

public class AVLTreeDemo {
    public static void main(String[] args) {
        int[] arr={4,3,6,5,7,8};
        AVLTree avlTree = new AVLTree();
        for (int i : arr) {
            avlTree.add(new Node(i));
        }
        int height = avlTree.treeHight();
        int leftHeight = avlTree.leftHeight();
        int rightHeight = avlTree.rightHeight();
        System.out.println(height);
        System.out.println(leftHeight);
        System.out.println(rightHeight);

    }
}

class AVLTree{
    Node head;

    public AVLTree() {
    }
    //avl树的高度
    public int treeHight(){
        if(head==null){
            return 0;
        }
        return head.height();
    }
    //左支的高度
    public int leftHeight(){
        if(head==null || head.left==null){
            return 0;
        }else {
            return head.leftHeight();
        }
    }
    //右支的高度
    public int rightHeight(){
        if(head==null || head.right==null){
            return 0;
        }else {
            return head.rightHeight();
        }
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

    //    查找要删除的节点
    public Node search(int val){
        if(this.head==null){
            return null;
        }else {
            return this.head.search(val);
        }
    }

    //    查找父节点
    public Node searchParent(int val){
        if(this.head==null){
            return null;
        }else {
            return this.head.searchParent(val);
        }
    }
//    删除节点

    //  删除节点
    public int rightTreeMinNode(Node node){
        Node target=node;
        target=target.right;
        while (target.left!=null){
            target=target.left;
        }
        deleteNode(target.val);
        return target.val;
    }
    //
    public void deleteNode(int val){
        if(head==null){
            return;
        }else {
            Node targetNode = head.search(val);
            Node parent = head.searchParent(val);
            if(targetNode==null){
                return;
            }
//            当前的树就只有1个头节点，并且该头节点就是要删除的节点
            if(head.left==null && head.right==null){
                head=null;
            }
//            删除的节点是叶子节点 2,5,9,12
            /*
 第一种情况：删除叶节点
(1)需求先去找到要删除的结点targetNode
(2)找到targetNode的父结点parent
(3)确定targetNode是parent的左子结点还是右子结点
(4)根据前面的情况来对应删除
左子结点parent.left = null
右子结点parent.right = null;
             */
            if(targetNode.left==null && targetNode.right==null){
                if(parent.left==targetNode){
                    parent.left=null;
                }else {
                    parent.right=null;
                }
            }
//            删除的节点是只有1个子支的节点
            /*
第二种情况:删除只有一-颗子树的节点比如1
(1)需求先去找到要删除的结点targetNode
(2)找到targetNode的父结点parent
(3)确定targetNode的子结点是左子结点还是右子结点(4) targetNode是parent的左子结点还是右子结点(5)如果targetNode有左子结点
5. 1如果targetNode是parent的左子结点 parentleft = targetNode.left;
5.2如果targetNode是parent的右子结点  parent.right = targetNode.left;
(6)如果targetNode有右子结点
6.1如果targetNocte是parent 的左子结点 parent.left = targetNode.right;
6.2如果targetNode是parent的右子结点 parentright = targetNode.right
             */
            if ((targetNode.left == null && targetNode.right != null)
                    || (targetNode.left != null && targetNode.right == null)) {
                if (parent != null) {
                    if (targetNode.left == null) {
                        if (parent.left == targetNode) {
                            parent.left = targetNode.right;
                        } else {
                            parent.right = targetNode.right;
                        }
                    } else {
                        head = targetNode;
                    }
                } else {
                    if (parent != null) {
                        if (parent.left == targetNode) {
                            parent.left = targetNode.left;
                        } else {
                            parent.right = targetNode.left;
                        }
                    } else {
                        head = targetNode;
                    }

                }
            }

//            删除的节点又两个子支
            /*
情况三:删除有两颗子树的节点. (比如: 7,3， 10 )思路
(1)需求先去找到要删除的结点targetNode
(2)找到targetNode的父结点parent
(3)从targetNode 的右子树找到最小的结点
(4)用一个临时变量，将最小结点的值保存temp = 12
(5)删除该最小结点
(6) targetNode.value = temp
             */
            if(targetNode.left!=null && targetNode.right!=null){
                int min = rightTreeMinNode(targetNode);
                targetNode.val=min;
            }
        }
    }

}




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
    //    左旋转方法
    /*
    1.创建1个新的节点，值等于当前头节点的右节点的值
    2.把新节点的左子树设置成当前节点
    3.把新节点的右子树设置成当前节点的右子树的右节点
    4.把当前节点的右节点设置成当前节点的右节点的左节点
    问：为什么采取这种方法而不是下面一种
    答：因为下面一种方式有一个很重要的功能就是保持头节点不变。
     */
    public void leftRotation(){
//        1.创建1个新的节点，值等于当前头节点的值
        Node newNode=new Node(val);
//        2.把新节点的左子树设置成当前节点的左子树
        newNode.left=left;
//        3.把新节点的右子树设置成当前节点的右子树的左子树
        newNode.right=right.left;
//        4.把当前节点的值替换成右节点的值
        val=right.val;
//        5.把当前节点的右子树设置成当前节点右子树的右子树
        right=right.right;
//        6.把当前节点的左子树设置成新的节点
        left=newNode;
    }
    //    右旋转方法
    public void rightRotation(){
        Node newNode=new Node(val);
        newNode.right=right;
        newNode.left=left.right;
        val=left.val;
        left=left.left;
        right=newNode;
    }
    //    返回左子树的高度
    public int leftHeight(){
        return left==null?0:left.height();
    }
    //    返回右子树的高度
    public int rightHeight(){
        return right==null?0:right.height();
    }
    //    返回当前节点的高度，以当前节点为根节点的树的高度
    public int height(){
        return Math.max(left==null?0:left.height(),right==null?0:right.height())+1;

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

    //    二插排序树的插入
    public void add(Node node){
    //    相等往右添加
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
//        二次旋转
        if((this.leftHeight()-rightHeight())>1){
            if(left!=null && left.rightHeight()>left.leftHeight()){
                left.leftRotation();
            }
            this.rightRotation();
            return;
        }
        if((this.rightHeight()-leftHeight())>1){
            if(right!=null && right.leftHeight()>right.rightHeight()){
                right.rightRotation();
            }
            this.leftRotation();
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

