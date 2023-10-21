package baseball;

import static org.junit.jupiter.api.Assertions.fail;

import baseball.model.GenerateRandomNumbers;
import java.util.List;
import org.junit.jupiter.api.Test;

public class GenerateRandomNumbersTest {
    @Test
    public void testGenerateRandomNumbers() {
        GenerateRandomNumbers generateRandomNumbers = new GenerateRandomNumbers();
        List<Integer> randomNumbers = generateRandomNumbers.generate();

        StringBuilder sb = new StringBuilder();
        for (Integer number : randomNumbers) {
            sb.append(number);
        }
        String validNumbers = sb.toString();

        BaseballGame baseballGame = new BaseballGame();
        try {
            baseballGame.validateNumbers(validNumbers);
        } catch (IllegalArgumentException e) {
            fail("예외가 발생했습니다: " + e.getMessage());
        }
    }
}
