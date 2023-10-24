package game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    void sizeTest() {
        List<Integer> answer = computer.getAnswer();
        assertEquals(3, answer.size());
    }

    @Test
    void noDuplicateTest() {
        List<Integer> answer = computer.getAnswer();
        Set<Integer> set = new HashSet<>();

        for (int i : answer) {
            set.add(i);
        }
        assertEquals(3, set.size());
    }

    @Test
    void ValidRangeTest() {
        List<Integer> answer = computer.getAnswer();

        for (int randomInput : answer) {
            assertTrue((randomInput >= 1 && randomInput <= 9));
        }
    }

}