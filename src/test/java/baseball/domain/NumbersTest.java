package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class NumbersTest {
    
    @Test
    @DisplayName("3자리 이상의 숫자를 입력할 경우 예외 발생")
    void validateLength() {
        List<Integer> input = List.of(1, 2, 3, 4);
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("중복된 숫자를 입력할 경우 예외 발생")
    void validateDuplicateNumber() {
        List<Integer> input = List.of(1, 2, 2);
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("범위 이외의 숫자를 입력할 경우 예외 발생")
    void validateRange() {
        List<Integer> input = List.of(1, 2, 0);
        assertThatThrownBy(() -> new Numbers(input))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
