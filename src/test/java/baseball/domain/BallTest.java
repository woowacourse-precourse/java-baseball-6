package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.junit.jupiter.params.provider.Arguments.arguments;

import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BallTest {

    @DisplayName("Ball 생성시 0~3 범위면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void createSuccessTest(int ball) {
        assertThatCode(() -> new Ball(ball))
                .doesNotThrowAnyException();
    }

    @DisplayName("Ball 생성시 0~3 범위가 아니면 IllegalArgumentException 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void createFailTest(int ball) {
        assertThatCode(() -> new Ball(ball))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("볼의 유효 범위는 0~3 입니다.");
    }

    @DisplayName("Ball이 없는지 확인한다.")
    @ParameterizedTest
    @MethodSource("provideIsEmptyTestArguments")
    void isEmptyTest(Ball ball, boolean expected) {
        assertThat(ball.isEmpty()).isEqualTo(expected);
    }

    static Stream<Arguments> provideIsEmptyTestArguments() {
        return Stream.of(
                arguments(new Ball(0), true),
                arguments(new Ball(1), false),
                arguments(new Ball(2), false),
                arguments(new Ball(3), false)
        );
    }
}
