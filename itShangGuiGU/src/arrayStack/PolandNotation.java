package arrayStack;
import java.util.ArrayList;
import java.util.List;

public class PolandNotation {
    public static void main(String[] args) {
/*思路分析：
* 1.接受中缀表达式。
* 2.将中缀表达式转拆分为各数字、括号和运算符的集合：选定存储的集合ArrayList，定义方法，返回存储的集合，集合里面既有数字，也有运算符，
* 还有括号，存储类型应该为string。
* 3.利用循环，按照思路依次压入栈中：
* 压栈的时候应该使用正则表达式，判断是不是数字，其余的用
* 4.将栈中的数据依次取出，其逆序就是中缀表达式：
* 栈应该也是String类型的。
* 5.按照后缀表达式的计算规则，计算结果：定义方法，返回结果
* */
        String str="1+（（2+3）*4）-5";
        List<String> stringList = transferString(str);
        System.out.println(stringList);




    }
// 将中缀表达式，存储进list集合
    private static List<String> transferString(String str) {
        List<String> list=new ArrayList<>();
        for (int i = 0; i < str.length(); i++) {
            String str1="";
           if( str.charAt(i)>=48 && str.charAt(i)<=57){
               while(i< str.length() && (str.charAt(i)+"").matches("\\d")){
                   str1+= str.charAt(i);
                   i++;
               }
               list.add(str1);
               i--;
           }else{
               str1+= str.charAt(i);
               list.add(str1);
           }
        }
        return list;
    }

    //    初级计算器代码实现，有重大漏洞。
//    计算代码
//    String str="1-2-3-4";
//    int reslut = calculator(str);
    private static int calculator(String str) {
        ArrayStack2 numStack=new ArrayStack2(10);
        ArrayStack2 operStack=new ArrayStack2(10);
        int index=0;
        int num1=0;
        int num2=0;
        int oper=0;
        int result=0;
        char ch=' ';

//        char a='a';
//        char b='b';
//        String str1=a+b;
//        String str2=" "+str.charAt(0)+str.charAt(3);
        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
//             判断是数字还是运算符，运算符压入运算符栈
            if(numStack.isOper(ch)){
//                 判断是否栈空，栈空直接压入
                if(operStack.isEmpty()){
                    operStack.push(ch);
                } else{// 否则判断运算符优先级，优先级高直接压入，优先级低，先运算，再压入
                    if(operStack.priority(ch)>=operStack.priority(operStack.checkTop())){
                        operStack.push(ch);
                    }else{
                        num1=numStack.pop();
                        num2=numStack.pop();
                        oper=operStack.pop();
                        result=numStack.cal(num1,num2,oper);
                        numStack.push(result);
                        operStack.push(ch);
                    }
                }

            }else{ // 否则压入数字栈
                numStack.push(ch-48);
            }
        }
        while(true){
            num1=numStack.pop();
            num2=numStack.pop();
            oper=operStack.pop();
            result=numStack.cal(num1,num2,oper);
            numStack.push(result);
            if(operStack.isEmpty()){
                break;
            }
        }
        return result;
    }
}
class ArrayStack3{
    private int maxSize;
    private int[] stack;
    //    表示栈顶，初始值为-1；
    private int top=-1;

    public ArrayStack3(int maxSize) {
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
    public int checkTop(){
        return stack[top];
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
    public int cal(int num1,int num2,int val){
        int res=0;
        switch (val){
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2  / num1;
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
