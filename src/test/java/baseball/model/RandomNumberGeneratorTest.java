package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RandomNumberGeneratorTest {

    RandomNumberGenerator randomNumberGenerator;

    @BeforeEach
    public void before() {
        randomNumberGenerator = new RandomNumberGenerator();
    }

    @Test
    @DisplayName("랜덤숫자 3자리수가 생성된다.")
    public void generateThreeRandomRumbers() {
        // When
        List<Integer> numbers = randomNumberGenerator.generateRandomNumber();

        // then
        assertThat(numbers.size()).isEqualTo(3);

    }

    @Test
    @DisplayName("랜덤숫자의 각 자릿수가 모두 다르다.")
    public void generateUniqueDigits() {
        // TODO
    }
}