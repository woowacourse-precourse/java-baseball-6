package baseball.domain;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

import org.junit.jupiter.api.Test;

public class RandomBallsGeneratorTest {
    @Test
    void generate_test() {
        RandomBallsGenerator randomBallsGenerator = new RandomBallsGenerator();
        assertDoesNotThrow(randomBallsGenerator::generateBalls);
    }
}
