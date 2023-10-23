package baseball.domain;

import java.util.Arrays;

public class UserBalls {
    private static final String ERROR_MESSAGE = "입력 값이 올바르지 않습니다. 1~9사이의 중복되지 않는 3자리의 숫자를 입력해주세요.";
    private static final int BALL_SIZE = 3;
    private final String balls;

    public UserBalls(String balls) {
        validateBalls(balls);
        this.balls = balls;
    }

    private void validateBalls(String input) {
        if (!isOkBallSize(input) || isNan(input) || isLessThan1(input) || isDuplicate(input)) {
            throw new IllegalArgumentException(ERROR_MESSAGE);
        }
    }

    private boolean isOkBallSize(String data) {
        return data.length() == BALL_SIZE;
    }

    private boolean isNan(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException exception) {
            return true;
        }
        return false;
    }

    private boolean isLessThan1(String data) {
        String[] splitedData = data.split("");
        return Arrays.stream(splitedData)
                .map(Integer::parseInt)
                .anyMatch((number) -> number < 1);
    }

    private boolean isDuplicate(String data) {
        long deduplicatedDataSize = data.chars()
                .distinct()
                .count();
        return deduplicatedDataSize != BALL_SIZE;
    }
}
