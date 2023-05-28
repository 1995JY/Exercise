package test;

public class Test {
    public static void main(String[] args) {
        Student A=new Student("张三",23);
        Student B=new Student();
        Student C=new Student("李四",24);
        B=A;
        B.setName("zhangsan");
        System.out.println(A.getName());//
        B=C;
        System.out.println(A.getName());//



//        String str1="abc";
//        char a=str1.charAt(0);
//        char b=str1.charAt(1);
//        char c=str1.charAt(2);
//        String str2=a+b+c;
//        System.out.println(str1.equals(str2));
    }
}
