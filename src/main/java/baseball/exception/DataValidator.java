package baseball.exception;

import java.util.*;

public class DataValidator {
    private static final int MAX_BALL_SIZE = 3;

    public void validateInputNumber(String data) {
        validateDataLength(data);
        validateDataIsDuplicate(data);
        validateDataIsNumber(data);
    }

    private void validateDataLength(String data) {
        if (data.length() != MAX_BALL_SIZE) {
            throw new IllegalArgumentException("3자리의 숫자를 입력해주세요.");
        }
    }

    private void validateDataIsNumber(String data) {
        for (int i = 0; i < data.length(); i++) {
            if (!Character.isDigit(data.charAt(i))) {
                throw new IllegalArgumentException("숫자만 입력해주세요.");
            }
        }
    }

    private void validateDataIsDuplicate(String data) {
        String[] array = data.split("");
        Set<String> set = new HashSet<>();
        Collections.addAll(set, array);

        if (array.length != set.size()) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }
    }
}
