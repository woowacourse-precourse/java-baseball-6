package baseball.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.domain.GameResult;
import java.util.List;
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
    void isGameOverFail() {
        GameResult gameResult1 = new GameResult(1, 2);
        GameResult gameResult2 = new GameResult(0, 2);
        GameResult gameResult3 = new GameResult(2, 0);
        assertFalse(gameService.isGameOver(gameResult1));
        assertFalse(gameService.isGameOver(gameResult2));
        assertFalse(gameService.isGameOver(gameResult3));
    }

    @Test
    @DisplayName("숫자 게임 매치 결과 정상일 때 확인")
    void checkResultSuccess() {
        List<Integer> player = List.of(1, 2, 3);
        List<Integer> computer = List.of(1, 2, 3);
        GameResult gameResult = gameService.checkResult(player, computer);
        GameResult mockGameResult = new GameResult(3, 0);

        assertEquals(gameResult.strike(), mockGameResult.strike());
        assertEquals(gameResult.ball(), mockGameResult.ball());
    }

    @Test
    @DisplayName("플레이어 로부터 잘못된 값이 넘어왔을 때 오류처리")
    void checkResultThrowException() {
        List<Integer> player = List.of(1, 2, 3, 4);
        List<Integer> computer = List.of(1, 2, 3);
        assertThrows(IllegalArgumentException.class, () -> {
            gameService.checkResult(player, computer);
        });

    }


}