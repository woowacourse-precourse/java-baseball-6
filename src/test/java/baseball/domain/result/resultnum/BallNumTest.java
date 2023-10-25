package baseball.domain.result.resultnum;

import baseball.domain.result.BallResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Optional;

class BallNumTest {

    @Test
    @DisplayName("BALL 결과를 업데이트 하면 1 볼을 가진 새로운 ResultNum 반환")
    void ballNumTest1() {
        BallNum ballNum = new BallNum();
        ResultNum updatedBallNum = ballNum.update(BallResult.BALL);
        Assertions.assertThat(updatedBallNum.getResult()).isEqualTo(Optional.of("1볼"));
    }

    @Test
    @DisplayName("STRIKE 결과를 업데이트 하면 0 볼을 가진 새로운 ResultNum 반환")
    void ballNumTest2() {
        BallNum ballNum = new BallNum();
        ResultNum updatedBallNum = ballNum.update(BallResult.STRIKE);
        Assertions.assertThat(updatedBallNum.getResult()).isEqualTo(Optional.empty());
    }

    @Test
    @DisplayName("NOTHING 결과를 업데이트 하면 0 볼을 가진 새로운 ResultNum 반환")
    void ballNumTest3() {
        BallNum ballNum = new BallNum();
        ResultNum updatedBallNum = ballNum.update(BallResult.NOTHING);
        Assertions.assertThat(updatedBallNum.getResult()).isEqualTo(Optional.empty());
    }
}