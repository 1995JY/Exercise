package test;

import java.util.TreeSet;

public class Test {
    public static void main(String[] args) {
        Student A=new Student("张三",23);
        Student B=new Student("李四",24);
        Student C=new Student("王五",25);
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);
        B=C;
        A=B;
        System.out.println("-----------");
        System.out.println(A);
        System.out.println(B);
        System.out.println(C);

    }
}
