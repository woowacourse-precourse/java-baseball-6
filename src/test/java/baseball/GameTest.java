package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameTest {

    @Test
    @DisplayName("올바른 입력_서로 다른 3자리 수")
    void setInputTest() {
        Game game = new Game();
        List<Integer> inputNum = game.getIntegerInput("123");
        assertThat(inputNum).containsExactly(1, 2, 3);
    }
}