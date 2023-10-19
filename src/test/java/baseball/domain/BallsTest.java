package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class BallsTest {

    @Test
    @DisplayName("공들은 1부터 9까지 서로 다른 수로 이루어진 3개의 공으로 이루어져 있다.")
    void create() {
        List<Integer> numbers = List.of(1, 2, 3);
        Balls balls = new Balls(numbers);

        assertThat(balls).isEqualTo(new Balls(numbers));
    }

    @Test
    @DisplayName("공들의 총 개수가 3개가 아니라면 예외가 발생한다.")
    void invalidSize() {
        assertThatThrownBy(() -> new Balls(List.of(1, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공들은 3개의 공으로 이루어져야 합니다.");
    }

    @Test
    @DisplayName("공들의 숫자 중 중복되는 수가 있다면 예외가 발생한다.")
    void hasDuplicatedNumber() {
        assertThatThrownBy(() -> new Balls(List.of(1, 2, 2)))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("공들의 숫자는 중복될 수 없습니다.");
    }
}