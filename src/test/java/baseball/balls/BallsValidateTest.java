package baseball.balls;

import java.util.List;
import java.util.stream.IntStream;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallsValidateTest {

    private final int MIN_VALUE = BallValue.BALL_MIN_VALUE;
    private final int BALL_COUNT = Balls.BALL_COUNT;

    @Test
    void 값_혹은_인덱스_중복_없음() {
        // given
        List<Ball> balls = makeBallsWithoutDuplicated();

        // when

        // then
        Assertions.assertDoesNotThrow(() -> {
            new Balls(balls);
        });
    }

    @Test
    void 값_중복() {
        // given
        List<Ball> balls = makeBallsWithDuplicatedValue();

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Balls(balls);
        });
    }

    @Test
    void 인덱스_중복() {
        // given
        List<Ball> balls = makeBallsWithDuplicatedIndex();

        // when

        // then
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Balls(balls);
        });
    }

    private List<Ball> makeBallsWithoutDuplicated() {
        return IntStream.rangeClosed(1, BALL_COUNT)
                .mapToObj(i -> {
                    int value = MIN_VALUE + i - 1;
                    int index = i - 1;
                    return new Ball(value, index);
                })
                .toList();
    }

    private List<Ball> makeBallsWithDuplicatedValue() {
        return IntStream.rangeClosed(1, BALL_COUNT)
                .mapToObj(i -> {
                    int value = MIN_VALUE;
                    int index = i - 1;
                    return new Ball(value, index);
                })
                .toList();
    }

    private List<Ball> makeBallsWithDuplicatedIndex() {
        return IntStream.rangeClosed(1, BALL_COUNT)
                .mapToObj(i -> {
                    int value = MIN_VALUE + i - 1;
                    int index = 1;
                    return new Ball(value, index);
                })
                .toList();
    }

}
