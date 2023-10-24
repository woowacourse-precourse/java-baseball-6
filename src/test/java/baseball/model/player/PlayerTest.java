package baseball.model.player;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Player player;
    private GuessNumber guessNumber;
    private GameStateNumber gameStateNumber;

    private static final Integer RESTART = 1;
    private static final Integer EXIT = 2;

    @BeforeEach
    void init() {
        guessNumber = new GuessNumber();
        gameStateNumber = new GameStateNumber();
        player = new Player(guessNumber, gameStateNumber);
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자게임의 값은 guessNumber에 저장된다.")
    void getGuessNumbers_Test() throws Exception {
        // given
        List<Integer> inputNumbers = List.of(1, 2, 3);
        setGuessNumber(List.of(1, 2, 3));

        // then
        assertEquals(player.getGuessNumbers().size(), 3);
        assertEquals(player.getGuessNumbers(), inputNumbers);
    }

    @Test
    @DisplayName("재시작/종료여부 입력값이 1이면 게임을 계속 진행한다.")
    void gameState_RESTART_Test() throws Exception {
        // when
        setGameState(RESTART);

        // then
        assertTrue(player.continueGame());
    }

    @Test
    @DisplayName("재시작/종료 여부 입력값이 2이면 게임을 종료한다.")
    void gameState_EXIT_Test() throws Exception {
        // when
        setGameState(EXIT);

        // then
        assertFalse(player.continueGame());
    }

    private void setGuessNumber(List<Integer> guess) throws NoSuchFieldException, IllegalAccessException {
        Field numbers = guessNumber.getClass().getDeclaredField("numbers");
        numbers.setAccessible(true);
        numbers.set(guessNumber, guess);
    }

    private void setGameState(Integer state) throws NoSuchFieldException, IllegalAccessException {
        Field stateNumber = gameStateNumber.getClass().getDeclaredField("stateNumber");
        stateNumber.setAccessible(true);
        stateNumber.set(gameStateNumber, state);
    }
}