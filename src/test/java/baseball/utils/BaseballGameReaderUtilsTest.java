package baseball.utils;

import static baseball.utils.BaseballGameReaderUtils.isNewGameStarted;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballGameReaderUtilsTest {

    @Test
    public void isNewGameStarted_validatedAndStart_true() {
        // given
        String answer = "1";

        // when
        boolean newGameStarted = isNewGameStarted(answer);

        //then
        assertTrue(newGameStarted);
    }

    @Test
    public void isNewGameStarted_validatedAndEnd_false() {
        // given
        String answer = "2";

        // when
        boolean newGameStarted = isNewGameStarted(answer);

        //then
        assertFalse(newGameStarted);
    }

    @Test
    public void isNewGameStarted_notValidated_throw() {
        // given
        String answer = "";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> isNewGameStarted(answer));
    }

    @Test
    public void isNewGameStarted_unavailable_throw() {
        // given
        String answer = "3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> isNewGameStarted(answer));
    }
}