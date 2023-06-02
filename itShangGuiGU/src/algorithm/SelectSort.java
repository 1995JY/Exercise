package algorithm;

public class SelectSort {
    public static void main(String[] args) {
//        int[] arr={12,35,2,69,14,52,14,35,71,19};
        int[] arr=new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        Long start=System.currentTimeMillis();
        selectSort(arr);
        Long end=System.currentTimeMillis();
//        3175ms
        System.out.println(end-start);
//        for (int i : arr) {
//            System.out.print(i+" ");
//        }

    }
    public static void selectSort(int[] arr){

        for (int i = 0; i < arr.length; i++) {
            int index=i;
            int min=arr[i];
            for (int j = i+1; j < arr.length; j++) {
                if(min>arr[j]){
                    index=j;
                    min=arr[j];
                }
            }
            int temp=arr[i];
            arr[i]=min;
            arr[index]=temp;
        }
    }
}
