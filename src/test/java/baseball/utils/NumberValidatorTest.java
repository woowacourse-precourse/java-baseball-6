package baseball.utils;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberValidatorTest {

    @DisplayName("범위에 맞지 않는 숫자가 존재하면 예외를 발생시킨다.")
    @Test
    void validateNumbersInRange() {
        // given
        List<Integer> numbers = List.of(0, 1, 9);
        int startInclusive = 1;
        int endInclusive = 9;

        // when & then
        assertThatThrownBy(() -> NumberValidator.validateNumbersInRange(numbers, startInclusive, endInclusive))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복이 있으면 예외를 발생시킨다.")
    @Test
    void validateNotDuplicated() {
        // given
        List<Integer> numbers = List.of(1, 1, 2);

        // when & then
        assertThatThrownBy(() -> NumberValidator.validateNotDuplicated(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

}