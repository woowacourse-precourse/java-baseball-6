package baseball.domain;

import java.util.Arrays;

public class UserBalls {
    private static final String ERROR_MESSAGE_OF_SIZE = "3자리 값만 입력해야 합니다.";
    private static final String ERROR_MESSAGE_OF_NAN = "숫자만 입력해야 합니다.";
    private static final String ERROR_MESSAGE_OUT_OF_RANGE = "1~9사이의 값만 입력해야 합니다.";
    private static final String ERROR_MESSAGE_OF_DUPLICATED = "중복되지 않은 값만 입력해야 합니다.";
    private static final int MIN_VALUE = 1;
    private static final int BALL_SIZE = 3;
    private final String balls;

    public UserBalls(String balls) {
        validateBalls(balls);
        this.balls = balls;
    }

    public String getUserBalls() {
        return this.balls;
    }

    private void validateBalls(String input) {
        validateBallSize(input);
        validateNan(input);
        validateRange(input);
        validateDuplicate(input);
    }

    private void validateBallSize(String data) {
        if (data.length() != BALL_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_SIZE);
        }
    }

    private void validateNan(String data) {
        try {
            Integer.parseInt(data);
        } catch (NumberFormatException exception) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_NAN);
        }
    }

    private void validateRange(String data) {
        String[] splitedData = data.split("");
        Arrays.stream(splitedData)
                .map(Integer::parseInt)
                .filter(number -> number < MIN_VALUE)
                .findAny()
                .ifPresent(result -> {
                    throw new IllegalArgumentException(ERROR_MESSAGE_OUT_OF_RANGE);
                });
    }

    private void validateDuplicate(String data) {
        long deduplicatedDataSize = data.chars()
                .distinct()
                .count();
        if (deduplicatedDataSize != BALL_SIZE) {
            throw new IllegalArgumentException(ERROR_MESSAGE_OF_DUPLICATED);
        }
    }
}
