package baseball.utils;

import java.util.HashSet;
import java.util.List;

public class ValidationUtils {
    private static final String ERROR_MESSAGE = "[ERROR] 잘못된 입력 값입니다. 애플리케이션을 종료합니다.";
    private static final List<String> NUMBERS = List.of("1","2","3","4","5","6","7","8","9");

    public void validateUnique3DigitNum(String input) {
        if (input.length() != 3)
            throw new IllegalArgumentException(ERROR_MESSAGE);
        HashSet<String> set=new HashSet<>();
        for (String s:input.split("")) {
            if (!NUMBERS.contains(s)) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            if (set.contains(s)) {
                throw new IllegalArgumentException(ERROR_MESSAGE);
            }
            set.add(s);
        }
    }

    public void validateOneOrTwo(String input) {
        if (input.equals("1") || input.equals("2")) {
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE);
    }
}
