package baseball.util;

import java.util.Arrays;

public class NumberValidator {
    private static final int MIN_VALUE =0;
    private static final int MAX_VALUE =9;
    private static final int INPUT_LENGTH =3;

    private final static String INVALID_LENGTH_ERROR_MESSAGE = "입력 길이는 3입니다.";
    private final static String NON_NUMERIC_ERROR_MESSAGE = "숫자로만 이루어진 값을 입력해주세요.";
    private static final String OUT_RANGE_ERROR_MESSAGE = "1부터 9까지의 숫자만 입력 가능합니다.";
    private final static String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 포함되어 있습니다.";

    public static String getValidatedNumber(String inputNumber) {

        if (!isLengthValid(inputNumber)) {
            throw new IllegalArgumentException(INVALID_LENGTH_ERROR_MESSAGE);
        }
        if (!isNumeric(inputNumber)) {
            throw new IllegalArgumentException(NON_NUMERIC_ERROR_MESSAGE);
        }
        if (!isInRange(inputNumber)) {
            throw new IllegalArgumentException(OUT_RANGE_ERROR_MESSAGE);
        }
        if (!hasNoDuplicates(inputNumber)) {
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
        }
        return inputNumber;
    }


    private static boolean isLengthValid(String inputNumber){
        return inputNumber.length()==INPUT_LENGTH;
    }

    private static boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException exception) {
            return false;
        }
    }
    private static boolean isInRange(String inputNumber){
        for(String number : inputNumber.split("")){
            if(Integer.parseInt(number)<MIN_VALUE ||Integer.parseInt(number)>MAX_VALUE){
                return false;
            }
        }
        return true;
    }

    private static boolean hasNoDuplicates(String inputNumber){
        String[] numbers = inputNumber.split("");
        if(numbers.length !=Arrays.stream(numbers).distinct().count()){
            return false;
        }
        return true;
    }
}
