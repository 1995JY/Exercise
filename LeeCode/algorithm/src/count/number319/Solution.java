package count.number319;

class demo{
    public static void main(String[] args) {
        Solution solution = new Solution();
        long start=System.currentTimeMillis();
        solution.bulbSwitch(99999999);
        long end=System.currentTimeMillis();
        System.out.println(end-start);
    }

}
class Solution {

    // 99999999超出时间限制

    public int bulbSwitch(int n) {

        int count=0;
        boolean[] arr=new boolean[n];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=true;
        }
        for (int i = 1; i < n; i++) {
            int j=i;
            while (j<n){
                arr[j]=!arr[j];
                j+=(i+1);
            }
        }
        for (boolean b : arr) {
            if(b==true){
                count++;
            }
        }
        return count;
    }

}
