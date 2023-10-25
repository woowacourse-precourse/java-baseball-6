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

    @Test
    @DisplayName("숫자가 아닌 입력에 대한 IllegalArgumentException")
    void validateNotDigitInput() {
        assertThatThrownBy(() -> {
            validator.validateNumbersInput("a23");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("짧은 문자열 입력에 대한 IllegalArgumentException")
    void validateLessNumbersInput() {
        assertThatThrownBy(() -> {
            validator.validateNumbersInput("12");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("1과 2가 아닌 옵션 입력에 대한 IllegalArgumentException")
    void validateOutRangeOptionInput() {
        assertThatThrownBy(() -> {
            validator.validateOptionInput("4");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자가 아닌 옵션 입력에 대한 IllegalArgumentException")
    void validateNotDigitOptionInput() {
        assertThatThrownBy(() -> {
            validator.validateOptionInput("a");
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("한 자리의 수가 아닌 입력에 대한 IllegalArgumentException")
    void validateOverSizeInput() {
        assertThatThrownBy(() -> {
            validator.validateNumbersInput("12");
        }).isInstanceOf(IllegalArgumentException.class);
    }
}