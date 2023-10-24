package baseball.vo;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumbersTest {
    @DisplayName("Numbers 값의 예외처리 기능")
    @ParameterizedTest
    @ValueSource(strings = {"1234", "12", "1a2", "zxc", "ab2", "2ab", "112", "111", "344", "013"})
    void 예외처리(String numbers) {
        assertThatThrownBy(() -> new Numbers(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
