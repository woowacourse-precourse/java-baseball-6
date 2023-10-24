package baseball.model.player;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
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

    private void setGameState(Integer state) throws NoSuchFieldException, IllegalAccessException {
        Field stateNumber = gameStateNumber.getClass().getDeclaredField("stateNumber");
        stateNumber.setAccessible(true);
        stateNumber.set(gameStateNumber, state);
    }
}