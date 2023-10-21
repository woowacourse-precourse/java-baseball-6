package baseball.utils;

import static baseball.utils.NewGameStartFlag.getNewGameStart;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NewGameStartFlagTest {

    @Test
    public void getNewGameStart_1_START() {
        // when
        NewGameStartFlag newGameStart = getNewGameStart(1);

        // then
        assertEquals(newGameStart, NewGameStartFlag.START);
    }

    @Test
    public void getNewGameStart_2_END() {
        // when
        NewGameStartFlag newGameStart = getNewGameStart(2);

        // then
        assertEquals(newGameStart, NewGameStartFlag.END);
    }

    @Test
    public void getNewGameStart_not1and2_UNAVAILABLE() {
        // when
        NewGameStartFlag newGameStart1 = getNewGameStart(3);
        NewGameStartFlag newGameStart2 = getNewGameStart(9);

        // then
        assertEquals(newGameStart1, NewGameStartFlag.UNAVAILABLE);
        assertEquals(newGameStart2, NewGameStartFlag.UNAVAILABLE);
    }
}