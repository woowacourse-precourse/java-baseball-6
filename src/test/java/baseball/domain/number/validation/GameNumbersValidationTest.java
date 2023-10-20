package baseball.domain.number.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.game.validate.NumberValidation;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class GameNumbersValidationTest {

    @ValueSource(strings = {"12", "1234"})
    @ParameterizedTest
    void validateLength(String number) {
        List<Integer> numbers = toNumbers(number);
        assertThatThrownBy(() -> GameNumbersValidation.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ValueSource(strings = {"122", "111"})
    @ParameterizedTest
    void checkDuplicateNumbers(String number) {
        List<Integer> numbers = toNumbers(number);
        assertThatThrownBy(() -> GameNumbersValidation.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateDigitRange() {
        List<Integer> numbers = Arrays.asList(0, 1, 9);
        assertThatThrownBy(() -> GameNumbersValidation.validate(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    private List<Integer> toNumbers(String number) {
        NumberValidation.validate(number);
        return Arrays.stream(number.split("")).map(Integer::parseInt).collect(Collectors.toList());
    }
}
