package baseball.util;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class BaseballUtilTest {

    final BaseballUtil baseballUtil = BaseballUtil.of();
    @Test
    @DisplayName("ball 갯수 확인하기")
    public void checkBallCount() throws Exception {
        // given
        List<Integer> player = new ArrayList<>(List.of(3, 2, 1));
        List<Integer> computer = new ArrayList<>(List.of(1, 2, 3));

        // when
        int ball = baseballUtil.getBallCount(computer, player);

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
        int strike = baseballUtil.getStrikeCount(computer, player);

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
        int ball = baseballUtil.getBallCount(computer, player);
        int strike = baseballUtil.getStrikeCount(computer, player);
        baseballUtil.getBaseballCount(computer, player);

        // then
        Assertions.assertThat(ball + "볼 " + strike + "스트라이크").isEqualTo("2볼 1스트라이크");
    }
}
