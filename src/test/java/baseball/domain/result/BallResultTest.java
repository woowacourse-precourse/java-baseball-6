package baseball.domain.result;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BallResultTest {

    @Test
    @DisplayName("우선순위가 높은 결과값과 낮은 결과값을 비교하면 1이 나온다")
    void ballResultCompareTest1() {
        BallResult ballResult1 = BallResult.STRIKE;
        BallResult ballResult2 = BallResult.BALL;
        Assertions.assertThat(ballResult1.compare(ballResult2)).isEqualTo(1);
    }

    @Test
    @DisplayName("우선순위가 낮은 결과값과 높은 결과값을 비교하면 -1이 나온다")
    void ballResultCompareTest2() {
        BallResult ballResult1 = BallResult.NOTHING;
        BallResult ballResult2 = BallResult.STRIKE;
        Assertions.assertThat(ballResult1.compare(ballResult2)).isEqualTo(-1);
    }

    @Test
    @DisplayName("우선순위가 같은 결과값을 비교하면 0이 나온다")
    void ballResultCompareTest3() {
        BallResult ballResult1 = BallResult.BALL;
        BallResult ballResult2 = BallResult.BALL;
        Assertions.assertThat(ballResult1.compare(ballResult2)).isEqualTo(0);
    }
}