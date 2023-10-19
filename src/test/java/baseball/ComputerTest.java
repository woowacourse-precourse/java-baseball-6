package baseball;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class ComputerTest {
    Computer computer;

    @BeforeEach
    void setUp() {
        computer = new Computer();
    }

    @Test
    void checkMakeList() {
        assertEquals(computer.getRandomList().size(), 3);
    }
}
