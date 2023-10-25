package baseball.validation;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

public class NumbersInputValidatorTest {

    Validator validator = new NumbersInputValidator();

    @Test
    void 숫자입력이_올바른_경우() {
        validator.validate("123");
    }

    @Test
    void 입력에영문이있을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate("11as")
        );
    }

    @Test
    void 입력에0이있을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate("120")
        );
    }

    @Test
    void 입력길이가3이아닌경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate("1234")
        );
    }

    @Test
    void 입력에중복이있을경우() {
        assertThrows(
                IllegalArgumentException.class,
                () -> validator.validate("112")
        );
    }
}
