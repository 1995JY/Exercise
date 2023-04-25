package com.itheima.exer;

import java.util.HashMap;

/*
给定一个整数数组 nums和一个整数目标值 target，请你在该数组中找出 和为目标值 targe
的那两个整数，并返回它们的数组下标。
你可以假设每种输入只会对应一个答案。但是，数组中同一个元素在答案里不能重复出现。
你可以按任意顺序返回答案
输入：nums = [2,7,11,15], target = 9
输出：[0,1]
解释：因为 nums[0] + nums[1] == 9 ，返回 [0, 1] 。
输入：nums = [3,2,4], target = 6
输出：[1,2]
输入：nums = [3,3], target = 6
输出：[0,1]

 */
public class addTweNumber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int targe = 9;
        System.out.println(findNumber(nums, targe));

//sb wjy
    }
    public static String findNumber(int[] nums, int target){
        int[] index=new int[2];
        HashMap<Integer,Integer> map=new HashMap<>();
        map.put(nums[0],1);
        for (int i = 1; i < nums.length; i++) {
            int temp=target-nums[i];
            if(!(map.containsKey(temp))){
                map.put(nums[i],map.size()+1);
            }else{
                map.put(nums[i],map.size()+1);
                index[0]=map.get(nums[i]);
                index[1]=map.get(temp);

            }
        }

        return index[0]+"----"+index[1];
    }
}
