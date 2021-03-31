package hw_lesson5;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {


        System.out.println(recDegreeNumber(5,2));

        int[] arr = new int[]{11, 8, 7, 6, 5};
        recTaskBackpack(arr,25);

    }

    public static int recDegreeNumber (int num, int deg){

        if (deg == 1) {
            return num;
        } else {
            return num * recDegreeNumber(num,deg-1);
        }
    }

    public static boolean recTaskBackpack( int[] arr,int capacity){
        return recBackpack(arr,0,capacity);
    }


    private static boolean recBackpack( int[] arr,int start, int capacity){
        if (start == arr.length){
            return false;
        }
        int cur = arr[start];
        if (cur == capacity){
            System.out.print(cur + " ");
            return true;
        }else if (cur > capacity || !recBackpack(arr,start+1,capacity-cur)){
            return recBackpack(arr,start+1,capacity);
        }
        System.out.print(cur + " ");
        return true;
    }

}
