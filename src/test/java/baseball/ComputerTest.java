package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Computer;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void 변수생성_후_문자열로_합쳐서_반환() {
        Computer computer = new Computer();
        computer.makeComputerRandomNumber();
        assertThat(computer.getComputerRandomNumber().length()).isEqualTo(3);
        System.out.println(computer.getComputerRandomNumber());
    }
}