package baseball;

import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    public void testGenerateRandomNumbers() {
        Computer computer = new Computer();
        String randomNumbers = computer.generate();

        BaseballGame baseballGame = new BaseballGame();
        try {
            baseballGame.validateNumbers(randomNumbers);
        } catch (IllegalArgumentException e) {
            fail("예외가 발생했습니다: " + e.getMessage());
        }
    }
}
