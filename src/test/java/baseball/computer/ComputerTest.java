package baseball.computer;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {

    @Test
    void getNumbers() {
        Computer computer = new Computer();
        System.out.println(computer.getNumbers());
    }
}