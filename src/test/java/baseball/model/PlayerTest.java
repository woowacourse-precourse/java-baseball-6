package baseball.model;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    @DisplayName("플레이어 수가 3자리가 아닌 경우 예외가 발생한다.")
    @Test
    void makePlayerSizeEx() {
        Assertions.assertThatThrownBy(() -> new Player("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("플레이어 수에 같은 숫자가 있을 경우 예외가 발생한다.")
    @Test
    void makePlayerUniqueEx() {
        Assertions.assertThatThrownBy(() -> new Player("333"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("같은 숫자의 개수를 구한다.")
    @Test
    void countSameNumber() {
        Computer computer = new Computer(List.of(1, 2, 3));
        Player player = new Player("145");

        int count = player.countSameNumber(computer);

        Assertions.assertThat(count).isEqualTo(1);
    }

    @DisplayName("같은 위치에 있는 숫자의 개수를 구한다.")
    @Test
    void countSameIndex() {
        Computer computer = new Computer(List.of(1, 2, 3));
        Player player = new Player("123");

        int count = player.countSameIndex(computer);

        Assertions.assertThat(count).isEqualTo(3);
    }
}
