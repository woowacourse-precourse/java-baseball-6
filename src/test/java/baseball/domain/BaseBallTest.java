package baseball.domain;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseBallTest {

    @Test
    void getInstance() {
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(100));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(1111));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(121));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(1));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(12));
    }

    @Test
    void compareWithAnswer() {
        compare(124, false);
        compare(213, false);
        compare(567, false);
        compare(132, false);
        compare(123, true);
    }

    private void compare(int baseBallNumber, boolean expected) {
        int answer = 123;
        BaseBall answerBall = BaseBall.getInstance(answer);
        BaseBall baseBall = BaseBall.getInstance(baseBallNumber);
        BaseBallResult baseBallResult = baseBall.compareWithAnswer(answerBall);
        assertEquals(baseBallResult.isPerfectStrike(), expected);
    }
}