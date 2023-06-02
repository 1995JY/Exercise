package algorithm;

public class InsertSort {
    public static void main(String[] args) {

//        int[] arr={12,5,45,25,16,36,24,12,5,9,3,1};
        int[] arr=new int[80000];
        for (int i = 0; i < arr.length; i++) {
            arr[i]=(int)(Math.random()*8000000);
        }
        Long start=System.currentTimeMillis();
//        shellSort2(arr);// 33ms
        insertSort(arr);// 1251ms 为什么插入排序比选择排序快？
        Long end=System.currentTimeMillis();

        System.out.println(end-start);
//        for (int i : arr) {
//            System.out.print(i+" ");
//        }

    }

    public static void insertSort(int[] arr){

        for (int i = 0; i < arr.length-1; i++) {
            int value=arr[i+1];
            int index=i;
            if(value<arr[index]){
                while(index>=0 && arr[index]>value){
                    arr[index+1]=arr[index];
                    index--;
                }
                arr[index+1]=value;
            }
//            if(value>arr[index]){
//                continue;
//            }else{
//                while(index>=0 && arr[index]>value){
//                    arr[index+1]=arr[index];
//                    index--;
//                }
//                arr[index]=value;
//            }
        }
    }

    public static void shellSort1(int[] arr){


    }

    public static void shellSort2(int[] arr){
        int a=arr.length;
        while (a!=1){
             a=a/2;
             for(int i=0;i<a;i++){
                 for(int j=i;j<arr.length;j=j+a){

                     int temp=arr[j];
                     int index=j;
                     while(index+a<arr.length && arr[index]>arr[index+a]){
                         arr[index]=arr[index+a];
                         index=index+a;
                     }
                     arr[index]=temp;
                 }
             }
        }
        for(int j=0;j<arr.length;j++){

            int temp=arr[j];
            int index=j;
            while(index+a<arr.length && arr[index]>arr[index+1]){
                arr[index]=arr[index+1];
                index=index+1;
            }
            arr[index]=temp;
        }
    }
}
