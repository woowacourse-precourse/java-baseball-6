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

    @Test
    @DisplayName("3자리 수인 경우 Baseballs 객체를 생성하는 테스트")
    void constructorTest() {
        // given
        List<Integer> numbers = List.of(1, 2, 3);

        // expected
        assertDoesNotThrow(() -> new Baseballs(numbers));
    }

    @ParameterizedTest
    @MethodSource("invalidSizeParameters")
    @DisplayName("3자리 수가 아닌 경우 예외 발생하는 테스트")
    void constructorExceptionTest(List<Integer> numbers) {
        // expected
        assertThrows(IllegalStateException.class, () -> new Baseballs(numbers));
    }
}