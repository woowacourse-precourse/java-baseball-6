package baseball.game.validate;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberValidationTest {

    @ValueSource(strings = {"1a2", "11b", "sws"})
    @ParameterizedTest
    void validate(String noneNumber) {
        assertThatThrownBy(() -> NumberValidation.validate(noneNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
