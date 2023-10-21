package baseball.domain;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class PlayerNumbersTest {

    private static final int DIGIT_NUMBER = 3;

    @DisplayName("플레이어의 수를 생성할 때 지정된 자릿수와 일치하지 않는 경우 예외를 발생시킨다.")
    @Test
    void constructPlayerNumbers_Fail_ByInvalidDigitNumber() {
        // when, then
        assertThatThrownBy(() -> new PlayerNumbers(List.of(1), DIGIT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 수를 생성할 때 각 숫자가 지정된 범위를 벗어나는 경우 예외를 발생시킨다.")
    @Test
    void constructPlayerNumbers_Fail_ByOutOfRange() {
        // when, then
        assertThatThrownBy(() -> new PlayerNumbers(List.of(1, 2, 0), DIGIT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어의 수를 생성할 때 각 숫자가 다른 숫자와 중복되는 경우 예외를 발생시킨다.")
    @ParameterizedTest
    @MethodSource("parametersForDuplicatedWithOtherNumber")
    void constructPlayerNumbers_Fail_ByDuplicatedWithOtherNumber(List<Integer> inputPlayerNumbers) {
        // when, then
        assertThatThrownBy(() -> new PlayerNumbers(inputPlayerNumbers, DIGIT_NUMBER))
                .isInstanceOf(IllegalArgumentException.class);
    }

    static Stream<Arguments> parametersForDuplicatedWithOtherNumber() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 2)), // 첫 번째 숫자와 두 번째 숫자가 중복되는 경우
                Arguments.of(List.of(1, 2, 2)), // 두 번째 숫자와 세 번째 숫자가 중복되는 경우
                Arguments.of(List.of(1, 2, 1)), // 첫 번째 숫자와 세 번째 숫자가 중복되는 경우
                Arguments.of(List.of(1, 1, 1)) // 모든 숫자가 중복되는 경우
        );
    }
}
