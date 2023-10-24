package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.LinkedHashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void testGenerateComputerNumbers() {
        Computer computer = new Computer(3);

        List<Integer> computerNumbers = computer.getComputerNumbers();

        assertEquals(computerNumbers.size(), new LinkedHashSet<>(computerNumbers).size());

        assertEquals(3, computerNumbers.size());

        for (int number : computerNumbers) {
            assertTrue(number >= 1 && number <= 9);
        }
    }

}
