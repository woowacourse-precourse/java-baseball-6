package baseball.utils;

import static baseball.utils.BaseballGameReaderUtils.convertPlayerTargetNums;
import static baseball.utils.BaseballGameReaderUtils.isNewGameStarted;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
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

    @Test
    public void convertPlayerTargetNums_validated() {
        // given
        String input = "123";

        // when
        List<Integer> playerTargetNums = convertPlayerTargetNums(input);

        // then
        assertEquals(playerTargetNums.size(), 3);
        assertEquals(playerTargetNums.get(0), 1);
        assertEquals(playerTargetNums.get(1), 2);
        assertEquals(playerTargetNums.get(2), 3);
    }

    @Test
    public void convertPlayerTargetNums_notNumber_throw() {
        // given
        String input = "1a3";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> convertPlayerTargetNums(input));
    }

    @Test
    public void convertPlayerTargetNums_duplication_throw() {
        // given
        String input = "133";

        // when & then
        assertThrows(IllegalArgumentException.class, () -> convertPlayerTargetNums(input));
    }
}