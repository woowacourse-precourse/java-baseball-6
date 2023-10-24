package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class ComputerTest {
    @DisplayName("컴퓨터 숫자 테스트")
    @Test
    void computerNumberTest() {
        Computer computer = new Computer();

        computer.setRandomNumber();

        testSize(computer.number);
        testRange(computer.number);
        testDuplication(computer.number);
    }

    void testSize(List<Integer> computerNumber) {
        assertEquals(computerNumber.size(), 3);
    }

    void testRange(List<Integer> computerNumber) {
        for (int digit : computerNumber) {
            assertTrue(digit >= 1 && digit <= 9);
        }
    }

    void testDuplication(List<Integer> computerNumber) {
        Set<Integer> testNumber = new HashSet<>(computerNumber);
        assertEquals(testNumber.size(), computerNumber.size());
    }
}
