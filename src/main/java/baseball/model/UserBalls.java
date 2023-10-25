package baseball.model;

import static baseball.util.AppConstants.BALLS_SIZE;
import static baseball.util.AppConstants.BALLS_SIZE_MESSAGE;
import static baseball.util.AppConstants.NOT_INTEGER_MESSAGE;
import static baseball.util.AppConstants.NO_REPEAT_MESSAGE;

import java.util.List;
import java.util.stream.Collectors;

public class UserBalls {
    private final List<Ball> userBalls;

    public UserBalls(String stringInput) {
        validateIsThreeLetters(stringInput);
        validateNoRepeat(stringInput);
        validateAreNumbers(stringInput);
        this.userBalls = stringInput.chars()
                .mapToObj(Ball::new)
                .collect(Collectors.toList());
    }

    public List<Ball> getUserBalls() {
        return this.userBalls;
    }

    private void validateIsThreeLetters(String stringInput) {
        if (stringInput.length() != BALLS_SIZE) {
            throw new IllegalArgumentException(BALLS_SIZE_MESSAGE);
        }
    }

    private void validateNoRepeat(String stringInput) {
        if (stringInput.chars().distinct().count() != BALLS_SIZE) {
            throw new IllegalArgumentException(NO_REPEAT_MESSAGE);
        }
    }

    private void validateAreNumbers(String stringInput) {
        try {
            Integer.parseInt(stringInput);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(NOT_INTEGER_MESSAGE);
        }
    }
}