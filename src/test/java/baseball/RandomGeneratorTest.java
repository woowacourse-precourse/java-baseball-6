package baseball;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import baseball.model.RandomGenerator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.Test;

public class RandomGeneratorTest {

    final RandomGenerator randomGenerator = new RandomGenerator();
    final List<Integer> randomNumber = randomGenerator.createRandomNumber();

    @Test
    void 랜덤수_서로_다른_3자리() {

        Set<Integer> randomNumberSet = new HashSet<>(randomNumber);
        assertThat(randomNumberSet.size()).isEqualTo(3);

    }

    @Test
    void 랜덤수_각_숫자_1과9사이() {

        for (int i = 0; i < 3; i++) {
            assertThat(randomNumber.get(i)).isBetween(1, 9);
        }
    }
}
