package baseball;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class NumericValidatorTest {

    @ParameterizedTest
    @ValueSource(strings = {"sdfjlvo14n", "121@fsh", "1,2,4", "-1,2,10.0"})
    @DisplayName("숫자 형식이 아닌 경우 예외가 발생한다.")
    void isNotNumeric_Then_ExceptionOccurs(final String stringNumber) {
        assertThatThrownBy(() -> NumericValidator.validate(stringNumber))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
