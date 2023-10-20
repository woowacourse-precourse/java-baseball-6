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
    void has() {
    }
}