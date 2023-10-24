package baseball.util;

import baseball.constant.Number;
import baseball.validation.SingleNumberValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class RandomNumbersGeneratorTest {

    @DisplayName("중복된 숫자없이 랜덤한 결과 생성 테스트")
    @Test
    void checkUniqueRandomNumbers() {
        String result = RandomNumbersGenerator.generate();
        assertThat(Set.of(result.split("")).size()).isEqualTo(result.length());
    }

    @DisplayName("올바른 범위의 결과 생성 테스트")
    @Test
    void checkValidRangeNumbers() {
        String result = RandomNumbersGenerator.generate();
        assertThat(result.matches(SingleNumberValidator.ONLY_NATURE_NUMBER)).isTrue();
    }

    @DisplayName("올바른 길이의 결과 생성 테스트")
    @Test
    void checkValidSize() {
        String result = RandomNumbersGenerator.generate();
        assertThat(result.length()).isEqualTo(Number.SIZE);
    }
}