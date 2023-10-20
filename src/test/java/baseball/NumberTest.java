package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumberTest {

    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 10})
    @DisplayName("야구 숫자가 1부터 9까지의 숫자가 아니라면 예외가 발생한다.")
    void isNumberOutOfBound_Then_ExceptionOccurs(final int number) {
        assertThatThrownBy(() -> Number.of(number))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
