package baseball.model;

import static baseball.util.AppConstants.BALLS_SIZE;
import static baseball.util.AppConstants.BALLS_SIZE_MESSAGE;
import static baseball.util.AppConstants.NO_REPEAT_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;

public class UserBalls {
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