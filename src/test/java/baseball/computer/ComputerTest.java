package baseball.computer;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    Computer computer;
    GameNumbers answer;

    @BeforeEach
    void setComputer() {
        computer = new Computer();
        answer = computer.generateAnswer();
    }

    @DisplayName("정답은 임의의 3자리 수여야 한다.")
    @Test
    void 정답_자리수_테스트() {
        //then
        assertThat(answer.size()).isEqualTo(3);
    }
}
