package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class BallsTest {

    @Test
    void 컴퓨터Balls_유저Ball_STRIKE() {
        List<Integer> ballNumbers = Arrays.asList(3, 2, 4);
        Balls balls = new Balls(ballNumbers);
        assertThat(balls.match(new Ball(new Position(3), new BallNum(4)))).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 컴퓨터Balls_유저Ball_BALL() {
        List<Integer> ballNumbers = Arrays.asList(3, 2, 4);
        Balls balls = new Balls(ballNumbers);
        assertThat(balls.match(new Ball(new Position(2), new BallNum(4)))).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 컴퓨터Balls_유저Ball_NOTHING() {
        List<Integer> ballNumbers = Arrays.asList(3, 2, 4);
        Balls balls = new Balls(ballNumbers);
        assertThat(balls.match(new Ball(new Position(1), new BallNum(1)))).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 컴퓨터Balls_유저Balls_반환값() {
        List<Integer> computerBallNumbers = Arrays.asList(3, 1, 2);
        List<Integer> playerBallNumbers = Arrays.asList(3, 2, 4);
        Balls balls = new Balls(computerBallNumbers);
        Balls playerBalls = BallsFactory.createPlayerBalls(playerBallNumbers);
        List<BallStatus> result = balls.play(playerBalls);
        assertThat(result.get(0)).isEqualTo(BallStatus.STRIKE);
        assertThat(result.get(1)).isEqualTo(BallStatus.BALL);
        assertThat(result.get(2)).isEqualTo(BallStatus.NOTHING);
    }

}
