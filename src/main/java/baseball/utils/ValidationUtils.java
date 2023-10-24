package baseball.utils;

import java.util.HashSet;
import java.util.List;

public class ValidationUtils {

    private static final String INVALID_LENGTH_MESSAGE = "[ERROR] 입력된 값이 3자리 수가 아닙니다. 애플리케이션을 종료합니다.";
    private static final String INVALID_NUMBER_MESSAGE = "[ERROR] 입력된 값이 1에서 9 사이의 서로다른 세 자연수가 아닙니다. 애플리케이션을 종료합니다.";
    private static final String INVALID_ONE_OR_TWO_MESSAGE = "[ERROR] 1또는 2 만 입력이 가능합니다. 애플리케이션을 종료합니다.";

    private static final List<String> NUMBERS = List.of("1", "2", "3", "4", "5", "6", "7", "8", "9");

    public void validateUnique3DigitNum(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException(INVALID_LENGTH_MESSAGE);
        HashSet<String> set = new HashSet<>();
        for (String s : input.split("")) {
            if (!NUMBERS.contains(s)) {
                throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
            }
            if (set.contains(s)) {
                throw new IllegalArgumentException(INVALID_NUMBER_MESSAGE);
            }
            set.add(s);
        }
    }

    public void validateOneOrTwo(String input) {
        if (input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException(INVALID_ONE_OR_TWO_MESSAGE);
    }
}
