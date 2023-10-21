package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.Test;

class ComputerTest {

    @Test
    void testSetComputerNumTest() {
        Computer computer = new Computer();
        computer.setComputerNum();
        List<Integer> computerNumbers = computer.getComputerNum();

        assertEquals(3, computerNumbers.size());

        assertTrue(computerNumbers.get(0) != computerNumbers.get(1));
        assertTrue(computerNumbers.get(0) != computerNumbers.get(2));
        assertTrue(computerNumbers.get(1) != computerNumbers.get(2));
    }
}