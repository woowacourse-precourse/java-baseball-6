package baseball.model.player;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.lang.reflect.Field;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class PlayerTest {

    private Player player;
    private GuessNumber guessNumber;
    private GameStateNumber gameStateNumber;

    @BeforeEach
    void setUp() {
        guessNumber = new GuessNumber();
        gameStateNumber = new GameStateNumber();
        player = new Player(guessNumber, gameStateNumber);
    }

    @Test
    @DisplayName("재시작/종료여부 입력값이 1이면 게임을 계속 진행한다.")
    void continueGame_Test() throws Exception {
        // when
        Field stateNumber = gameStateNumber.getClass().getDeclaredField("stateNumber");
        stateNumber.setAccessible(true);
        stateNumber.set(gameStateNumber, 2);

        // then
        assertTrue(player.continueGame());
    }

}