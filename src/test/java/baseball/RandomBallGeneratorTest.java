package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import baseball.domain.Ball;
import baseball.domain.NumberGenerator;
import baseball.domain.RandomBallsGenerator;
import baseball.domain.RandomNumberGenerator;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class RandomBallGeneratorTest {

    @ParameterizedTest
    @ValueSource(ints = {3, 4, 5})
    void generate(int randomNumber) {
        RandomBallsGenerator randomBallsGenerator = new RandomBallsGenerator();
        RandomNumberGenerator randomNumberGenerator = mock(RandomNumberGenerator.class);
        when(randomNumberGenerator.generate()).thenReturn(3, 4, 5);
        assertThat(randomBallsGenerator.generateBalls(randomNumberGenerator))
            .containsExactly(Ball.from(1,3), Ball.from(2,4), Ball.from(3,5));
    }
}
