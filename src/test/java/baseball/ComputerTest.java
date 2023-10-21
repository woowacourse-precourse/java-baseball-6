package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    void 정답_생성_테스트() {
        // given

        // when
        Computer computer = new Computer();

        // then
        Assertions.assertThat(computer.getAnswer()).hasSize(3);
    }

}
