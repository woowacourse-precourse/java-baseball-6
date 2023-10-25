package baseball.unitTest;

import baseball.model.validator.RestartNumberValidation;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class RestartNumberValidationTest {

    private RestartNumberValidation restartNumberValidation;

    @BeforeEach
    void setUp() {
        restartNumberValidation = new RestartNumberValidation();
    }

    @Test
    @DisplayName("입력 숫자가_1과 2가 아니면_예외를 발생한다")
    void input_isNot1Or2_exception() {
        Assertions.assertThatThrownBy(() -> restartNumberValidation.validateNumber(3))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("1과 2 숫자만 허용한다");
    }
}
