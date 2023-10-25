package baseball.game.validate;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidationTest {

    @DisplayName("정수가 입력되지 않으면 예외가 발생한다.")
    @ValueSource(strings = {"1a2", "11b", "sws"})
    @ParameterizedTest
    void validateInteger(String noneNumber) {
        Assertions.assertThatThrownBy(() -> IntegerValidator.validate(noneNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("음수가 입력되면 예외가 발생한다.")
    @Test
    void checkNegativeNumber() {
        Integer negativeNumber = -234;

        Assertions.assertThatThrownBy(() -> NegativeNumberValidator.validate(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("실수가 입력되면 예외가 발생한다.")
    @Test
    void checkRealNumber() {
        String realNumber = "12.3";
        Assertions.assertThatThrownBy(() -> IntegerValidator.validate(realNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
