package baseball.service;

import baseball.domain.Game;
import baseball.service.GameService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class GameServiceTest {
    private GameService gameService;

    @BeforeEach
    public void setUp() {
        gameService = new GameService(new Game());
    }

    @Test
    public void testPlayGameWin() {
        gameService.startNewGame();

        String userInput = "123";
        System.out.println("User Input: " + userInput); // 로깅 코드
        String result = gameService.playGame("123");

        assertEquals("3스트라이크\n3개의 숫자를 모두 맞히셨습니다! 게임 종료", result);
    }

    @Test
    public void testPlayGameStrikeAndBall() {
        gameService.startNewGame();

        // 1 스트라이크 1 볼일 때의 테스트
        String result = gameService.playGame("134");

        assertEquals("1스트라이크 1볼", result);
    }

    @Test
    public void testPlayGameNothing() {
        gameService.startNewGame();

        // 낫싱일 때의 테스트
        String result = gameService.playGame("789");

        assertEquals("낫싱", result);
    }
}
