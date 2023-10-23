package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class BallsTest {

    @Test
    void 공들은_다른_한개의_공에대한_결과를_알수있다_볼() {
        Balls balls = Balls.createBalls(List.of(1, 2, 3));
        Ball ball = new Ball(1, 3);

        BallStatus ballStatus = balls.compareBall(ball);

        assertThat(ballStatus).isEqualTo(BallStatus.BALL);
    }

    @Test
    void 공들은_다른_한개의_공에대한_결과를_알수있다_스트라이크() {
        Balls balls = Balls.createBalls(List.of(1, 2, 3));
        Ball ball = new Ball(1, 2);

        BallStatus ballStatus = balls.compareBall(ball);

        assertThat(ballStatus).isEqualTo(BallStatus.STRIKE);
    }

    @Test
    void 공들은_다른_한개의_공에대한_결과를_알수있다_낫싱() {
        Balls balls = Balls.createBalls(List.of(1, 2, 3));
        Ball ball = new Ball(0, 6);

        BallStatus ballStatus = balls.compareBall(ball);

        assertThat(ballStatus).isEqualTo(BallStatus.NOTHING);
    }

    @Test
    void 공들은_다른_공들에_대한_게임결과를_알수있다_낫싱() {
        Balls balls_self = Balls.createBalls(List.of(1, 2, 3));
        Balls balls_others = Balls.createBalls(List.of(4, 5, 6));

        GameResult gameResult = balls_self.compareBalls(balls_others);

        assertThat(gameResult.isNothing()).isTrue();
    }

    @Test
    void 공들은_다른_공들에_대한_게임결과를_알수있다_3스트라이크() {
        Balls balls_self = Balls.createBalls(List.of(1, 2, 3));
        Balls balls_others = Balls.createBalls(List.of(1, 2, 3));

        GameResult gameResult = balls_self.compareBalls(balls_others);

        assertThat(gameResult.isAnswer(3)).isTrue();
        assertThat(gameResult.getStrikeCount()).isEqualTo(3);
        assertThat(gameResult.getBallCount()).isEqualTo(0);
    }

    @Test
    void 공들은_다른_공들에_대한_게임결과를_알수있다_1볼() {
        Balls balls_self = Balls.createBalls(List.of(1, 2, 3));
        Balls balls_others = Balls.createBalls(List.of(4, 5, 2));

        GameResult gameResult = balls_self.compareBalls(balls_others);

        assertThat(gameResult.getBallCount()).isEqualTo(1);
        assertThat(gameResult.getStrikeCount()).isEqualTo(0);
    }

    @Test
    void 공들은_다른_공들에_대한_게임결과를_알수있다_1스트라이크() {
        Balls balls_self = Balls.createBalls(List.of(1, 2, 3));
        Balls balls_others = Balls.createBalls(List.of(4, 5, 3));

        GameResult gameResult = balls_self.compareBalls(balls_others);

        assertThat(gameResult.getBallCount()).isEqualTo(0);
        assertThat(gameResult.getStrikeCount()).isEqualTo(1);
    }
}
