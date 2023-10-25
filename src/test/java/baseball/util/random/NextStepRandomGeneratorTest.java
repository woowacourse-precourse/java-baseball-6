package baseball.util.random;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

@DisplayName("[RandomTest]")
class NextStepRandomGeneratorTest {

    @Test
    @DisplayName("항상 중복되지 않는 임의의 세 수를 생성한다.")
    void generateRandomThreeNumbersNotDuplicated() {
        // given
        NextStepRandomGenerator random = new NextStepRandomGenerator();
        Range range = new Range(1, 9);
        int count = 3;

        for (int i = 0; i < 100; i++) {
            // when
            List<Integer> randomNumbers = random.pickUniqueNumbersInRange(range, count);
            Set<Integer> randomNumbersSet = new HashSet<>(randomNumbers);

            // then
            assertThat(randomNumbers.size()).isEqualTo(count);
            assertThat(randomNumbersSet.size()).isEqualTo(count);
        }
    }

}