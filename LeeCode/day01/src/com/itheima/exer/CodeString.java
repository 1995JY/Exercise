package com.itheima.exer;

import java.util.Scanner;

/*
对输入的字符串进行加解密，并输出。

加密方法为：

当内容是英文字母时则用该英文字母的后一个字母替换，同时字母变换大小写,如字母a时则替换为B；字母Z时则替换为a；

当内容是数字时则把该数字加1，如0替换1，1替换2，9替换0；

其他字符不做变化。

解密方法为加密的逆过程。
数据范围：输入的两个字符串长度满足 1 \le n \le 1000 \1≤n≤1000  ，保证输入的字符串都是只由大小写字母或者数字组成
ABCDEFGHIJKLMNOPQRSTUVWXYZ
 */
public class codeString {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        System.out.println("请输入一串字符（要求全是字母或者数字组成，不分大小写）：");
        String s = sc.nextLine();

        System.out.println(encryption(s));
        System.out.println(decryption(s));

        }
        static String encryption(String str){
            String newStr="";
            char[] arr=str.toCharArray();
            // 之前做错的地方是，for循环是if语句，会全部执行，而应该使用if else条件判断语句
            for (int i = 0; i < arr.length; i++) {
                if((arr[i]>='A')&&(arr[i]<='Y') ){
                    arr[i]=(char)(arr[i]+'a'-'A'+1);
                } else if(arr[i]=='Z'){
                    arr[i]='a';
                }else if((arr[i]>='a')&&(arr[i]<='y')){
                    arr[i]=(char)(arr[i]+('A'-'a')+1);
                }else if(arr[i]=='z'){
                    arr[i]='A';
                } else if((arr[i]>='0')&&(arr[i]<='8')){
                    arr[i]=(char)(arr[i]+1);
                }else if(arr[i]=='9'){
                    arr[i]='0';
                }
            }
            for (int i = 0; i < arr.length; i++) {
                newStr+=arr[i];
            }
            return newStr;
        }
        static String decryption(String str){
            String newStr="";
            char[] arr=str.toCharArray();
            for (int i = 0; i < arr.length; i++) {
                if((arr[i]>'A')&&(arr[i]<='Z') ){
                    arr[i]=(char)(arr[i]+'a'-'A'-1);
                } else if(arr[i]=='A'){
                    arr[i]='y';
                }else if((arr[i]>'a')&&(arr[i]<='y')){
                    arr[i]=(char)(arr[i]+('A'-'a')-1);
                }else if(arr[i]=='a'){
                    arr[i]='Z';
                } else if((arr[i]>'0')&&(arr[i]<='9')){
                    arr[i]=(char)(arr[i]-1);
                }else if(arr[i]=='0'){
                    arr[i]='9';
                }
            }
            for (int i = 0; i < arr.length; i++) {
                newStr+=arr[i];
            }
            return newStr;
        }
}
