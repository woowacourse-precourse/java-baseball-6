package baseball.Util;

import java.util.ArrayList;
import java.util.List;

public class StringToArrayList {
    public static List<Integer> StringToArrayList(String numberCasesOfString) {
        List<Integer> numberList = new ArrayList<>();
        for (int i = 0; i < numberCasesOfString.length(); i++) {
            numberList.add(numberCasesOfString.charAt(i) - '0');
        }
        return numberList;
    }
}
