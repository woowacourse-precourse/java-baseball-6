package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class MethodTest {

    @Test
    void testGenerateRandomNumbers() {
        List<Integer> randomNumbers = Application.generateRandomNumbers();

        // 숫자 3개가 생성되었는지 검증
        assertEquals(3, randomNumbers.size());

        // 중복된 숫자가 없는지 검증
        assertEquals(randomNumbers.size(), randomNumbers.stream().distinct().count());

        // 모든 숫자가 1~9 범위인지 검증
        for (int number : randomNumbers) {
            assertTrue(number >= 1 && number <= 9);
        }
    }
}
