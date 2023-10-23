package baseball.domain;

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
}