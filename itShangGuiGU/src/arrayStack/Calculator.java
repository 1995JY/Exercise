package arrayStack;

public class Calculator {
    public static void main(String[] args) {

    }
}
class ArrayStack2{
    private int maxSize;
    private double[] stack;
    //    表示栈顶，初始值为-1；
    private int top=-1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack=new double[this.maxSize];
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
    public double pop(){
        if(isEmpty()){
            new RuntimeException("栈空，没有数据");
        }
        double num=stack[top];
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
//   判断优先级，返回值越大，优先级越高
    public int priority(int oper){
        if(oper=='*' || oper=='/'){
            return 1;
        }else if(oper=='+' || oper=='-' ){
            return 0;
        }else{
            return -1;
        }
    }

//  判断是不是一个运算符
    public boolean isOper(char oper){
        return oper=='*' || oper=='/' || oper=='+' || oper=='-';
    }

//   计算方法
    public double cal(int num1,int num2,char val){
        double res=0;
        switch (val){
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 * 1.0 / num1;
                break;
            case '+':
                res = num1 + num2;
                break;
            case '-':
                res = num2 - num1;
                break;
            default:
                break;

        }
        return res;
    }


}