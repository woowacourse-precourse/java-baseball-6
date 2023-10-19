package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class BallNumbersTest {

    @ParameterizedTest
    @MethodSource("generateInvalidNumbers")
    @DisplayName("플레이어의 야구 숫자의 개수가 3이 아니면 예외가 발생한다.")
    void validateSizeWhenCreatePlayerNumbers(final List<Integer> numbers) {
        assertThatThrownBy(() -> new BallNumbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private static Stream<Arguments> generateInvalidNumbers() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3, 4))
        );
    }

    @Test
    @DisplayName("플레이어의 야구 숫자에 중복된 숫자가 있으면 예외가 발생한다.")
    void validateDuplicateWhenCreatePlayerNumbers() {
        assertThatThrownBy(() -> new BallNumbers(List.of(1, 1, 1)))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> new BallNumbers(List.of(2, 5, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
