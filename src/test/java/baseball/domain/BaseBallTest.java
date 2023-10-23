package baseball.domain;

import static baseball.domain.BaseBallResultType.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BaseBallTest {

    @Test
    void getInstance() {
        for (int i = 0; i < 100000; i++) {
            int answer = AnswerGenerator.randomAnswer();
            BaseBall.getInstance(answer);
        }
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(102));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(111));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(121));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(1234));
        assertThrows(IllegalArgumentException.class, () -> BaseBall.getInstance(21));
    }

    @Test
    void compareWithAnswer() {
        int answer = AnswerGenerator.generate("123");
        BaseBall answerBall = BaseBall.getInstance(answer);
        compare(answerBall, 145, STRIKE);
        compare(answerBall, 321, BALL_STRIKE);
        compare(answerBall, 345, BALL);
        compare(answerBall, 456, NOTHING);
        compare(answerBall, 123, PERFECT_STRIKE);
    }

    private static void compare(BaseBall answerBall, int baseBallNumber, BaseBallResultType type) {
        BaseBall userBaseBall = BaseBall.getInstance(baseBallNumber);
        BaseBallResult baseBallResult = userBaseBall.compareWithAnswer(answerBall);
        BaseBallResultType resultType = baseBallResult.getResultType();
        assertEquals(resultType, type);
    }
}