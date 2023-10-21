package baseball;

import baseball.logic.InputValidator;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatNoException;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputValidatorTest {

    private final InputValidator validator = new InputValidator();

    @Test
    void 사용자_입력_통합_검증() {
        // given
        String CorrectInput = "369";
        String ErrorInput = "1234";

        // when, then
        assertThatNoException().isThrownBy(() -> validator.validateInput(CorrectInput));
        assertThatThrownBy(() -> validator.validateInput(ErrorInput))
                .isInstanceOf(IllegalArgumentException.class);

    }
}
