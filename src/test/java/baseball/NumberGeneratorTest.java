package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * NumberGenerator.class 의 테스트 코드이다.
 */
class NumberGeneratorTest {
    private final NumberGenerator generator = new NumberGenerator();
    private final List<Integer> randomNumbers = generator.getThreeRandomNumbers();

    @Test
    void 개수가_세개인지_체크한다() {
        assertThat(randomNumbers).hasSize(3);
    }

    @Test
    void 랜덤값의_타입이_숫자인지_체크한다() {
        for(Integer number : randomNumbers) {
            assertThat(number).isInstanceOf(Integer.class);
        }
    }

    @Test
    void 랜덤값의_범위가_1부터_9까지인지_체크한다() {
        for(Integer number : randomNumbers) {
            assertThat(number).isGreaterThanOrEqualTo(1);
            assertThat(number).isLessThanOrEqualTo(9);
        }
    }

    @Test
    void 세개의_숫자가_중복되지_않는지_체크한다() {
        boolean hasNotDuplicate = randomNumbers.stream().distinct().count() ==  randomNumbers.size();
        assertThat(hasNotDuplicate).isTrue();
    }
}
