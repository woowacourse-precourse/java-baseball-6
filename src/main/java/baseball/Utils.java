package baseball;

import java.util.ArrayList;
import java.util.List;

public class Utils {
    public List<Integer> toList(String userInput){
        List<Integer> numberList = new ArrayList<>();

        for (char ch : userInput.toCharArray()) {
            numberList.add(Character.getNumericValue(ch));
        }
        return numberList;
    }
}
