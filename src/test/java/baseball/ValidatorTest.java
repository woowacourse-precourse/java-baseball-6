package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ValidatorTest {

    @Test
    void 숫자만_입력_시_true_반환() {
        Validator validator = new Validator();

        boolean result = validator.validateGuessNumber("1234");

        Assertions.assertThat(result).isTrue();
    }

    @Test
    void 글자_입력_시_false_반환() {
        Validator validator = new Validator();

        boolean result = validator.validateGuessNumber("가123");

        Assertions.assertThat(result).isFalse();
    }

    @Test
    void 글자_수_예외_테스트() {
        Validator validator = new Validator();

        boolean threeLength = validator.validateGuessNumber("123");
        boolean fiveLength = validator.validateGuessNumber("12345");

        Assertions.assertThat(threeLength).isTrue();
        Assertions.assertThat(fiveLength).isFalse();
    }

    @Test
    void 서로_다른_숫자_입력_예외_테스트() {
        Validator validator = new Validator();

        boolean repeat = validator.validateGuessNumber("122");
        boolean notRepeat = validator.validateGuessNumber("123");

        Assertions.assertThat(repeat).isFalse();
        Assertions.assertThat(notRepeat).isTrue();
    }

}