package baseball.validator;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.catchThrowable;

import org.junit.jupiter.api.Test;

class InputValidatorTest {
    @Test
    void 입력검증_올바른입력_성공() {
        String userInput = "123";
        assertThatCode(() -> InputValidator.validateGuess(userInput)).doesNotThrowAnyException();
    }

    @Test
    void 입력검증_숫자가아닌경우_예외발생() {
        String userInput = "숫자가 아닙니다.";
        Throwable thrown = catchThrowable(() -> InputValidator.validateGuess(userInput));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력검증_세자리수가아닌경우_예외발생() {
        String userInput = "1234";
        Throwable thrown = catchThrowable(() -> InputValidator.validateGuess(userInput));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력검증_0을포함한경우_예외발생() {
        String userInput = "102";
        Throwable thrown = catchThrowable(() -> InputValidator.validateGuess(userInput));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력검증_숫자가중복된경우_예외발생() {
        String userInput = "112";
        Throwable thrown = catchThrowable(() -> InputValidator.validateGuess(userInput));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}