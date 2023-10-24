package baseball.service;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import baseball.domain.Balls;
import org.junit.jupiter.api.Test;

public class GameServiceTest {

    @Test
    public void testCreateAnswerBalls() {
        GameService gameService = new GameService();
        Balls answerBalls = gameService.createAnswerBalls();
        assertNotNull(answerBalls);
    }

    @Test
    public void testGetPlayerBalls() {
        GameService gameService = new GameService();
        Balls playerBalls = gameService.getPlayerBalls();
        assertNotNull(playerBalls);
    }
}
