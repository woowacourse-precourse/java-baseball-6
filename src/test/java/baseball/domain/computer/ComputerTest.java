package baseball.domain.computer;

import baseball.domain.player.Player;
import baseball.exception.computer.ComputerEndStateRefreshException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.assertAll;

class ComputerTest {
    @RepeatedTest(10)
    @DisplayName("3개의 answerNumbers를 가진 Computer를 생성할 수 있다.")
    void createWithAnswerNumbersByRandomGenerater() {
        // when
        Computer result = Computer.init();
        // then
        assertThat(result).isInstanceOf(Computer.class);

    }
    @Nested
    @DisplayName("[Computer refresh 테스트]")
    class RefreshComputerTest {

        @Test
        @DisplayName("END 상태라면 Computer가 Refresh할 경우 Exception이 발생해야 한다.")
        void refreshExceptionByEndState() {
            // given
            Computer computer = Computer.from(Player.createPlayerByIntegerNumbers((Arrays.asList(1, 2, 3))), GameState.END);

            // when & then
            assertThatExceptionOfType(ComputerEndStateRefreshException.class)
                    .isThrownBy(() -> computer.refresh())
                    .withMessageMatching("종료된 게임은 리프레시할 수 없습니다.");
        }

        @Test
        @DisplayName("RESTART 상태라면 새로운 Computer를 반환해야 한다.")
        void refreshByRestartState() {
            // given
            Computer computer = Computer.from(Player.createPlayerByIntegerNumbers((Arrays.asList(1, 2, 3))), GameState.RESTART);

            // when
            Computer result = computer.refresh();

            // then
            assertAll(
                    () -> assertThat(result).isInstanceOf(Computer.class),
                    () -> assertThat(result).isNotEqualTo(computer)
            );
        }

        @Test
        @DisplayName("RUNNING 상태라면 그대로 현재 주소를 반환해야 한다.")
        void refreshByRunningState() {
            // given
            Computer input = Computer.from(Player.createPlayerByIntegerNumbers((Arrays.asList(1, 2, 3))), GameState.RUNNING);

            // when
            Computer result = input.refresh();

            // then
            assertThat(result).isSameAs(input);
        }
    }
}