package com.itheima.exer;

import java.util.ArrayList;
//未完成
/*
实现删除字符串中出现次数最少的字符，若出现次数最少的字符有多个，则把出现次数最少的字符都删除。输出删除这些单词后的字符串，字符串中其它字符保持原来的顺序。
数据范围：输入的字符串长度满足 1 \le n \le 20 \1≤n≤20  ，保证输入的字符串中仅出现小写字母
输入描述：
字符串只包含小写英文字母, 不考虑非法输入，输入的字符串长度小于等于20个字节。
输出描述：
删除字符串中出现次数最少的字符后的字符串。

示例1
 */
public class deleteChar {
    public static void main(String[] args) {
        String s="aabcddd";
        char[] arr1=s.toCharArray();
        int[] arr2=new int[arr1.length];
        //统计各元素出现的次数，并将次数依次封装到arr2里
        for (int i = 0; i < arr1.length; i++) {
            int num = 0;
            for (int j = 0; j < arr1.length; j++) {
                if (arr1[i] == arr1[j]) {
                    num++;
                }
            }
            arr2[i] = num;
        }
        //遍历arr2的最小值，最小值的索引便是出现次数最小的字符的索引,将索引依次封装进list2的集合里。
        int min=0;
        for (int i = 0; i < arr2.length; i++) {
            if(min>arr2[i]){
                min=arr2[i];
            }
        }
        ArrayList<Integer> list1=new ArrayList<>();
        for (int i = 0; i < arr2.length; i++) {
            if(arr2[i]==min){
                list1.add(i);
            }
        }
        for (int i = 0; i < list1.size(); i++) {
            s=s.replace(arr1[list1.get(i)],'l');
        }
        System.out.println(s);
    }
}
