package refactor.exception;


import java.util.HashSet;
import java.util.regex.Pattern;

public class Validator {

    private static final int MIN_NUMBER = 1;
    private static final int MAX_NUMBER = 9;
    private static final int CNT_NUMBER = 3;

    private static final String REGEXP_PATTERN_NUMBER = "^[\\d]*$";
    private static final String REGEXP_PATTERN_MIN_TO_MAX = "[" + MIN_NUMBER + "-" + MAX_NUMBER + "]+";


    public Validator() {}


    public static void isValidNumber(String inputNumber) {
        isNumber(inputNumber);
        isNotDuplicate(inputNumber);
        isMinToMax(inputNumber);
    }

    public static void isOneOrTwo(String inputNumber) {
        if(!inputNumber.equals("1") && !inputNumber.equals("2"))
            throw new AppException(ErrorCode.ONE_TO_TWO);
    }


    private static void isNumber(String inputNumber) {
        if(!Pattern.matches(REGEXP_PATTERN_NUMBER, inputNumber))
            throw new AppException(ErrorCode.NOT_NUMBER);
    }

    private static void isNotDuplicate(String inputNumber) {
        HashSet<Character> set = new HashSet<>();
        for(Character c : inputNumber.toCharArray())
            set.add(c);

        if(set.size() != CNT_NUMBER) throw new AppException(ErrorCode.NOT_SIZE);
    }

    private static void isMinToMax(String inputNumber) {
        if(!Pattern.matches(REGEXP_PATTERN_MIN_TO_MAX, inputNumber))
            throw new AppException(ErrorCode.ONE_TO_NINE);
    }

}
