package arrayStack;

public class Calculator {
    public static void main(String[] args) {
        String str = "1-2-3-4";

        ArrayStack2 numStack = new ArrayStack2(10);
        ArrayStack2 operStack = new ArrayStack2(10);
        int index = 0;
        int num1 = 0;
        int num2 = 0;
        int oper = 0;
        int result = 0;
        char ch = ' ';

//        char a='a';
//        char b='b';
//        String str1=a+b;
//        String str2=" "+str.charAt(0)+str.charAt(3);

        for (int i = 0; i < str.length(); i++) {
            ch = str.charAt(i);
//             判断是数字还是运算符，运算符压入运算符栈
            if (numStack.isOper(ch)) {
//                 判断是否栈空，栈空直接压入
                if (operStack.isEmpty()) {
                    operStack.push(ch);
                } else {// 否则判断运算符优先级，优先级高直接压入，优先级低，先运算，再压入
                    if (operStack.priority(ch) >= operStack.priority(operStack.checkTop())) {
                        operStack.push(ch);
                    } else {
                        num1 = numStack.pop();
                        num2 = numStack.pop();
                        oper = operStack.pop();
                        result = numStack.cal(num1, num2, oper);
                        numStack.push(result);
                        operStack.push(ch);
                    }
                }

            } else { // 否则压入数字栈
                numStack.push(ch - 48);
            }
        }
        while (true) {
            num1 = numStack.pop();
            num2 = numStack.pop();
            oper = operStack.pop();
            result = numStack.cal(num1, num2, oper);
            numStack.push(result);
            if (operStack.isEmpty()) {
                break;
            }
        }
        System.out.println("result=" + result);

    }
}

class ArrayStack2 {
    private int maxSize;
    private int[] stack;
    //    表示栈顶，初始值为-1；
    private int top = -1;

    public ArrayStack2(int maxSize) {
        this.maxSize = maxSize;
        stack = new int[this.maxSize];
    }

    public boolean isFull() {
        return top == this.maxSize - 1;
    }

    public boolean isEmpty() {
        return top == -1;
    }

    public void push(int num) {
        if (isFull()) {
            System.out.println("栈满");
            return;
        }
        top++;
        this.stack[top] = num;
    }

    public int checkTop() {
        return stack[top];
    }

    public int pop() {
        if (isEmpty()) {
            new RuntimeException("栈空，没有数据");
        }
        int num = stack[top];
        top--;
        return num;
    }

    public void list() {
        if (isEmpty()) {
            System.out.println("栈空，没有元素");
            return;
        }
        for (int i = top; i >= 0; i--) {
            System.out.println(stack[i]);
        }
    }

    //   判断优先级，返回值越大，优先级越高
    public int priority(int oper) {
        if (oper == '*' || oper == '/') {
            return 1;
        } else if (oper == '+' || oper == '-') {
            return 0;
        } else {
            return -1;
        }
    }

    //  判断是不是一个运算符
    public boolean isOper(char oper) {
        return oper == '*' || oper == '/' || oper == '+' || oper == '-';
    }

    //   计算方法
    public int cal(int num1, int num2, int val) {
        int res = 0;
        switch (val) {
            case '*':
                res = num1 * num2;
                break;
            case '/':
                res = num2 / num1;
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