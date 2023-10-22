package baseball.view;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;
class InputValidatorTest {

    InputValidator inputValidator = new InputValidator();

    @Test
    @DisplayName("사용자가 문자로 입력하면 에러가 발생한다.")
    void input_not_numeric_error(){
        assertThatThrownBy(() -> inputValidator.validateNumeric("박준수"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("사용자가 0이 포함한 숫자를 입력하면 에러가 발생한다.")
    void input_number_zero_error(){
        assertThatThrownBy(() -> inputValidator.validateNumeric("304"))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @DisplayName("사용자가 정상적으로 입력을 한다.")
    @ValueSource(strings = {"123", "217", "248", "111"})
    void input_correct(String input){
        assertThatCode(() -> inputValidator.validateNumeric(input))
                .doesNotThrowAnyException();
    }
}
