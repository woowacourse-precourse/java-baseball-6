package baseball.game;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameNumbersTest {
    @DisplayName("3자리 수가 아니라면 예외가 발생해야 한다.")
    @Test
    void 숫자_크기_예외_테스트() {
        //when, then
        assertThatThrownBy(() -> new GameNumbers(List.of(1, 2, 3, 4)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("1~9사이의 숫자가 아니라면 예외가 발생해야 한다.")
    @Test
    void 숫자_범위_예외_테스트() {
        //when, then
        assertThatThrownBy(() -> new GameNumbers(List.of(1, 2, 10)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 있다면 예외가 발생해야 한다.")
    @Test
    void 숫자_중복_예외_테스트() {
        //when, then
        assertThatThrownBy(() -> new GameNumbers(List.of(1, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
