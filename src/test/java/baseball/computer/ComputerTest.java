package baseball.computer;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @DisplayName("길이가 3인 숫자가 생성된다.")
    @Test
    void generateNumbers() {
        Computer computer = new Computer();

        List<Integer> gameNumbers = computer.getGameNumbers();

        assertThat(gameNumbers).hasSize(3);
    }
}
