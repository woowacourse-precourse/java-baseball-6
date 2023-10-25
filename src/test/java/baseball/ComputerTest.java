package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {

    Computer computer = new Computer(3);

    @Test
    void randomNumsLengthTest() {
        List<Integer> randomNums = computer.getNums();
        assertThat(randomNums.size()).isEqualTo(3);
    }

    @Test
    void randomNumsDuplicateTest() {
        List<Integer> randomNums = computer.getNums();
        assertThat(randomNums.stream().distinct().count()).isEqualTo(3);
    }

    @Test
    void randomNumsRangeTest() {
        List<Integer> randomNums = computer.getNums();
        assertThat(randomNums.stream().filter(num -> num >= 1 && num <= 9).count()).isEqualTo(3);
    }
}