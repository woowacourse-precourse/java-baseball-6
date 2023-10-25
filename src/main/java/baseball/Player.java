package baseball;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static List<Integer> numbers;
    public static boolean endFlag = false;

    public static int ballCount = 0;
    public static int strikeCount = 0;


    public static void setNumbers(String str) {
        if (Validator.validPlayerNumbers(str))
            numbers = stringToNumbersList(str);
    }

    public static void setEndFlag(String str) {
        if (Validator.validPlayerContinue(str) && str.equals("2"))
            endFlag = true;
    }

    public static void initBallAndStrikeCount() {
        ballCount = 0;
        strikeCount = 0;
    }

    public static List<Integer> stringToNumbersList(String str) {
        List<Integer> numbersList = new ArrayList<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            int number = Character.getNumericValue(c);
            numbersList.add(number);
        }
        return numbersList;
    }
}
