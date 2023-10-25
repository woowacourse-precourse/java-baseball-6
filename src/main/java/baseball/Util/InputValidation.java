package baseball.Util;

import java.util.HashSet;
import java.util.Set;

public class InputValidation {

    private static final String WRONG_RANGE_MESSAGE = "1~9 사이의 정수가 아닙니다.";
    private static final String WRONG_LENGTH_MESSAGE = "3자리 수가 아닙니다.";
    private static final String DUPLICATE_NUMBER_MESSAGE = "중복되는 숫자를 입력하였습니다.";

    public void validationNumber(String number) {
        if(!isIntegerValue(number)){
            throw new IllegalArgumentException(WRONG_RANGE_MESSAGE);
        }
        if(!isCorrectLength(number)){
            throw new IllegalArgumentException(WRONG_LENGTH_MESSAGE);
        }
        if(!isDuplicateNum(number)){
            throw new IllegalArgumentException(DUPLICATE_NUMBER_MESSAGE);
        }

    }

    private boolean isDuplicateNum(String number) {
        char[] charArray = number.toCharArray();
        Set<Character> numberSet = new HashSet<>();
        for(char n : charArray){
            numberSet.add(n);
        }
        return numberSet.size() == charArray.length;
    }

    private boolean isCorrectLength(String number) {
        return number.toCharArray().length == 3;
    }

    private boolean isIntegerValue(String number) {
        char[] charArray = number.toCharArray();
        for(char n : charArray){
            if(n  < '1' || n  > '9') {
                return false;
            }
        }
        return true;
    }
}
