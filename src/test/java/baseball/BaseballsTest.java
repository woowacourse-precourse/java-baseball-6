package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class BaseballsTest {

    private static Stream<Arguments> invalidSizeParameters() {
        return Stream.of(
                Arguments.of(List.of()),
                Arguments.of(List.of(1)),
                Arguments.of(List.of(1, 2)),
                Arguments.of(List.of(1, 2, 3, 4))
        );
    }

    private static Stream<Arguments> invalidValueParameters() {
        return Stream.of(
                Arguments.of(List.of(1, 1, 2)),
                Arguments.of(List.of(1, 2, 2)),
                Arguments.of(List.of(1, 2, 1))
        );
    }

    private static Stream<Arguments> invalidValueRangeParameters() {
        return Stream.of(
                Arguments.of(List.of(0, 1, 2)),
                Arguments.of(List.of(-1, 1, 2)),
                Arguments.of(List.of(1, 2, 10))
        );
    }

    @Test
    @DisplayName("1 ~ 9 사이 서로 다른 3자리 수인 경우 Baseballs 객체를 생성하는 테스트")
    void constructorTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);

        // expected
        assertDoesNotThrow(() -> new Baseballs(numbers));
    }

    @ParameterizedTest
    @MethodSource("invalidSizeParameters")
    @DisplayName("3자리 수가 아닌 경우 예외 발생하는 테스트")
    void invalidListSizeExceptionTest(List<Integer> numbers) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> new Baseballs(numbers));
    }

    @ParameterizedTest
    @MethodSource("invalidValueParameters")
    @DisplayName("3개의 수가 서로 다르지 않은 경우 예외 발생하는 테스트")
    void invalidValueExceptionTest(List<Integer> numbers) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> new Baseballs(numbers));
    }

    @ParameterizedTest
    @MethodSource("invalidValueRangeParameters")
    @DisplayName("1 ~ 9 사이 수가 아닌 경우 예외 발생하는 테스트")
    void invalidValueRangeExceptionTest(List<Integer> numbers) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> new Baseballs(numbers));
    }
}