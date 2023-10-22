package baseball;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ResultTest {

    @Test
    void Three_스트라이크일_경우_true를_반환한다() {
        Result result = new Result(0, 3);

        boolean isThreeStrike = result.isThreeStrike();

        assertTrue(isThreeStrike);
    }

    @Test
    void Three_스트라이크가_아닐_경우_false를_반환한다() {
        Result result = new Result(2, 1);

        boolean isThreeStrike = result.isThreeStrike();

        assertFalse(isThreeStrike);
    }

}