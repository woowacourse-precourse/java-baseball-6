package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.service.DoubleRandomService;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RandomNumberGeneratorTest {

    public static final int TEST_NUMBER = 1;

    @Test
    @DisplayName("서로 다른 3개의 숫자를 만든다")
    void createThreeDifferentNumbers() {
        // given
        RandomNumberGenerator generator = new RandomNumberGenerator(new DoubleRandomService(TEST_NUMBER));

        // when
        List<Integer> randomNumbers = generator.createRandomNumbers();

        // then
        assertThat(randomNumbers).isEqualTo(List.of(1, 2, 3));
    }
}
