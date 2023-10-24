package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

import static baseball.Config.*;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class ComputerTest {
    @Test
    public void testGeneratedNumbersSize() {
        Computer computer = new Computer();
        assertEquals(INPUT_NUMBER_LENGTH, computer.getGeneratedNumbers().size());
    }

    @Test
    public void testGeneratedNumbersValidity() {
        Computer computer = new Computer();
        assertTrue(areNumbersUnique(computer.getGeneratedNumbers()));
        assertTrue(areNumbersInRange(computer.getGeneratedNumbers(), RANDOM_NUMBER_START, RANDOM_NUMBER_END));
    }

    private boolean areNumbersUnique(ArrayList<Integer> numbers) {
        for (int i = 0; i < numbers.size(); i++) {
            for (int j = i + 1; j < numbers.size(); j++) {
                if (Objects.equals(numbers.get(i), numbers.get(j))) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean areNumbersInRange(ArrayList<Integer> numbers, int start, int end) {
        for (int number : numbers) {
            if (number < start || number > end) {
                return false;
            }
        }
        return true;
    }
}
