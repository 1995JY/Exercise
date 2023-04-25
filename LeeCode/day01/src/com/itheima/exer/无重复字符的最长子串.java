package com.itheima.exer;

import java.util.LinkedHashSet;

/*
给定一个字符串 s ，请你找出其中不含有重复字符的 最长子串 的长度。
输入: s = "abcabcbb"
输出: 3
解释: 因为无重复字符的最长子串是 "abc"，所以其长度为 3。
输入: s = "bbbbb"
输出: 1
解释: 因为无重复字符的最长子串是 "b"，所以其长度为 1。
输入: s = "pwwkew"
输出: 3
解释: 因为无重复字符的最长子串是 "wke"，所以其长度为 3。
请注意，你的答案必须是 子串 的长度，是一个子序列，不是子串。

来
 */
public class 无重复字符的最长子串 {
    public static void main(String[] args) {
        String s="abcabcbb" ;
//        System.out.println(lengthOfLongestSubstring(s));
        int[] last = new int[128];
        for(int i = 0; i < 128; i++) {
            last[i] = -1;
        }
        int n = s.length();

        int res = 0;
        int start = 0; // 窗口开始位置
        for(int i = 0; i < n; i++) {
            int index = s.charAt(i);
            start = Math.max(start, last[index] + 1);
            res   = Math.max(res, i - start + 1);
            last[index] = i;
        }


    }
    // 返回长度
    static int lengthOfLongestSubstring(String s){
        int max=0;
        char[] chs=s.toCharArray();

        for (int i = 0; i < chs.length-max; i++) {
            int count=0;
            LinkedHashSet<Character> lhs=new LinkedHashSet<>();
            for (int j = i; j < chs.length; j++) {

                if(lhs.add(chs[j])){
                    count++;
                }else{
                    break;
                }
            }
            if(count>max){
                max=count;
            }

        }
        return max;
    }
    // 标准答案

    public int lengthOfLongestSubstring2(String s) {
            // 记录字符上一次出现的位置
            int[] last = new int[128];
            for(int i = 0; i < 128; i++) {
                last[i] = -1;
            }
            int n = s.length();

            int res = 0;
            int start = 0; // 窗口开始位置
            for(int i = 0; i < n; i++) {
                int index = s.charAt(i);
                start = Math.max(start, last[index] + 1);
                res   = Math.max(res, i - start + 1);
                last[index] = i;
            }

            return res;
    }
}
