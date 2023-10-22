package baseball.common;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class RandomNumberGeneratorTest {

    static final int DIGIT = 3;
    static final int REPEAT = 3;
    RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @DisplayName("3자리 고유한 숫자를 생성한다.")
    @RepeatedTest(REPEAT)
    void testCreateNumber() {
        List<Integer> createdNumbers = randomNumberGenerator.createNumber(DIGIT);
        Set<Integer> uniqueNumbers = new HashSet<>(createdNumbers);

        assertThat(uniqueNumbers).hasSize(DIGIT);
    }
}