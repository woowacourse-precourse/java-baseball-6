package baseball.domain;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallTest {

    @Test
    void Ball생성() {
        Ball ball = new Ball(new Position(1),new BallNumber(2));
        assertThat(ball).isEqualTo(new Ball(new Position(1), new BallNumber(2)));
    }

    @Test
    void Ball_Ball_비교_STRIKE반환() {
        Ball computerBall = new Ball(new Position(1),new BallNumber(2));
        Ball playerBall = new Ball(new Position(1),new BallNumber(2));
        assertThat(computerBall.play(playerBall)).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void Ball_Ball_비교_BALL반환() {
        Ball computerBall = new Ball(new Position(1), new BallNumber(2));
        Ball playerBall = new Ball(new Position(2), new BallNumber(2));
        assertThat(computerBall.play(playerBall)).isEqualTo(BallStatus.BALL);
    }

    @Test
    void Ball_Ball_비교_NOTHING반환() {
        Ball computerBall = new Ball(new Position(1), new BallNumber(2));
        Ball playerBall = new Ball(new Position(2), new BallNumber(3));
        assertThat(computerBall.play(playerBall)).isEqualTo(BallStatus.NOTHING);
    }
}