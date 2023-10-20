package baseball.mytest.model;

import org.junit.jupiter.api.Test;

import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;

public class InputNumberValidatorTest {
    InputNumberValidator validator = new InputNumberValidator();

    void assertTest(String input, Predicate<String> testMethod) {
        assertThat(testMethod.test(input)).isEqualTo(true);
    }

    @Test
    void 입력이_1_또는_2인지_제외_모두_검증() {
        String input  = "586";
        validator.validateAllInput(input);
    }

    @Test
    void 입력이_3자리인지_검증() {
        String input = "1a4";
        assertTest(input, validator::hasThreeDigits);
    }

    @Test
    void 입력이_숫자인지_검증() {
        String input = "55256";
        assertTest(input, validator::isNumber);
    }

    @Test
    void 입력이_각기_다른_문자인지_검증() {
        String input = "5a673b";
        assertTest(input, validator::areDigitsUnique);
    }

    @Test
    void 입력이_1_또는_2인지_검증() {
        String input = "1";
        String input2 = "2";
        assertTest(input, validator::isOneOrTwo);
        assertTest(input2, validator::isOneOrTwo);
    }
}
