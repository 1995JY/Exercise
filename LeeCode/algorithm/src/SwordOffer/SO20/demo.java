package SwordOffer.SO20;

/*
请实现一个函数用来判断字符串是否表示数值（包括整数和小数）。

数值（按顺序）可以分成以下几个部分：

若干空格
一个 小数 或者 整数
（可选）一个 'e' 或 'E' ，后面跟着一个 整数
若干空格
小数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
下述格式之一：
至少一位数字，后面跟着一个点 '.'
至少一位数字，后面跟着一个点 '.' ，后面再跟着至少一位数字
一个点 '.' ，后面跟着至少一位数字
整数（按顺序）可以分成以下几个部分：

（可选）一个符号字符（'+' 或 '-'）
至少一位数字
部分数值列举如下：

["+100", "5e2", "-123", "3.1416", "-1E-16", "0123"]
部分非数值列举如下：

["12e", "1a3.14", "1.2.3", "+-5", "12e+5.4"]
 

来源：力扣（LeetCode）
链接：https://leetcode.cn/problems/biao-shi-shu-zhi-de-zi-fu-chuan-lcof
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
//一眼正则，但是实操感觉正则不行
public class demo {
    public static void main(String[] args) {
    String s="1";
        Solution solution = new Solution();
        System.out.println(solution.isNumber(s));

    }
}
class Solution {
    public boolean isNumber(String s) {

        String case1="[0-9]+";
        String case2="[0-9]+[\\.][0-9]*=+";
        String case3="[\\+,\\-][0-9]+[e,E][0-9]+";
        if(s.matches(case1)) return true;
        else if(s.matches(case2)) return true;
        else if(s.matches(case3)) return true;

        else return false;

    }
}