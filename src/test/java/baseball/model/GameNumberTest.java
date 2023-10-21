package baseball.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class GameNumberTest {

    @DisplayName("잘못된 값에 대한 예외 처리 문자열")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @ValueSource(strings = {"1234", "5567", "-123", "ball", "wt6", "-0", "", "603", "999999999999999999999"})
    void checkInvalidValueString(String value) {
        assertThatIllegalArgumentException()
                .isThrownBy(() -> new GameNumber(value));
    }

    @DisplayName("올바른 값 입력 확인 문자열")
    @ParameterizedTest(name = "{index} {displayName} message={0}")
    @MethodSource("checkValidGameNumberParametersProvider")
    void checkValidValue(String value, GameNumber gameNumber) {
        assertThat(new GameNumber(value).equals(gameNumber)).isTrue();
    }

    static Stream<Arguments> checkValidGameNumberParametersProvider() {
        return Stream.of(
                Arguments.arguments("123", GameNumber.of(List.of(1, 2, 3))),
                Arguments.arguments("759", GameNumber.of(List.of(7, 5, 9))),
                Arguments.arguments("864", GameNumber.of(List.of(8, 6, 4)))
        );
    }
}