package baseball.model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.BaseballScoreMessage;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    @DisplayName("2스트라이크 1볼일 경우")
    void testToStringWithBothStrikeAndBall() {
        GameResult gameResult = new GameResult(2, 1);
        String result = gameResult.toString();
        assertEquals(BaseballScoreMessage.BALL.getMessageWithCount(1) + " "
                + BaseballScoreMessage.STRIKE.getMessageWithCount(2), result);
    }

    @Test
    @DisplayName("2스트라이크일 경우")
    void testToStringWithOnlyStrike() {
        GameResult gameResult = new GameResult(2, 0);
        String result = gameResult.toString();
        assertEquals(BaseballScoreMessage.STRIKE.getMessageWithCount(2), result);
    }

    @Test
    @DisplayName("2볼일 경우")
    void testToStringWithOnlyBall() {
        GameResult gameResult = new GameResult(0, 2);
        String result = gameResult.toString();
        assertEquals(BaseballScoreMessage.BALL.getMessageWithCount(2), result);
    }

    @Test
    @DisplayName("0스트라이트 0볼일 경우")
    void testToStringWithNeitherStrikeNorBall() {
        GameResult gameResult = new GameResult(0, 0);
        String result = gameResult.toString();
        assertEquals(BaseballScoreMessage.NOTHING.toString(), result);
    }


}