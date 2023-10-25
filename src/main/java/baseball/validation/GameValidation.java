package baseball.validation;

import java.util.HashSet;
import java.util.stream.Collectors;

public class GameValidation {

    public static final String VALUE_IS_EMPTY= "[Err] 입력 값이 빈 문자열입니다.";
    public static final String VALUE_LENGTH_IS_OVER_OR_UNDER = "[Err] 입력 값의 길이가 초과 또는 부족입니다.";
    public static final String VALUE_CONTAINS_SPACE = "[Err] 입력 값에 공백이 포함되어 있습니다.";
    public static final String VALUE_IS_NOT_NUMERIC = "[Err] 입력 값이 숫자가 아닙니다.";
    public static final String VALUE_IS_DUPLICATE = "[Err] 입력 값이 중복되었습니다. 중복되지 않은값을 입력하여 주세요.";
    public static final String VALUE_RANGE_UNCORRECT = "[Err] 입력 값은 1부터 9사이의 숫자여야합니다.";
    public static final String RETRY_VALUE_RANGE_UNCORRECT = "[Err] 게임을 새로시작 혹은 종료하기 위해선 1 또는 2 값을 입력하여야합니다.";

    public static boolean verifyForGameValue(String input_value,int target_length) {
        return verifyForValueIsEmpty(input_value) &&
                        verifyForValueLength(input_value,target_length) &&
                                verifyForValueIsSpace(input_value) &&
                                        verifyForValueIsNumeric(input_value) &&
                                                verifyForNumberRangeIsCorrect(input_value) &&
                                                        verifyForValueIsDuplicate(input_value);
    }

    public static boolean verifyForRetryValue(String input_retry,int target_length){
        return verifyForValueIsEmpty(input_retry) &&
                        verifyForValueLength(input_retry,target_length) &&
                                verifyForValueIsNumeric(input_retry) &&
                                        verifyForRetryConditionIsCorrect(input_retry);
    }

    private static boolean verifyForValueIsEmpty(String value) {
        if (value.equals("")) {
            throw new IllegalArgumentException(VALUE_IS_EMPTY);
        }
        return true;
    }

    private static boolean verifyForValueLength(String value,int target_length) {
        if (value.length() != target_length) {
            throw new IllegalArgumentException(VALUE_LENGTH_IS_OVER_OR_UNDER);
        }
        return true;
    } // use case: 1234,12 같은 값을 검증하기 위해

    private static boolean verifyForValueIsSpace(String value) {
        String values = value.replaceAll(" ", "");
        if (!value.equals(values)) {
            throw new IllegalArgumentException(VALUE_CONTAINS_SPACE);
        }
        return true;
    } // use case : 1 3 같은 값을 검증하기 위해

    private static boolean verifyForValueIsNumeric(String value) {
        if (!(value.chars().allMatch(Character::isDigit))) {
            throw new IllegalArgumentException(VALUE_IS_NOT_NUMERIC);
        }
        return true;
    }

    private static boolean verifyForValueIsDuplicate(String value) {
        HashSet<Character> value_set = value.chars()
                .mapToObj(v -> (char) v)
                .collect(Collectors.toCollection(HashSet::new));
        if (value_set.size() != 3) {
            throw new IllegalArgumentException(VALUE_IS_DUPLICATE);
        }
        return true;
    } // use case : 111 같은 값을 검증하기 위해

    private static boolean verifyForNumberRangeIsCorrect(String value){
        if(!(value.chars().allMatch(v-> v >= '1' && v <= '9'))){
            throw new IllegalArgumentException(VALUE_RANGE_UNCORRECT);
        }
        return true;
    } // use case : 1~9의 값

    private static boolean verifyForRetryConditionIsCorrect(String value){
        if (!value.matches("[12]")){
            throw new IllegalArgumentException(RETRY_VALUE_RANGE_UNCORRECT);
        }
        return true;
    }
}