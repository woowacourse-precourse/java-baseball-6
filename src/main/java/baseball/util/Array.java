package baseball.util;

public class Array {
    public static boolean checkArraysContain(int[] arr, int a){
        for(int num : arr){
            if(num == a){
                return true;
            }
        }
        return false;
    }

}
