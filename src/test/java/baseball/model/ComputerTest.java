package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    void createComputerTest() {
        Computer computer = new Computer();

        Assertions.assertThat(computer.getRandomNumber().size()).isEqualTo(3);
    }
}
