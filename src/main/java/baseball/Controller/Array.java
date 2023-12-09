package baseball.Controller;


import java.util.ArrayList;
import static baseball.Constants.*;

public class Array {
    public static <T> boolean checkArrayContains(ArrayList<T> array, final T target) {
        for(T value : array) {
            if(value.equals(target)) {
                return true;
            }
        }
        return false;
    }

    public static ArrayList<Character> getArrayFromStr(String str){
        ArrayList<Character> charArray = new ArrayList<>();
        for(int i = 0; i < str.length(); i++){
            charArray.add(str.charAt(i));
        }
        return charArray;
    }

    public static int getIndexFromValue(ArrayList<Integer> arr, final int value){
        for(int i = 0; i < NUM_SIZE; i++){
            if(arr.get(i) == value){
                return i;
            }
        }
        return -1;
    }
}
