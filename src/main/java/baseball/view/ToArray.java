package baseball.view;

import java.util.ArrayList;

public class ToArray {
    public static ArrayList<Integer> toArray(int num){
        ArrayList<Integer> itArray = new ArrayList<Integer>();
        do{
            itArray.add(0,num % 10);
            num /= 10;
        } while  (num > 0);
        return itArray;
    }
}
