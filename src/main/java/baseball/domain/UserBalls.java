package baseball.domain;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class UserBalls extends AbstractBalls {

    private UserBalls(List<Ball> balls) {
        super(balls);
    }

    public static UserBalls from(String numbers) {
        validateLength(numbers);

        List<Ball> balls = mapToBalls(numbers);
        validateBallsNotDuplicated(balls);

        return new UserBalls(balls);
    }

    private static void validateLength(String numbers) {
        int numbersLength = numbers.length();
        if (numbersLength != VALID_BALL_COUNT) {
            throw new IllegalArgumentException(
                    VALID_BALL_COUNT + "자리 숫자만 입력될 수 있습니다. 입력 값은 " + numbersLength + "자리입니다.");
        }
    }

    private static List<Ball> mapToBalls(String rawNumbers) {
        List<String> numbers = new ArrayList<>();
        for (char number : rawNumbers.toCharArray()) {
            numbers.add(String.valueOf(number));
        }

        return numbers.stream()
                .map(Ball::from)
                .toList();
    }

    private static void validateBallsNotDuplicated(List<Ball> balls) {
        if (balls.size() != new HashSet<>(balls).size()) {
            throw new IllegalArgumentException("입력 값은 중복될 수 없습니다.");
        }
    }

}
