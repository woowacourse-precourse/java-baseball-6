package baseball;

import baseball.model.Ball;
import baseball.model.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BallTest {
    private Game game;
    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void 같은_숫자_같은_자리_STRIKE_판정() {
        Ball playerBall = new Ball(1, 1);
        Ball computerBall = new Ball(1, 1);

        GameResult result = game.compareBalls(playerBall, computerBall);

        Assertions.assertThat(result).isEqualTo(GameResult.STRIKE);
    }

    @Test
    void 같은_숫자_다른_자리_BALL_판정() {
        Ball playerBall = new Ball(1, 1);
        Ball computerBall = new Ball(2, 1);

        GameResult result = game.compareBalls(playerBall, computerBall);

        Assertions.assertThat(result).isEqualTo(GameResult.BALL);
    }

    @Test
    void 다른_숫자_다른_자리_NOTHING_판정() {
        Ball playerBall = new Ball(1, 1);
        Ball computerBall = new Ball(2, 2);

        GameResult result = game.compareBalls(playerBall, computerBall);

        Assertions.assertThat(result).isEqualTo(GameResult.NOTHING);
    }
}
