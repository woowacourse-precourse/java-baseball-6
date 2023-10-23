package process;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameTest {
    final BaseballProcess baseballProcess = BaseballProcess.of();
    final List<Integer> computer = new ArrayList<>(List.of(1, 2, 3));

    @Test
    @DisplayName("ball 갯수 확인하기")
    public void checkBallCount() throws Exception {
        // given
        List<Integer> player = new ArrayList<>(List.of(3, 2, 1));

        // when
        int ball = baseballProcess.accountBall(computer, player);

        // then
        Assertions.assertThat(ball).isEqualTo(2);
    }

    @Test
    @DisplayName("strike 갯수 확인하기")
    public void checkStrikeCount() throws Exception {
        // given
        List<Integer> player = new ArrayList<>(List.of(1, 2, 4));

        // when
        int strike = baseballProcess.accountStrike(computer, player);

        // then
        Assertions.assertThat(strike).isEqualTo(2);
    }

    @Test
    @DisplayName("정답을 맞췄을 경우")
    public void checkAnswer() throws Exception {
        // given
        List<Integer> player = new ArrayList<>(List.of(1, 2, 3));

        // when
        String result = baseballProcess.getCount(computer, player);

        // then
        Assertions.assertThat(result).isEqualTo("3스트라이크");
    }
}
