package baseball.model;

import java.util.List;
import java.util.stream.Collectors;

public class UserBalls {
    private static final int BALLS_SIZE = 3;
    private static final String NO_REPEAT_MESSAGE = "입력값은 중복되지 않는 3자리 숫자여야 합니다.";
    private static final String BALLS_SIZE_MESSAGE = "입력값은 " + BALLS_SIZE + "자리 숫자여야 합니다.";

    private final List<Ball> userBalls;

    public UserBalls(String input) {
        validateIsThreeDigits(input);
        validateDiffVals(input);
        this.userBalls = input.chars()
                .mapToObj(val -> new Ball((char) val))
                .collect(Collectors.toList());
    }

    public List<Ball> getUserBalls() {
        return this.userBalls;
    }

    void validateIsThreeDigits(String input) {
        if (input.length() != BALLS_SIZE) {
            throw new IllegalArgumentException(BALLS_SIZE_MESSAGE);
        }
    }

    void validateDiffVals(String input) {
        if (input.chars().distinct().count() != BALLS_SIZE) {
            throw new IllegalArgumentException(NO_REPEAT_MESSAGE);
        }
    }
}