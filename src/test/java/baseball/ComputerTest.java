package baseball;

import baseball.computer.Computer;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputerTest {
    @Test
    public void testGenerateRandomDigits() {
        Computer computer = new Computer();
        List<Integer> result = computer.generateRandomDigits();

        // 테스트: 결과 리스트는 3개의 숫자를 포함해야 함
        assertEquals(3, result.size());

        // 테스트: 중복 없이 1부터 9까지의 숫자로 구성되어야 함
        for (int i = 1; i <= 9; i++) {
            final int valueToCheck = i;
            long count = result.stream().filter(x -> x == valueToCheck).count();
            assertTrue(count <= 1);
        }

    }
}
