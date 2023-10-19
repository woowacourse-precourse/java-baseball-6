package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ComputerTest {
    @Test
    @DisplayName("Computer는 서로 다른 임의의 3자리 수를 관리하는 Baseball(Unmodifiable)을 가진다")
    void init() {
        // when
        final Computer computer = Computer.init();

        // then
        assertThat(computer.getBaseball()).hasSize(3);
    }
}
