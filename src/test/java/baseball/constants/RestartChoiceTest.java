package baseball.constants;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RestartChoiceTest {

    @Test
    void 유효한_선택지_테스트() {
        assertTrue(RestartChoice.isValidChoice("1"));
        assertTrue(RestartChoice.isValidChoice("2"));
    }

    @Test
    void 무효한_선택지_테스트() {
        assertFalse(RestartChoice.isValidChoice("3"));
        assertFalse(RestartChoice.isValidChoice("0"));
        assertFalse(RestartChoice.isValidChoice("a"));
    }

    @Test
    void matches_메서드_테스트() {
        assertTrue(RestartChoice.RESTART.matches("1"));
        assertFalse(RestartChoice.RESTART.matches("2"));

        assertTrue(RestartChoice.QUIT.matches("2"));
        assertFalse(RestartChoice.QUIT.matches("1"));
    }
}
