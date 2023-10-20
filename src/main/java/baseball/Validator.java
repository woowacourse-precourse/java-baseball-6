package baseball;

import java.util.HashSet;
import java.util.regex.Pattern;

public class Validator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int CNT_NUMBER = 3;

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";
    private static final String REGEXP_PATTERN_MIN_TO_MAX = "[" + MIN_NUMBER + "-" + MAX_NUMBER + "]+";


    public Validator() {}


    public boolean isValidNumber(String inputNumber) {
        return isNumber(inputNumber) && isNotDuplicate(inputNumber) && isMinToMax(inputNumber);
    }

    private boolean isNumber(String inputNumber) {
        return Pattern.matches(REGEXP_PATTERN_NUMBER, inputNumber);
    }

    private boolean isNotDuplicate(String inputNumber) {
        HashSet<Character> set = new HashSet<>();
        for(Character c : inputNumber.toCharArray())
            set.add(c);
        return set.size() == CNT_NUMBER;
    }

    private boolean isMinToMax(String inputNumber) {
        return Pattern.matches(REGEXP_PATTERN_MIN_TO_MAX, inputNumber);
    }

    public boolean isOneOrTwo(String inputNumber) { return inputNumber.equals("1") || inputNumber.equals("2"); }
}
