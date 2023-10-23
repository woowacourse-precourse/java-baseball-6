package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.GameResult;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class GameServiceTest {
    GameService gameService = new GameService();
    @Test
    @DisplayName("Game Over 정상인 경우 테스트")
    void isGameOverSuccess() {
        GameResult gameResult = new GameResult(3, 0);
        assertTrue(gameService.isGameOver(gameResult));
    }

    @Test
    @DisplayName("Game Over 정상이 아닌 경우 테스트")
    void isGameOverFail(){
        GameResult gameResult1 = new GameResult(1, 2);
        GameResult gameResult2 = new GameResult(0, 2);
        GameResult gameResult3 = new GameResult(2, 0);
        assertFalse(gameService.isGameOver(gameResult1));
        assertFalse(gameService.isGameOver(gameResult2));
        assertFalse(gameService.isGameOver(gameResult3));
    }

//    @Test
//    void checkResult() {
//    }
}