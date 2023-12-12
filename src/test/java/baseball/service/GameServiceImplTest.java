//package baseball.service;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import baseball.domain.entity.game.GameStatus;
//import baseball.domain.TestRandomCreator;
//import baseball.domain.dto.GameResponse;
//import java.util.Arrays;
//import java.util.List;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//@DisplayName("GameServiceImpl 클래스")
//class GameServiceImplTest {
//
//    private GameServiceImpl gameServiceImpl;
//
//    @BeforeEach
//    void setup() {
//        gameServiceImpl = new GameServiceImpl(new TestRandomCreator());
//        gameServiceImpl.initializeGame();
//    }
//
//    @Test
//    void 세_개의_숫자를_맞히면_게임_종료() {
//        List<Integer> userInput = Arrays.asList(1, 2, 3);
//        GameResponse response = gameServiceImpl.playGame(userInput);
//
//        assertEquals(GameStatus.OVER, response.getGameStatus());
//    }
//
//    @Test
//    void 세_개의_숫자를_맞히지_못_하면_게임_진행() {
//        List<Integer> userInput = Arrays.asList(1, 2, 5);
//        GameResponse response = gameServiceImpl.playGame(userInput);
//
//        assertEquals(GameStatus.CONTINUE, response.getGameStatus());
//    }
//
//}