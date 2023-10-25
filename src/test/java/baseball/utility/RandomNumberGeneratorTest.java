package baseball.utility;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumberGeneratorTest {

    @DisplayName("임의의 세 자리 숫자를 반환한다.")
    @Test
    void generateNotDuplicatedRandomNumbers() {
        // given, when
        List<Integer> randomNumbers = RandomNumberGenerator.generateNotDuplicatedRandomNumbers();

        // then
        assertThat(randomNumbers).hasSize(3);
    }

}