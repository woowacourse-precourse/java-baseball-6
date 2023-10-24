package baseball.service;

import baseball.domain.Balls;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class BallsGeneratorTest {

    @DisplayName("3가지의 랜덤 숫자가 생성되었는지 검증한다.")
    @Test
    void generateRandomBalls() {
        BallsGenerator ballsGenerator = new BallsGenerator();

        List<Balls> randomBalls = ballsGenerator.generateComputerNumbers();
        Set<Balls> uniqueBalls = new HashSet<>();
        for (Balls ball : randomBalls) {
            assertTrue(ball.getNumber() >= 1 && ball.getNumber() <= 9);
            uniqueBalls.add(ball);
        }

        Assertions.assertAll(
                () -> Assertions.assertEquals(randomBalls.size(), 3),
                () -> Assertions.assertEquals(uniqueBalls.size(), 3)
        );
    }
}
