package baseball.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputerTest {
    private Computer computer;

    private static final int COMPUTER_NUMBER_LENGTH = 3;
    private static final int COMPUTER_NUMBER_MINIMUM = 1;
    private static final int COMPUTER_NUMBER_MAXIMUM = 9;

    @BeforeEach
    public void setUp() {
        computer = new Computer();
    }

    @Test
    public void testCreateComputerNumber() {
        computer.createComputerNumber();
        List<Integer> computerNumber = computer.getComputerNumber();

        assertEquals(COMPUTER_NUMBER_LENGTH, computerNumber.size());

        for (Integer number : computerNumber) {
            assertTrue(number >= COMPUTER_NUMBER_MINIMUM);
            assertTrue(number <= COMPUTER_NUMBER_MAXIMUM);
        }

        // Ensure there are no duplicates in the list
        for (int i = 0; i < computerNumber.size(); i++) {
            for (int j = i + 1; j < computerNumber.size(); j++) {
                assertTrue(!computerNumber.get(i).equals(computerNumber.get(j)));
            }
        }
    }
}
