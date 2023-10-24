package baseball.domain;

import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BaseballNumbersTest {

    @Test
    void getNumbers() {
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        List<Integer> numbers = baseballNumbers.getNumbers();

        assertThat(numbers.size()).isEqualTo(3);
        assertThat(numbers.stream().collect(Collectors.toSet()).size()).isEqualTo(3);
        assertThat(numbers.contains(0)).isFalse();
    }

    @Test
    void getNumbers_unmodified() {
        BaseballNumbers baseballNumbers = new BaseballNumbers();
        List<Integer> numbers = baseballNumbers.getNumbers();

        assertThatThrownBy(() -> numbers.add(1))
                .isInstanceOf(UnsupportedOperationException.class);
    }
}