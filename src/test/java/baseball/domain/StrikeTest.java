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

public class StrikeTest {

    @DisplayName("스트라이크 생성시 0~3 범위면 에러가 발생하지 않는다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void createSuccessTest(int strike) {
        assertThatCode(() -> Strike.from(strike))
                .doesNotThrowAnyException();
    }

    @DisplayName("스트라이크 생성시 0~3 범위가 아니면 IllegalArgumentException 에러가 발생한다.")
    @ParameterizedTest
    @ValueSource(ints = {-1, 4})
    void createFailTest(int strike) {
        assertThatCode(() -> Strike.from(strike))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("스트라이크의 유효 범위는 0~3 입니다.");
    }

    @DisplayName("스트라이크가 비어있으면 isEmpty()의 결과로 true를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideIsEmptyTestArguments")
    void isEmptyTest(Strike strike, boolean expected) {
        assertThat(strike.isEmpty()).isEqualTo(expected);
    }

    static Stream<Arguments> provideIsEmptyTestArguments() {
        return Stream.of(
                arguments(Strike.from(0), true),
                arguments(Strike.from(1), false),
                arguments(Strike.from(2), false),
                arguments(Strike.from(3), false)
        );
    }

    @DisplayName("스트라이크가 3이면 isFullCount()의 결과로 true를 반환한다.")
    @ParameterizedTest
    @MethodSource("provideIsFullCountTestArguments")
    void isFullCountTest(Strike strike, boolean expected) {
        assertThat(strike.isFullCount()).isEqualTo(expected);
    }

    static Stream<Arguments> provideIsFullCountTestArguments() {
        return Stream.of(
                arguments(Strike.from(0), false),
                arguments(Strike.from(1), false),
                arguments(Strike.from(2), false),
                arguments(Strike.from(3), true)
        );
    }
}
