package baseball.domain;

import baseball.domain.Game;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class GameTest {
    private Game game;

    @BeforeEach
    void setUp() {
        game = new Game();
    }

    @Test
    void testUpdateGameResultWithValidNumbers() {
        int[] userNumbers = {1, 2, 3}; // 유효한 숫자 배열
        game.updateGameResult(userNumbers);
        assertEquals(0, game.getStrikes());
        assertEquals(0, game.getBalls());
    }

    @Test
    void testResetGame() {
        game.updateGameResult(new int[]{1, 2, 3});
        game.resetGame();
        assertEquals(0, game.getStrikes());
        assertEquals(0, game.getBalls());
    }

//    @Test
//    public void testIsWinWithWinningGame() {
//        // 승리 조건: strikes = 3, balls = 0
//        Game game = new Game();
//        int[] userNumbers = {1, 2, 3}; // 임의의 사용자 숫자
//        game.updateGameResult(userNumbers);
//
//        assertTrue(game.isWin(), "게임 승리 여부를 확인합니다.");
//    }

    @Test
    void testIsWinWithNonWinningGame() {
        game.updateGameResult(new int[]{1, 2, 4}); // 비승리 상황 설정
        assertFalse(game.isWin());
    }

    @Test
    void testCalculateStrikesAndBallsWithInvalidNumbers() {
        int[] userNumbers = {2, 3}; // 잘못된 숫자 배열 (크기가 2)
        assertThrows(IllegalArgumentException.class, () -> game.updateGameResult(userNumbers));
    }

    @Test
    public void testIsWinWithLosingGame() {
        // 패배 조건: strikes != 3 또는 balls != 0
        Game game = new Game();
        int[] userNumbers = {1, 2, 5}; // 임의의 사용자 숫자
        game.updateGameResult(userNumbers);

        assertFalse(game.isWin(), "게임 승리 여부를 확인합니다.");
    }
//    @Test
//    public void testGameResults() {
//        Game game = new Game();
//        int[] userNumbers = {1, 2, 3};
//
//
//        // 예상 결과로 strikes와 balls 값을 설정
//        game.updateGameResult(userNumbers);
//
//        // strikes 및 balls 값을 확인
//        assertEquals(1, game.getStrikes()); // 예상하는 값으로 수정
//        assertEquals(2, game.getBalls()); // 예상하는 값으로 수정
//    }

}
