package baseball.judgement;

import baseball.computer.judgement.Ball;
import baseball.computer.judgement.BallJudgement;
import baseball.computer.judgement.BallStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class BallJudgementTest {
    BallJudgement ballJudgement;

    @BeforeEach
    void setUp() {
        ballJudgement = new BallJudgement(List.of(1, 2, 3));
    }

    @Test
    void strike(){
        Ball ball = new Ball(1, 1);
        BallStatus ballStatus = ballJudgement.judgeBall(ball);

        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void ball(){
        Ball ball = new Ball(2, 1);
        BallStatus ballStatus = ballJudgement.judgeBall(ball);

        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void nothing(){
        Ball ball = new Ball(4, 1);
        BallStatus ballStatus = ballJudgement.judgeBall(ball);

        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }
}