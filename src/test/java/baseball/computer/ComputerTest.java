package baseball.computer;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @Test
    void 컴퓨터_랜덤숫자_생성() {
        Computer computer = new Computer();
        List<Integer> randomNum = computer.generate();

        assertThat(3).isEqualTo(randomNum.size());
    }
}
