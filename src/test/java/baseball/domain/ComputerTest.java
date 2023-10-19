package baseball.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

public class ComputerTest {
    @Test
    @DisplayName("Computer는 서로 다른 임의의 3자리 수를 관리하는 Baseball(Modifiable)을 가진다")
    void init() {
        // when
        final Computer computer = Computer.init();

        // then
        assertAll(
                () -> assertThat(computer.getBaseball()).hasSize(3), // size
                () -> assertThat(
                        computer.getBaseball()
                                .stream()
                                .distinct()
                                .toList()
                ).hasSize(3) // has duplicate
        );
    }

    @Test
    @DisplayName("게임 재시작을 진행할 경우 Computer의 Baseball을 초기화된다")
    void reset() {
        // given
        final Computer computer = Computer.init();
        final List<Integer> previousBaseball = computer.getBaseball();
        assertThat(computer.getBaseball()).isEqualTo(previousBaseball); // contains same elements as before

        // when
        computer.reset();

        // then
        assertAll(
                () -> assertThat(computer.getBaseball()).hasSize(3), // size
                () -> assertThat(
                        computer.getBaseball()
                                .stream()
                                .distinct()
                                .toList()
                ).hasSize(3), // has duplicate,
                () -> assertThat(computer.getBaseball()).isNotEqualTo(previousBaseball) // not contains same elements as before
        );
    }
}
