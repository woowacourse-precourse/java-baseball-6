package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("InputValidator 클래스 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
public class InputValidatorTest {

    @Test
    void 사용자의_잘못된_시도_입력을_검사한다() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.checkUserTrialInput("12"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.checkUserTrialInput("1a1"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.checkUserTrialInput("101"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.checkUserTrialInput("121"));
        assertDoesNotThrow(() -> {
            InputValidator.checkUserTrialInput("123");
            InputValidator.checkUserTrialInput("456");
            InputValidator.checkUserTrialInput("789");
        });
    }

    @Test
    void 사용자의_잘못된_재시작_입력을_검사한다() {
        assertThrows(IllegalArgumentException.class, () -> InputValidator.checkUserRestartInput("0"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.checkUserRestartInput("a"));
        assertThrows(IllegalArgumentException.class, () -> InputValidator.checkUserRestartInput("11"));
        assertDoesNotThrow(() -> {
            InputValidator.checkUserRestartInput("1");
            InputValidator.checkUserRestartInput("2");
        });
    }
}
