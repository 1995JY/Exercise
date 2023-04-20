package arrayStack;

public class ArrayStackDemo {
    public static void main(String[] args) {

    }
}
class ArrayStack{
    private int maxSize;
    private int[] stack;
//    表示栈顶，初始值为-1；
    private int top=-1;

    public ArrayStack(int maxSize) {
        this.maxSize = maxSize;
        stack=new int[this.maxSize];
    }
    public boolean isFull(){
        return top==this.maxSize-1;
    }
    public boolean isEmpty(){
        return top==-1;
    }
    public void push(int num){
        if(isFull()){
            System.out.println("栈满");
            return;
        }
        top++;
        this.stack[top]=num;
    }
    public int pop(){
        if(isEmpty()){
            new RuntimeException("栈空，没有数据");
        }
        int num=stack[top];
        top--;
        return num;
    }
    public void list(){
        if(isEmpty()){
            System.out.println("栈空，没有元素");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }
}
