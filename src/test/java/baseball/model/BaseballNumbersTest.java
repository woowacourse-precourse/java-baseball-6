package baseball.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class BaseballNumbersTest {
    @Test
    public void 볼_개수_테스트() {
        // given
        BaseballNumbers com = BaseballNumbers.playerNumbers("123");
        BaseballNumbers me = BaseballNumbers.playerNumbers("345");

        // when
        int ballCnt = com.countBall(me);

        // then
        Assertions.assertThat(ballCnt).isEqualTo(1);
    }

    @Test
    public void 스트라이크_개수_테스트() {
        // given
        BaseballNumbers com = BaseballNumbers.playerNumbers("123");
        BaseballNumbers me = BaseballNumbers.playerNumbers("145");

        // when
        int strikeCnt = com.countStrike(me);

        // then
        Assertions.assertThat(strikeCnt).isEqualTo(1);
    }
}