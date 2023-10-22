package baseball.unitTest;

import static org.assertj.core.api.Assertions.*;

import baseball.model.validator.NumberValidation;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class NumberValidationTest {

    private NumberValidation numberValidation;

    @BeforeEach
    void setUp() {
        numberValidation = new NumberValidation();
    }

    @Test
    @DisplayName("입력값이_숫자가 아닐 경우_예외를 발생한다")
    void input_isNotNumber_exception() {
        assertThatThrownBy(() -> numberValidation.validateNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이_3자리가 아닐 경우_예외를 발생한다")
    void input_isNot3Digit_exception() {
        assertThatThrownBy(() -> numberValidation.validateNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("입력값이_각 자리마다 중복이 발생할 경우_예외를 발생한다")
    void input_duplicateNumber_exception() {
        assertThatThrownBy(() -> numberValidation.validateNumber("535"))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
