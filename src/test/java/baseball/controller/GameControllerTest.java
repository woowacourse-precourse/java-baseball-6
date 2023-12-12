//package baseball.controller;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//import baseball.domain.entity.game.GameStatus;
//import baseball.domain.TestRandomCreator;
//import baseball.service.GameServiceImpl;
//import java.util.Arrays;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//@DisplayName("GameController 클래스")
//class GameControllerTest {
//
//    @BeforeEach
//    void setup() {
//        gameServiceImpl = new GameServiceImpl(new TestRandomCreator());
//        gameController.initializeGame();
//    }
//
//    @Test
//    void 스트라이크_세_개일_때_게임_종료_상태를_반환() {
//        GameStatus gameStatus = gameController.playGameRound(Arrays.asList(1, 2, 3));
//
//        assertEquals(GameStatus.END, gameStatus);
//    }
//
//    @Test
//    void 스트라이크_세_개가_아닐_때_게임_지속_상태를_반환() {
//        GameStatus gameStatus = gameController.playGameRound(Arrays.asList(1, 2, 7));
//
//        assertEquals(GameStatus.CONTINUE, gameStatus);
//    }
//
//    @Test
//    void 사용자가_잘못된_입력을_했을_때_예외_발생() {
//        assertThrows(IllegalArgumentException.class,
//            () -> gameController.playGameRound(Arrays.asList(0, 2, 7)));
//    }
//}