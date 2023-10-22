package baseball.computer;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("길이가 3인 숫자가 생성된다.")
    @Test
    void generateNumbers() {
        Computer computer = new Computer();

        List<Integer> gameNumbers = computer.getGameNumbers();

        Assertions.assertThat(gameNumbers).hasSize(3);
    }
}
