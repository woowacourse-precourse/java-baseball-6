package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NumberTest {

    private final Number number = new Number();

    @DisplayName("숫자가 3개가 아닐경우 예외가 발생한다.")
    @Test
    void validateNumberSize() {
        // given
        List<Integer> numberList = List.of(1, 2, 3, 4);

        // when, then
        assertThatThrownBy(() -> number.validateNumberSize(numberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 중복될 경우 예외가 발생한다.")
    @Test
    void validateDuplicateNumber() {
        // given
        List<Integer> numberList = List.of(1,1,2);

        //when, then
        assertThatThrownBy(() -> number.validateDuplicateNumber(numberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("숫자가 1~9 사이가 아닐 경우 예외가 발생한다.")
    @Test
    void validateNumberLength() {
        // given
        List<Integer> numberList = List.of(0,1,2);

        //when, then
        assertThatThrownBy(() -> number.validateNumberLength(numberList))
                .isInstanceOf(IllegalArgumentException.class);
    }

}