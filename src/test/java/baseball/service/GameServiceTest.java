package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import baseball.domain.GameStatus;
import baseball.domain.TestRandomCreator;
import baseball.response.GameResponse;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("GameService 클래스")
class GameServiceTest {

    private GameService gameService;

    @BeforeEach
    void setup() {
        gameService = new GameService(new TestRandomCreator());
        gameService.initializeGame();
    }

    @Test
    void 세_개의_숫자를_맞히면_게임_종료() {
        List<Integer> userInput = Arrays.asList(1, 2, 3);
        GameResponse response = gameService.playGame(userInput);

        assertEquals(GameStatus.END, response.getGameStatus());
    }

}