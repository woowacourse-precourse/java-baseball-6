package baseball;

import baseball.domain.Computer;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
public class BaseballGameTest {
    @Test
    void 컴퓨터_랜덤숫자_생성(){
        Computer computer = new Computer();
        assertThat(computer.getRandomNumbers().size()).isEqualTo(3);
    }

}
