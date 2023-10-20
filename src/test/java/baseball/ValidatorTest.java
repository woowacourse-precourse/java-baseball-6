package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;


class ValidatorTest {

    @Test
    void 숫자만_입력시_true_반환() {

        Validator validator = new Validator();

        boolean result = validator.validateGuessNumber("1234");

        Assertions.assertThat(result).isTrue();

    }

    @Test
    void isNumber_글자_입력시_false_반환() {

        Validator validator = new Validator();

        boolean result = validator.validateGuessNumber("가123");

        Assertions.assertThat(result).isFalse();
    }

}