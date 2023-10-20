package baseball.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class InputValidationTest {

    @Test
    @DisplayName("입력된 문자열이 자연수로 이루어져 있는지 테스트")
    void validateNaturalNumberTest() {
        assertThatThrownBy(() -> InputValidation.validateNaturalNumber("12ㅌ"))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("입력된 문자열은 자연수로만 이루어져야 합니다.");
    }
}