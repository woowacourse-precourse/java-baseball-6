package baseball.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class OptionInputValidatorTest {

    Validator validator = new OptionInputValidator();

    @Test
    void 옵션입력이_올바른_경우() {
        validator.validate("1");
    }

    @Test
    void 옵션입력에영문이있을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate("av")
        );
    }

    @Test
    void 옵션입력이잘못되었을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate("5")
        );
    }
}
