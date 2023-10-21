package baseball.validators;

import baseball.balls.Ball;
import baseball.balls.BallValue;
import baseball.balls.Balls;
import baseball.testUtils.BallsGeneratorUtil;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class BallsValidateTest {

    private final int BALL_COUNT = Balls.BALL_COUNT;
    private final int BALL_MIN_VALUE = BallValue.MIN_VALUE;

    @Test
    void 공_개수_기준치_동일_허용() {
        // when
        List<Ball> balls = BallsGeneratorUtil.generateBallList(BALL_COUNT, BALL_MIN_VALUE, true, true);

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
        List<Ball> balls = BallsGeneratorUtil.generateBallList(ballCount, BALL_MIN_VALUE, true, true);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BallsValidators.validateBallCount(balls);
        });
    }

    @Test
    void 공_값_미중복_허용() {
        // when
        List<Ball> balls = BallsGeneratorUtil.generateBallList(BALL_COUNT, BALL_MIN_VALUE, false, true);

        // then
        Assertions.assertDoesNotThrow(() -> {
            BallsValidators.validateValueDuplication(balls);
        });
    }

    @Test
    void 공_값_중복_불허() {
        // when
        List<Ball> balls = BallsGeneratorUtil.generateBallList(BALL_COUNT, BALL_MIN_VALUE, true, true);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BallsValidators.validateValueDuplication(balls);
        });
    }

    @Test
    void 공_인덱스_미중복_허용() {
        // when
        List<Ball> balls = BallsGeneratorUtil.generateBallList(BALL_COUNT, BALL_MIN_VALUE, true, false);

        // then
        Assertions.assertDoesNotThrow(() -> {
            BallsValidators.validateIndexDuplication(balls);
        });
    }

    @Test
    void 공_인덱스_중복_불허() {
        // when
        List<Ball> balls = BallsGeneratorUtil.generateBallList(BALL_COUNT, BALL_MIN_VALUE, false, true);

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            BallsValidators.validateIndexDuplication(balls);
        });
    }

}
