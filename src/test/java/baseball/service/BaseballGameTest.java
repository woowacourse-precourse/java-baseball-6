package baseball.service;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseballGameTest {

    @Test
    public void initBaseballGameNumbers_baseballGameNumbersSize_3() {
        // given
        BaseballGame baseballGame = new BaseballGame();

        // then
        assertEquals(baseballGame.getBaseballGameNumbersSize(), 3);
    }
}