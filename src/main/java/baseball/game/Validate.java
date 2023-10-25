package baseball.game;

import java.util.List;
import java.util.regex.Pattern;

public class Validate {

    public static void isNumberValidate(int number){
        if ( number > 9 || number < 1) {
            throw new IllegalArgumentException(ErrorMsg.VALUE_MUST_BE_INTEGER_1_TO_9);
        }
    }

    public static void isOneOrTwo(String str) {
        if (!Pattern.matches("[1|2]", str)) {
            throw new IllegalArgumentException(ErrorMsg.VALUE_MUST_BE_1_OR_2);
        }
    }

    public static void isLessThenFourLetter(String[] input){
        if(input.length >= 4){
            throw new IllegalArgumentException(ErrorMsg.INPUT_MUST_BE_NO_MORE_THEN_3);
        }
    }

    public static void isNumberDuplicate(List<Integer> list, int num) {
        if (list.contains(num)) {
            throw new IllegalArgumentException(ErrorMsg.INPUT_VALUE_MUST_BE_DIFFERENT_VALUES);
        }
    }
}
