package baseball;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import baseball.domain.Computer;
public class ComputerNumberTest {
    private Computer computer;

    @BeforeEach
    private void createComputer() {
        computer = new Computer();
    }

    @Test
    void 중복_검사() {
        for (int i = 0; i < 100; i++) {
            computer.generateNumber();
            assertTrue(checkDuplicate(computer.getNumber()));
        }
    }

    @Test 
    void 숫자의_범위_검사() {
        for (int i = 0; i < 100; i++) {
            computer.generateNumber();
            assertTrue(checkRange(computer.getNumber()));
        }
    }

    private boolean checkDuplicate(List<Integer> computer) {
        return computer.stream().distinct().count() == 3;
    }

    private boolean checkRange(List<Integer> computer) {
        return computer.stream().allMatch(number -> number >= 1 && number <= 9);
    }
}
