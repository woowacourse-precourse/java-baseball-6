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
    private GuessNumbers guessNumbers;
    private GameStateNumber gameStateNumber;

    private static final Integer RESTART = 1;
    private static final Integer EXIT = 2;

    @BeforeEach
    void init() {
        guessNumbers = new GuessNumbers();
        gameStateNumber = new GameStateNumber();
        player = new Player(guessNumbers, gameStateNumber);
    }

    @Test
    @DisplayName("플레이어가 입력한 숫자게임의 값은 GuessNumbers에 저장되어야 한다.")
    void getGuessNumbers_Test() throws Exception {
        // given
        List<GuessNumber> playerInput = List.of(new GuessNumber(1), new GuessNumber(2), new GuessNumber(3));

        // when
        setPlayerInput(playerInput);

        // then
        assertEquals(player.getGuessNumbers().size(), 3);
        assertEquals(player.getGuessNumbers(), playerInput);
    }

    @Test
    @DisplayName("재시작/종료여부에 대한 입력값이 1인 경우 게임을 계속 진행한다.")
    void gameState_RESTART_Test() throws Exception {
        // when
        setGameState(RESTART);

        // then
        assertTrue(player.continueGame());
    }

    @Test
    @DisplayName("재시작/종료여부에 대한 입력값이 2인 경우 게임을 종료한다.")
    void gameState_EXIT_Test() throws Exception {
        // when
        setGameState(EXIT);

        // then
        assertFalse(player.continueGame());
    }

    private void setPlayerInput(List<GuessNumber> playerInput) throws NoSuchFieldException, IllegalAccessException {
        Field numbers = guessNumbers.getClass().getDeclaredField("numbers");
        numbers.setAccessible(true);
        numbers.set(guessNumbers, playerInput);
    }

    private void setGameState(Integer state) throws NoSuchFieldException, IllegalAccessException {
        Field stateNumber = gameStateNumber.getClass().getDeclaredField("stateNumber");
        stateNumber.setAccessible(true);
        stateNumber.set(gameStateNumber, state);
    }
}