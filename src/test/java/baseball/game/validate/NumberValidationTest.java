package baseball.game.validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidationTest {

    @ValueSource(strings = {"1a2", "11b", "sws"})
    @ParameterizedTest
    void validateInteger(String noneNumber) {
        assertThatThrownBy(() -> NumberValidation.validate(noneNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkNegativeNumber() {
        String negativeNumber = "-234";

        assertThatThrownBy(() -> NumberValidation.validate(negativeNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void checkRealNumber() {
        String realNumber = "12.3";

        assertThatThrownBy(() -> NumberValidation.validate(realNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
