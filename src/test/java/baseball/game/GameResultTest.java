package baseball.game;

import baseball.ball.Result;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class GameResultTest {
    @Test
    @DisplayName("점수 더하기 성공")
    void testPlusScore() {
        GameResult gameResult = new GameResult();

        gameResult.plusScore(Result.BALL);
        gameResult.plusScore(Result.BALL);
        gameResult.plusScore(Result.BALL);

        int ballSize = gameResult.getBallCount();
        assertThat(ballSize).isEqualTo(3);
    }
}
