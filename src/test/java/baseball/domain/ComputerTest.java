package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    void 컴퓨터_랜덤_변수는_세자리인가() {
        Computer computer = new Computer();
        assertThat(computer.getComputerNums().size() == 3);
    }

    @Test
    void 컴퓨터_랜덤_변수는_서로_다른가() {
        Computer computer = new Computer();
        List<Integer> randomNums = computer.getComputerNums();
        assertThat(randomNums.get(0) != randomNums.get(1)
                && randomNums.get(1) != randomNums.get(2));
    }

    @Test
    void 컴퓨터_랜덤_변수는_1이상_9이하인가() {
        Computer computer = new Computer();
        List<Integer> randomNums = computer.getComputerNums();
        assertThat(randomNums.stream().allMatch(v -> v >= 1 && v <= 9)).isTrue();
    }


}
