package baseball.validation;

import java.util.HashSet;
import java.util.stream.Collectors;

public class GameValidation {
    public static boolean verifyForGameValue(String input_value) {
        return verifyForValueIsEmpty(input_value) &&
                        verifyForValueLength(input_value) &&
                                verifyForValueIsSpace(input_value) &&
                                        verifyForValueIsNumeric(input_value) &&
                                                verifyForValueIsDuplicate(input_value);
    }

    private static boolean verifyForValueIsEmpty(String value) {
        if (value.equals("")) {
            throw new IllegalArgumentException("입력 값이 빈 문자열입니다.");
        }
        return true;
    }

    private static boolean verifyForValueLength(String value) {
        if (value.length() != 3) {
            throw new IllegalArgumentException("입력 값의 길이가 초과 또는 부족입니다.");
        }
        return true;
    } // use case: 1234,12 같은 값을 검증하기 위해

    private static boolean verifyForValueIsSpace(String value) {
        String values = value.replaceAll(" ", "");
        if (!value.equals(values)) {
            throw new IllegalArgumentException("입력 값에 공백이 포함되어 있습니다.");
        }
        return true;
    } // use case : 1 3 같은 값을 검증하기 위해

    private static boolean verifyForValueIsNumeric(String value) {
        if (!(value.chars().allMatch(Character::isDigit))) {
            throw new IllegalArgumentException("입력 값이 숫자가 아닙니다.");
        }
        return true;
    }

    private static boolean verifyForValueIsDuplicate(String value) {
        HashSet<Character> value_set = value.chars()
                .mapToObj(v -> (char) v)
                .collect(Collectors.toCollection(HashSet::new));
        if (value_set.size() != 3) {
            throw new IllegalArgumentException("입력 값이 중복되었습니다. 중복되지 않은값을 입력하여 주세요.");
        }
        return true;
    } // use case : 111 같은 값을 검증하기 위해

}