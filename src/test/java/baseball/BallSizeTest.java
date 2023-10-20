package baseball;

import domain.Ball;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import util.validator.BallDuplicateValidator;
import util.validator.BallSizeValidator;

public class BallSizeTest {

    @ParameterizedTest
    @DisplayName("자릿수 3자리 검증")
    @MethodSource("provideWrongSizeBalls")
    public void testBalls(List<Ball> balls) {
        BallSizeValidator ballSizeValidator = BallSizeValidator.getInstance();
        Assertions.assertThatThrownBy(() -> ballSizeValidator.validate(balls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("3자리 수만 입력 가능합니다.");
    }


    private static Stream<List<Ball>> provideWrongSizeBalls() {
        return Stream.of(
                Arrays.asList(new Ball(2, 1),
                        new Ball(3, 2)),
                Arrays.asList(new Ball(3, 1),
                        new Ball(4, 3),
                        new Ball(5, 3),
                        new Ball(6, 2))
        );
    }

}
