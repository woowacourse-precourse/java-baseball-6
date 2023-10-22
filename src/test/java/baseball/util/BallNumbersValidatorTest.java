package baseball.util;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.domain.Computer;
import baseball.domain.Player;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallNumbersValidatorTest {

    @DisplayName("Player가 세 자리의 숫자를 가지지 않으면 예외 발생")
    @Test
    void throwIfPlayerNotThreeDigits() {
        // given
        List<Integer> numbers = List.of(1, 2, 3, 4);

        // when
        // then
        assertThatThrownBy(() -> Player.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 3자리의 숫자를 입력해주세요.");
    }

    @DisplayName("Player의 세 자리 숫자는 모두 1 ~ 9 사이의 숫자여야 한다. 아니면 예외 발생")
    @Test
    void throwIfPlayerNotInRangeOneToNine() {
        // given
        List<Integer> numbers = List.of(-1, 0, 9);

        // when
        // then
        assertThatThrownBy(() -> Player.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1부터 9까지의 범위에 있는 숫자만 입력할 수 있습니다.");
    }

    @DisplayName("Player의 세 자리 숫자가 중복이면 예외 발생")
    @Test
    void throwIfPlayerContainsDuplicates() {
        // given
        List<Integer> numbers = List.of(6, 6, 6);

        // when
        // then
        assertThatThrownBy(() -> Player.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 서로 다른 숫자를 입력해주세요.");
    }

    @DisplayName("Computer가 세 자리의 숫자를 가지지 않으면 예외 발생")
    @Test
    void throwIfComputerNotThreeDigits() {
        // given
        List<Integer> numbers = List.of(7, 2, 5, 1);

        // when
        // then
        assertThatThrownBy(() -> Computer.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 3자리의 숫자를 입력해주세요.");
    }

    @DisplayName("Computer의 세 자리 숫자는 모두 1 ~ 9 사이의 숫자여야 한다. 아니면 예외 발생")
    @Test
    void throwIfComputerNotInRangeOneToNine() {
        // given
        List<Integer> numbers = List.of(-10, 0, 10);

        // when
        // then
        assertThatThrownBy(() -> Computer.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 1부터 9까지의 범위에 있는 숫자만 입력할 수 있습니다.");
    }

    @DisplayName("Computer의 세 자리 숫자가 중복이면 예외 발생")
    @Test
    void throwIfComputerContainsDuplicates() {
        // given
        List<Integer> numbers = List.of(7, 7, 6);

        // when
        // then
        assertThatThrownBy(() -> Computer.of(numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("[ERROR] 서로 다른 숫자를 입력해주세요.");
    }

}