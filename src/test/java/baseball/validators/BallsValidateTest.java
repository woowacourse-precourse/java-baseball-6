package baseball.validators;

import baseball.balls.Ball;
import baseball.balls.BallValue;
import baseball.balls.Balls;
import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallsValidateTest {

    private final int BALL_COUNT = Balls.BALL_COUNT;

    @Test
    void 공_개수_기준치_동일_허용() {
        // when
        List<Ball> balls = generateBallList(BALL_COUNT, true, true);

        // then
        Assertions.assertDoesNotThrow(() -> {
            BallsValidators.validateBallCount(balls);
        });
    }

    @ParameterizedTest
    @CsvSource(value = {
            "" + (BALL_COUNT - 1),
            "" + (BALL_COUNT + 1),
    })
    void 공_개수_기준치_미만_혹은_초과_불허(int ballCount) {
        // when
        List<Ball> balls = generateBallList(ballCount, true, true);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BallsValidators.validateBallCount(balls);
        });
    }

    @Test
    void 공_값_미중복_허용() {
        // when
        List<Ball> balls = generateBallList(BALL_COUNT, false, true);

        // then
        Assertions.assertDoesNotThrow(() -> {
            BallsValidators.validateValueDuplication(balls);
        });
    }

    @Test
    void 공_값_중복_불허() {
        // when
        List<Ball> balls = generateBallList(BALL_COUNT, true, true);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BallsValidators.validateValueDuplication(balls);
        });
    }

    @Test
    void 공_인덱스_미중복_허용() {
        // when
        List<Ball> balls = generateBallList(BALL_COUNT, true, false);

        // then
        Assertions.assertDoesNotThrow(() -> {
            BallsValidators.validateIndexDuplication(balls);
        });
    }

    @Test
    void 공_인덱스_중복_불허() {
        // when
        List<Ball> balls = generateBallList(BALL_COUNT, false, true);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BallsValidators.validateIndexDuplication(balls);
        });
    }

    private List<Ball> generateBallList(int ballCount, boolean willDuplicateValue, boolean willDuplicateIndex) {
        return IntStream.range(0, ballCount)
                .mapToObj(i -> {
                    int value = makeValue(willDuplicateValue, i);
                    int index = makeIndex(willDuplicateIndex, i);
                    return new Ball(value, index);
                })
                .toList();
    }

    private int makeValue(boolean willDuplicate, int index) {
        if (willDuplicate) {
            return BallValue.MIN_VALUE;
        }
        return BallValue.MIN_VALUE + index;
    }

    private int makeIndex(boolean willDuplicate, int index) {
        if (willDuplicate) {
            return 0;
        }
        return index;
    }

}
