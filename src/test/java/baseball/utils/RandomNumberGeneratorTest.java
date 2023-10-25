package baseball.utils;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

@DisplayName("랜덤 숫자 생성 클래스의 객체에")
class RandomNumberGeneratorTest {

    private final RandomNumberGenerator randomNumberGenerator = new RandomNumberGenerator();

    @Nested
    @DisplayName("랜덤 숫자 생성 요청시")
    class GenerateNumbers {

        @Test
        @DisplayName("숫자가 3개 생성되는가")
        void generateThreeNumbers() {
            // given
            // when
            final List<Integer> numbers = randomNumberGenerator.generateNumbers();

            // then
            assertThat(numbers).hasSize(3);
        }

        @Test
        @DisplayName("중복되지 않은 숫자가 생성되는가")
        void generateUniqueNumbers() {
            // given
            // when
            final List<Integer> numbers = randomNumberGenerator.generateNumbers();

            // then
            assertThat(numbers).doesNotHaveDuplicates();
        }
    }
}
