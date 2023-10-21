package baseball.exception;

import baseball.domain.GameOption;

import java.util.*;

public class DataValidator {
    private static final int MAX_BALL_SIZE = 3;

    private static final String BLANK_DELIMITERS = "";

    private static final String ZERO = "0";

    public void validateRetryOrEndGameCommand(String data) {
        if (!data.equals(GameOption.RESTART.getOption()) && !data.equals(GameOption.END.getOption())) {
            throw new IllegalArgumentException("게임을 재시작하려면 1, 종료하려면 2를 입력하세요");
        }
    }

    public void validateInputNumber(String data) {
        validateDataLength(data);
        validateDataIsDuplicate(data);
        validateDataIsNumber(data);
        validateDataRange(data);
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
        String[] array = data.split(BLANK_DELIMITERS);
        Set<String> set = new HashSet<>();
        Collections.addAll(set, array);

        if (array.length != set.size()) {
            throw new IllegalArgumentException("중복된 숫자를 입력할 수 없습니다.");
        }
    }

    private void validateDataRange(String data) {
        if (data.contains(ZERO)) {
            throw new IllegalArgumentException("1~9까지의 숫자만 입력해주세요.");
        }
    }

}
