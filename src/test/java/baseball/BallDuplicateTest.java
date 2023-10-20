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

public class BallDuplicateTest {

    @ParameterizedTest
    @DisplayName("중복 값 검증")
    @MethodSource("provideDuplicateBalls")
    public void testBalls(List<Ball> balls) {
        BallDuplicateValidator ballDuplicateValidator = BallDuplicateValidator.getInstance();
        Assertions.assertThatThrownBy(() -> ballDuplicateValidator.validate(balls))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("중복된 숫자가 존재합니다.");
    }

    private static Stream<List<Ball>> provideDuplicateBalls() {
        return Stream.of(
                Arrays.asList(new Ball(2, 1),
                        new Ball(3, 2),
                        new Ball(3, 3)),
                Arrays.asList(new Ball(3, 1),
                        new Ball(6, 3),
                        new Ball(6, 2))
        );
    }
}


