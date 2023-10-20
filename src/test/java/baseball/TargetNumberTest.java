package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TargetNumberTest {

    @Test
    @DisplayName("중복된 숫자가 선택되지 않는지 테스트")
    void getRandomNumber() {
        TargetNumber targetNumber = TargetNumber.generate(0, 0, 0);
        int[] randomNumbers = targetNumber.getRandomNumber();

        boolean[] isUsed = new boolean[10];
        int count = 0;
        for (int i:randomNumbers) {
            if (!isUsed[i]) {
                count++;
                isUsed[i] = true;
            }
        }

        assertEquals(3, count);
    }

    @Test
    @DisplayName("has 메서드 작동 확인")
    void has() {
        TargetNumber targetNumber = TargetNumber.generate(3, 5, 7);

        assertTrue(targetNumber.has(3, 0)[0]);
        assertTrue(targetNumber.has(5, 1)[0]);
        assertTrue(targetNumber.has(7, 2)[0]);

        assertFalse(targetNumber.has(3, 1)[1]);
        assertFalse(targetNumber.has(5, 2)[1]);
        assertFalse(targetNumber.has(7, 0)[1]);

        assertFalse(targetNumber.has(3, -1)[0]);
        assertFalse(targetNumber.has(3, -1)[1]);

        assertFalse(targetNumber.has(100, 0)[0]);
    }
}