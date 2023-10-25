package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static List<Integer> userNum(String input) {
        ArrayList<Integer> uNum = new ArrayList<>();
        for (char number : input.toCharArray()) {
            uNum.add(Character.getNumericValue(number));
        }
        return uNum;
    }
}
