package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.game.BallStrikeCount;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BallStrikeCountTest {

    private BallStrikeCount ballStrikeCount;

    @BeforeEach
    public void setUp() {
        ballStrikeCount = new BallStrikeCount();
    }

    @Test
    @DisplayName("볼 카운트 증가 테스트")
    public void testIncreaseBall() {
        ballStrikeCount.increaseBall();
        assertEquals(1, ballStrikeCount.getBallCount());
    }

    @Test
    @DisplayName("스트라이크 카운트 증가 테스트")
    public void testIncreaseStrike() {
        ballStrikeCount.increaseStrike();
        assertEquals(1, ballStrikeCount.getStrikeCount());
    }
}
