package baseball;

import java.util.ArrayList;
import java.util.List;

public class ChangeArray {

    // 받은 String형태의 input을 list로 바꾸기
    public static List<Integer> stringToList(String inputString){

        String[] splitInput = inputString.split("");
        List<Integer> numberList = new ArrayList<>();

        for (String s : splitInput){
            numberList.add(Integer.parseInt(s));
        }

        return numberList;
    }
}
