package com.itheima.exer;

public class 在排序数组中查找元素的第一个和最后一个位置 {
    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 5, 6, 6, 8, 8, 8, 9};
        int target = 8;
        System.out.println(binarySearch(arr, 8));

    }

    static String binarySearch(int[] arr, int target) {
        int min = 0;
        int max = arr.length;
        int index = -1;

        if (target > arr[max - 1] || target < arr[0]) {
            return "[-1,-1]";
        }
        int mid = 0;
        while (min <= max) {
            mid = (max + min) / 2;
            if (target > arr[mid]) {
                min = mid + 1;
            } else if (target < arr[mid]) {
                max = mid - 1;
            } else {
                index = mid;
                break;
            }
        }
        int maxIndex = index;
        int minIndex = index;
        while (arr[minIndex] == arr[minIndex - 1]) {
            minIndex--;
        }
        while (arr[maxIndex] == arr[maxIndex + 1]) {
            maxIndex++;
        }
        return "[" + minIndex + "," + maxIndex + "]";
    }

}
