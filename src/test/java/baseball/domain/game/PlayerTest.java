package baseball.domain.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.util.Err;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("Player의 세 자리 숫자가 1 ~ 9 사이에 없으면 예외 발생")
    @Test
    void validateGameNumber_OutOfRange_Exception() {
        // given
        List<Integer> numbers = List.of(-1, 0, 10);

        // when
        // then
        assertThatThrownBy(() -> Player.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.OUT_OF_RANGE_NUMBERS.getMessage());
    }

    @DisplayName("Player가 세 자리 숫자를 가지지 않으면 예외 발생")
    @Test
    void validateSize_NotThree_Exception() {
        // given
        List<Integer> numbers1 = List.of(7, 2, 5, 1);
        List<Integer> numbers2 = List.of(7, 1);

        // when
        // then
        assertThatThrownBy(() -> Player.of(numbers1))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.INVALID_NUMBERS_SIZE.getMessage());

        assertThatThrownBy(() -> Player.of(numbers2))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.INVALID_NUMBERS_SIZE.getMessage());
    }

    @DisplayName("Player의 세 자리 숫자가 중복이면 예외 발생")
    @Test
    void validateDuplication_NotUnique_Exception() {
        // given
        List<Integer> numbers = List.of(7, 7, 1);

        // when
        // then
        assertThatThrownBy(() -> Player.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(Err.DUPLICATE_NUMBERS.getMessage());
    }
}