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
        InputValidator validator = new InputValidator();

        assertThrows(IllegalArgumentException.class, () -> validator.vaildUserTrialInput("12"));
        assertThrows(IllegalArgumentException.class, () -> validator.vaildUserTrialInput("1a1"));
        assertThrows(IllegalArgumentException.class, () -> validator.vaildUserTrialInput("101"));
        assertThrows(IllegalArgumentException.class, () -> validator.vaildUserTrialInput("121"));
        assertDoesNotThrow(() -> {
            validator.vaildUserTrialInput("123");
            validator.vaildUserTrialInput("456");
            validator.vaildUserTrialInput("789");
        });
    }

    @Test
    void 사용자의_잘못된_재시작_입력을_검사한다() {
        InputValidator validator = new InputValidator();

        assertThrows(IllegalArgumentException.class, () -> validator.vaildUserRestartInput("0"));
        assertThrows(IllegalArgumentException.class, () -> validator.vaildUserRestartInput("a"));
        assertThrows(IllegalArgumentException.class, () -> validator.vaildUserRestartInput("11"));
        assertDoesNotThrow(() -> {
            validator.vaildUserRestartInput("1");
            validator.vaildUserRestartInput("2");
        });
    }
}
