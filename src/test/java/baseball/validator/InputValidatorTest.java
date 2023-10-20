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

    @Test
    void 재시작검증_1을입력한경우_재시작() {
        String userInput = "1";
        int result = InputValidator.validateRestart(userInput);
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 재시작검증_2를입력한경우_종료() {
        String userInput = "2";
        int result = InputValidator.validateRestart(userInput);
        assertThat(result).isEqualTo(2);
    }

    @Test
    void 재시작검증_잘못된입력의경우_예외발생() {
        String userInput = "3";
        Throwable thrown = catchThrowable(() -> InputValidator.validateRestart(userInput));
        assertThat(thrown).isInstanceOf(IllegalArgumentException.class);
    }
}