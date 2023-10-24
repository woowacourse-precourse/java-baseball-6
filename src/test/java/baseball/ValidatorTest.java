package baseball;

import baseball.validator.NumberValidator;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ValidatorTest {

    NumberValidator numberValidator = new NumberValidator();
    @Test
    void 숫자입력_세자리_미만_입력시_예외_발생(){
        String input = "14";

        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            numberValidator.validateInputNumber(input,3);
        });
    }
}
