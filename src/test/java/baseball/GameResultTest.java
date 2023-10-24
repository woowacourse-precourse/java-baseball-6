package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.BallScore;
import baseball.domain.GameResult;
import org.junit.jupiter.api.Test;

public class GameResultTest {
    @Test
    void 결과_저장_테스트_1STRIKE() {
        GameResult gameResult = new GameResult();
        gameResult.saveResult(BallScore.STRIKE);
        assertThat(gameResult.getResult(BallScore.STRIKE)).isEqualTo(1);
        assertThat(gameResult.getResult(BallScore.BALL)).isEqualTo(0);
    }

    @Test
    void 결과_저장_테스트_1BALL() {
        GameResult gameResult = new GameResult();
        gameResult.saveResult(BallScore.BALL);
        assertThat(gameResult.getResult(BallScore.STRIKE)).isEqualTo(0);
        assertThat(gameResult.getResult(BallScore.BALL)).isEqualTo(1);
    }
}
