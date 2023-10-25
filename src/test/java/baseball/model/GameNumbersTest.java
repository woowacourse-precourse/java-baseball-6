package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameNumbersTest {

    @DisplayName("잘못된 값에 대한 예외 처리 문자열")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"1234", "112", "5567", "-123", "ball", "wt6", "-0", "", "603", "999999999999999999999"})
    void checkInvalidValueString(String value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameNumbers(value));
    }

    @DisplayName("올바른 값 입력 확인 문자열")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @MethodSource("checkValidGameNumberParametersProvider")
    void checkValidValue(String value, GameNumbers gameNumbers) {
        assertThat(new GameNumbers(value).equals(gameNumbers)).isTrue();
    }

    static Stream<Arguments> checkValidGameNumberParametersProvider() {
        return Stream.of(
                Arguments.arguments("123", GameNumbers.of("123")),
                Arguments.arguments("759", GameNumbers.of("759")),
                Arguments.arguments("864", GameNumbers.of("864"))
        );
    }
}
