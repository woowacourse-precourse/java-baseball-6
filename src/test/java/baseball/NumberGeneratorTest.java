package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

import java.util.List;

/**
 * NumberGenerator.class 의 테스트 코드이다.
 */
class NumberGeneratorTest {
    private final int CREATE_LENGTH = 3;
    private final List<Integer> randomNumbers = (new NumberGenerator()).getUniqueRandomNumbers(CREATE_LENGTH);

    @Test
    void 개수가_세개인지_체크한다() {
        assertThat(randomNumbers).hasSize(CREATE_LENGTH);
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
            assertThat(number)
                    .isGreaterThanOrEqualTo(NumberGenerator.MIN_RANDOM_NUMBER)
                    .isLessThanOrEqualTo(NumberGenerator.MAX_RANDOM_NUMBER);
        }
    }

    @Test
    void 세개의_숫자가_중복되지_않는지_체크한다() {
        boolean hasNotDuplicate = randomNumbers.stream().distinct().count() ==  randomNumbers.size();
        assertThat(hasNotDuplicate).isTrue();
    }
}
