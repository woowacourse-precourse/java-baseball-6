package baseball;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {

    @Test
    void numberLength() {
        Computer computer = new Computer();
        assertThat(computer.getNumberArray().length).isSameAs(3);
    }

    @Test
    void numbersValidate() {
        Computer computer = new Computer();
        int[] numberArray = computer.getNumberArray();
        assertThat(numberArray[0] != numberArray[1]).isTrue();
        assertThat(numberArray[0] != numberArray[2]).isTrue();
        assertThat(numberArray[1] != numberArray[2]).isTrue();
    }
}
