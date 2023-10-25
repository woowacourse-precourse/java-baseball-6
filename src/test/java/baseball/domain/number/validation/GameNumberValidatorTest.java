package baseball.domain.number.validation;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameNumberValidatorTest {

    @DisplayName("3자릿수가 아니면 예외가 발생한다.")
    @ValueSource(strings = {"12", "1234"})
    @ParameterizedTest
    void validateLength(String number) {
        List<Integer> numbers = toNumbers(number);
        Assertions.assertThatThrownBy(() -> NumberLengthValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 자릿수가 있으면 예외가 발생한다.")
    @ValueSource(strings = {"122", "111"})
    @ParameterizedTest
    void checkDuplicateNumbers(String number) {
        List<Integer> numbers = toNumbers(number);
        Assertions.assertThatThrownBy(() -> DuplicateDigitValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("자릿수가 1 ~ 9가 아니면 예외가 발생한다.")
    @Test
    void validateDigitRange() {
        List<Integer> numbers = Arrays.asList(0, 1, 9);
        Assertions.assertThatThrownBy(() -> DigitRangeValidator.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Integer> toNumbers(String number) {
        return Arrays.stream(number.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
