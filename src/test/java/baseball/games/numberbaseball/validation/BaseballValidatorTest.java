package baseball.games.numberbaseball.validation;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BaseballValidatorTest {
    private final BaseballValidator validator = new BaseballValidator();


    @Test
    @DisplayName("범위를 벗어난 수 입력에 대한 IllegalArgumentException")
    void validateOutRangeInput() {
        assertThatThrownBy(() -> {
            validator.validateNumbersInput("104");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}