package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import baseball.domain.balls.RandomBallsGenerator;
import org.junit.jupiter.api.Test;

public class RandomBallsGeneratorTest {
    @Test
    void generate_test() {
        RandomBallsGenerator randomBallsGenerator = new RandomBallsGenerator();
        assertDoesNotThrow(randomBallsGenerator::generateBalls);
    }
}
