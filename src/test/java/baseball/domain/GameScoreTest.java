package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.domain.scoringnumbers.Balls;
import baseball.domain.scoringnumbers.Strikes;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameScoreTest {

    @DisplayName("스트라이크 개수가 제대로 저장됐는지 확인")
    @Test
    void StrikesIsCorrectlySaved() {
        GameScore gameScore = new GameScore(new Strikes(3), new Balls(0));

        assertEquals(gameScore.numberOfStrikes.get(), 3);
    }

    @DisplayName("볼 개수가 제대로 저장됐는지 확인")
    @Test
    void BallsISCorrectlySaved() {
        GameScore gameScore = new GameScore(new Strikes(0), new Balls(3));

        assertEquals(gameScore.numberOfBalls.get(), 3);
    }
}
