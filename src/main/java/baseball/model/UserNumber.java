package baseball.model;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserNumber {
    private static final int MAX_SIZE = 3;
    private List<Integer> userNumbers = new ArrayList<>();
    private static final String IS_NOT_DIGIT = "숫자 형식이 아닙니다.!";
    private static final String VALIDATE_USER_NUMBER = "숫자가 범위를 벗어났습니다.(3자리보다 크거나 작음)";
    private static final String CHECK_DUPLICATE = "중복된 숫자가 입력되었습니다.";


    public UserNumber(String userNumber) {
        validateUserNumber(userNumber);
        isNotNumber(userNumber);
        checkDuplicateNumbers(userNumber);
        convertBaseBallUserNumber(userNumber);
    }

    public List<Integer> getUserNumbers() {
        return userNumbers;
    }

    private List<Integer> convertBaseBallUserNumber(String userNumber){
        for (int i = 0; i < MAX_SIZE; i++) {
            userNumbers.add(Character.getNumericValue(userNumber.charAt(i)));
        }
        return userNumbers;
    }

    public static void isNotNumber(String userNumber){
        for (int i = 0; i < MAX_SIZE; i++) {
            isNotNumberDigit(userNumber.charAt(i));
        }
    }

    private static void isNotNumberDigit(char charAt) {
        if(!Character.isDigit(charAt)){
            throw new IllegalStateException(IS_NOT_DIGIT);
        }
    }

    private void checkDuplicateNumbers(String userNumber) {
        Set<Character> numberSet = new HashSet<>();
        for (char digit : userNumber.toCharArray()) {
            if (!numberSet.add(digit)) {
                throw new IllegalArgumentException(CHECK_DUPLICATE);
            }
        }
    }

    public static void validateUserNumber(String userNumber) {
        if(userNumber.length()!=MAX_SIZE){
            throw new IllegalStateException(VALIDATE_USER_NUMBER);
        }
    }
}
