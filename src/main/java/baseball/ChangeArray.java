package baseball;

import java.util.ArrayList;
import java.util.List;

public class ChangeArray {
    public static List<Integer> stringToList(String inputString){

        String[] splitInput = inputString.split("");
        List<Integer> numberList = new ArrayList<>();

        for (String s : splitInput){
            numberList.add(Integer.parseInt(s));
        }

        return numberList;
    }
}
