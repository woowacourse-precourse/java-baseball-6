package baseball.model;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BallTest {

    @ParameterizedTest
    @CsvSource(value = {"0,1,0,2,NOTHING", "0,1,0,1,STRIKE", "0,1,1,1,BALL"})
    void 공은_다른공과_비교할_수있다(int pos1, int ballNo1, int pos2, int ballNo2, String ballStatusString) {
        Ball ball_self = new Ball(pos1, ballNo1);
        Ball ball_others = new Ball(pos2, ballNo2);

        BallStatus ballStatus = ball_self.compareBall(ball_others);

        assertThat(ballStatus).isEqualTo(BallStatus.valueOf(ballStatusString));
        assertThat(ball_others.compareBall(ball_self)).isEqualTo(ballStatus);
    }
}