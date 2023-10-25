package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import baseball.domain.Ball;
import baseball.domain.BallsGenerator;
import baseball.domain.NumberGenerator;
import baseball.domain.RandomBallsGenerator;
import baseball.domain.RandomNumberGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomBallGeneratorTest {

    @Test
    void generate() {
        NumberGenerator numberGenerator = mock(RandomNumberGenerator.class);
        BallsGenerator randomBallsGenerator = RandomBallsGenerator.init(numberGenerator);
        when(numberGenerator.generate()).thenReturn(3, 4, 5);
        assertThat(randomBallsGenerator.generateBalls())
            .containsExactly(Ball.from(1,3), Ball.from(2,4), Ball.from(3,5));
    }
}
