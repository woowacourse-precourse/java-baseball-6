package baseball.exception;

import java.util.*;

public class InputException {
    public static final int RANDOM_MIX_NUMBER = 1;
    public static final int RANDOM_MAX_NUMBER = 9;
    private static final String LENGTH_ERROR_MESSAGE = "3글자가 아닙니다.";
    private static final String DUPLICATE_ERROR_MESSAGE = "중복된 숫자가 있습니다.";
    private static final String OUT_OF_RANGE_ERROR_MESSAGE = "1~9 범위를 벗어난 숫자가 있습니다.";
    private static final String NOT_NUMERIC_ERROR_MESSAGE = "1~9 범위의 숫자만 입력해주세요";
    public static void lenException(String input){
        if(input.length() != 3)
            throw new IllegalArgumentException(LENGTH_ERROR_MESSAGE);
    }

    public static void duplicateException(List<String> input){
        Set<String> inputSet = new HashSet<>(input);
        if(inputSet.size() != input.size())
            throw new IllegalArgumentException(DUPLICATE_ERROR_MESSAGE);
    }

    public static void outOfRangeException(List<String> input){
        for(String num : input){
            int number = Integer.parseInt(num);
            if(number < RANDOM_MIX_NUMBER || number > RANDOM_MAX_NUMBER)
                throw new IllegalArgumentException(OUT_OF_RANGE_ERROR_MESSAGE);
        }
    }

    public static void notNumericException(String input){
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e){
            throw new IllegalArgumentException(NOT_NUMERIC_ERROR_MESSAGE);
        }
    }
}
