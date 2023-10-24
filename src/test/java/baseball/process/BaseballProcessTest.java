package baseball.process;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BaseballProcessTest {
    final BaseballProcess baseballProcess = BaseballProcess.of();

    @Test
    @DisplayName("3스트라이크가 결과로 나올 경우, 게임 종료")
    public void finshRoundTest() throws Exception {
        // given
        List<Integer> player = new ArrayList<>(List.of(2, 1, 3));
        List<Integer> computer = new ArrayList<>(List.of(2, 1, 3));

        // when
        boolean finish = baseballProcess.isContinue(computer, player);

        // then
        Assertions.assertThat(finish).isEqualTo(false);
    }

    @Test
    @DisplayName("재실행 여부에서 1을 입력했을 때")
    public void isRestartTrueTest() throws Exception {
        // when
        boolean restart = baseballProcess.isRestart(1);

        // then
        Assertions.assertThat(restart).isEqualTo(true);
    }

    @Test
    @DisplayName("재실행 여부에서 2를 입력했을 때")
    public void isRestartFalseTest() throws Exception {
        // when
        boolean restart = baseballProcess.isRestart(2);

        // then
        Assertions.assertThat(restart).isEqualTo(false);
    }

}
