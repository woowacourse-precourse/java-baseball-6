package baseball.utils;

import baseball.domain.Ball;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class BallGeneratorTest {

    @Test
    void validate() {
        BallGenerator generator = new BallGenerator();
        List<Ball> generatedBalls = generator.generate();
        String input = Converter.convertBallListToString(generatedBalls);

        Assertions.assertDoesNotThrow(
            () -> Validator.validateDigitsInRange(input)
        );
        Assertions.assertDoesNotThrow(
            () -> Validator.validateIsNumeric(input)
        );
        Assertions.assertDoesNotThrow(
            () -> Validator.validateDigitsAreDistinct(input)
        );
        Assertions.assertDoesNotThrow(
            () -> Validator.validateLength(input)
        );
        Assertions.assertDoesNotThrow(
            () -> Validator.validateNotEmpty(input)
        );
    }

}
