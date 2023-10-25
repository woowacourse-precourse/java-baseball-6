package baseball.error;

import java.util.*;

public class GameInputErrorException implements ErrorException{
    private final static int VALID_NUMBER_LENGTH = 3;
    private final static int VALID_NUMBER_MIN_RANGE = 1;
    private final static int VALID_NUMBER_MAX_RANGE = 9;
    private final static String IS_NOT_NUMERIC_MESSAGE = "숫자만 입력이 가능합니다. 애플리케이션을 종료합니다.";
    private final static String IS_NOT_THREE_DIGITS_MESSAGE = "3자리 숫자만 입력 가능합니다. 애플리케이션을 종료합니다.";
    private final static String IS_NOT_VALID_RANGE_MESSAGE = "각 자릿 숫자는 1~9의 숫자만 입력 가능합니다. 애플리케이션을 종료합니다.";
    private final static String EXIST_DUPLICATE_NUMBER = "각 자리에 서로 다른 숫자를 입력해야 합니다. 애플리케이션을 종료합니다.";
    @Override
    public void checkUserInputValidate(String checkNumber) {
        if(!isNumeric(checkNumber)){
            throw new IllegalArgumentException(IS_NOT_NUMERIC_MESSAGE);
        }
        if(!checkThreeDigits(checkNumber)){
            throw new IllegalArgumentException(IS_NOT_THREE_DIGITS_MESSAGE);
        }
        if(!checkNumberRangeValidate(checkNumber)){
            throw new IllegalArgumentException(IS_NOT_VALID_RANGE_MESSAGE);
        }
        if(!hasDuplicateNumber(checkNumber)){
            throw new IllegalArgumentException(EXIST_DUPLICATE_NUMBER);
        }
    }

    private static boolean isNumeric(String checkNumber) {
        return checkNumber.matches(CHECK_NUMBER_STRING);
    }

    private static boolean checkThreeDigits(String checkNumber) {
        return checkNumber.length() == VALID_NUMBER_LENGTH;
    }
    private static boolean checkNumberRangeValidate(String checkNumber){

        for(char c : checkNumber.toCharArray()){
            int cToInt = Character.getNumericValue(c);
            if (VALID_NUMBER_MIN_RANGE > cToInt || VALID_NUMBER_MAX_RANGE < cToInt){
                return false;
            }
        }
        return true;
    }

    private static boolean hasDuplicateNumber(String checkNumber) {
        Set<Character> checkNumberToSet = new HashSet<>(changeStringToCharList(checkNumber));
        return checkNumber.length() == checkNumberToSet.size();
    }

    private static List<Character> changeStringToCharList(String checkString) {
        List<Character> result = new ArrayList<>();
        for (char c : checkString.toCharArray()) {
            result.add(c);
        }
        return result;
    }
}
