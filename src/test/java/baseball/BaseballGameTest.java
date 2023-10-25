package baseball;

import static baseball.BallsTest.DEFAULT_BALLS_123;
import static baseball.domain.Retry.QUIT;
import static baseball.domain.Retry.RETRY;
import static baseball.domain.TryResult.BALL;
import static baseball.domain.TryResult.STRIKE;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.Balls;
import baseball.domain.BaseballGame;
import baseball.domain.GameResult;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {

    @Test
    void init은_객체를_PLAYING상태로_초기화한다() {
        Balls answerBall = Balls.from(DEFAULT_BALLS_123);
        assertNotNull(BaseballGame.init(answerBall));
    }

    @Test
    void checkGameWin은_3스트라이크면_게임상태를_WIN으로_바꾼다() {
        BaseballGame baseballGame = BaseballGame.init(Balls.from(DEFAULT_BALLS_123));
        GameResult gameresult = GameResult.from(List.of(STRIKE, STRIKE,STRIKE));
        baseballGame.checkGameWin(gameresult);
        assertTrue(baseballGame.isWin());
    }
    @Test
    void checkGameWin은_3스트라이크가_아니면_게임상태를_PLAYING_그대로둔다() {
        BaseballGame baseballGame = BaseballGame.init(Balls.from(DEFAULT_BALLS_123));
        GameResult gameresult = GameResult.from(List.of(STRIKE, BALL, STRIKE));
        baseballGame.checkGameWin(gameresult);
        assertTrue(baseballGame.isPlaying());
    }

    @Test
    void retry는_quit가_들어오면_게임상태를_END로_바꾼다() {
        BaseballGame baseballGame = BaseballGame.init(Balls.from(DEFAULT_BALLS_123));
        baseballGame.retry(QUIT);
        assertTrue(baseballGame.isEnd());
    }
    @Test
    void retry는_retry가_들어오면_게임상태를_PLAYING_그대로둔다() {
        BaseballGame baseballGame = BaseballGame.init(Balls.from(DEFAULT_BALLS_123));
        baseballGame.retry(RETRY);
        assertTrue(baseballGame.isPlaying());
    }
}
