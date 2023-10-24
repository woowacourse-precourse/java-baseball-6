package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    @DisplayName("컴퓨터는 랜덤 값으로 Baseballs 을 생성하고 소유할 수 있다")
    public void createBaseballsTest() {
        // given
        Computer computer = new Computer();

        // when
        computer.createBaseballs();

        // then
        Assertions.assertThat(computer.getBaseballs()).isNotNull();
    }

}