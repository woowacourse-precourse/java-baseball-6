package process;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BaseballGameTest {
    final BaseballProcess baseballProcess = BaseballProcess.of();

    @Test
    @DisplayName("ball 갯수 확인하기")
    public void checkBallCount() throws Exception {
        // given
        List<Integer> player = new ArrayList<>(List.of(3, 2, 1));
        List<Integer> computer = new ArrayList<>(List.of(1, 2, 3));

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
        List<Integer> computer = new ArrayList<>(List.of(1, 2, 3));

        // when
        int strike = baseballProcess.accountStrike(computer, player);

        // then
        Assertions.assertThat(strike).isEqualTo(2);
    }

    @Test
    @DisplayName("숫자 야구 게임 실행 후 결과 카운트")
    public void checkAnswer() throws Exception {
        // given
        List<Integer> player = new ArrayList<>(List.of(2, 1, 3));
        List<Integer> computer = new ArrayList<>(List.of(1, 2, 3));

        // when
        int ball = baseballProcess.accountBall(computer, player);
        int strike = baseballProcess.accountStrike(computer, player);

        // then
        Assertions.assertThat(ball + "볼 " + strike + "스트라이크").isEqualTo("2볼 1스트라이크");
    }

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
