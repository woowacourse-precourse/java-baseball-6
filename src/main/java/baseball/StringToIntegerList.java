package baseball;

import java.util.ArrayList;
import java.util.List;

public class StringToIntegerList {
    public static List<Integer> turnToIntList(String str){
        List<Integer> intList = new ArrayList<>();

        for(int i=0;i<str.length();i++){
            intList.add(Character.getNumericValue(str.charAt(i)));
        }
        return intList;
    }
}
