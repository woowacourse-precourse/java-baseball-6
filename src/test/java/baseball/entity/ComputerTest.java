package baseball.entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    private Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    void 랜덤_정답_생성_확인() {
        computer.generateRandomAnswer();
        assertNotNull(computer.getAnswer());
        assertEquals(3, computer.getAnswer().length());
    }

    @Test
    void 랜덤_정답_중복_없음_확인() {
        computer.generateRandomAnswer();
        String answer = computer.getAnswer();
        for (int i = 0; i < answer.length(); i++) {
            for (int j = i + 1; j < answer.length(); j++) {
                assertNotEquals(answer.charAt(i), answer.charAt(j));
            }
        }
    }

    @Test
    void 랜덤_정답_범위_확인() {
        computer.generateRandomAnswer();
        String answer = computer.getAnswer();
        for (char c : answer.toCharArray()) {
            assertTrue(c >= '1' && c <= '9');
        }
    }
}
