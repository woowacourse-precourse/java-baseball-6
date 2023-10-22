package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BaseballTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5, 6, 7, 8, 9})
    @DisplayName("1 ~ 9 사이 수인 경우 Baseball 객체를 생성하는 테스트")
    void constructorTest(int number) {
        // expected
        assertDoesNotThrow(() -> new Baseball(number));
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    @DisplayName("1 ~ 9 사이 수가 아닌 경우 예외 발생")
    void constructorExceptionTest(int number) {
        // expected
        assertThrows(IllegalArgumentException.class, () -> new Baseball(number));
    }
}