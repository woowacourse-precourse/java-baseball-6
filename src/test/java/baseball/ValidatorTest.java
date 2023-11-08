package baseball;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class ValidatorTest {

    private static Validator validator;

    @BeforeAll
    static void beforeAll() {
        validator = new Validator();
    }

    @Test
    void 숫자가_아닌_값을_입력한_경우() {
        assertThat(validator.isValidNumber("12r")).isFalse();
    }

    @Test
    void 각_자리수가_중복되게_입력한_경우() {
        assertThat(validator.isValidNumber("112")).isFalse();
    }

    @Test
    void 범위가_아닌_숫자를_입력한_경우() {
        assertThat(validator.isValidNumber("120")).isFalse();
    }

    @Test
    void 숫자_자리수를_초과해서_입력한_경우() {
        assertThat(validator.isValidNumber("1234")).isFalse();
    }

    @Test
    void 숫자_자리수를_미만으로_입력한_경우() {
        assertThat(validator.isValidNumber("12")).isFalse();
    }

    @Test
    void 클리어_후_숫자가_아닌_값을_입력한_경우() {
        assertThat(validator.isOneOrTwo("a")).isFalse();
    }

    @Test
    void 클리어_후_범위가_아닌_값을_입력한_경우() {
        assertThat(validator.isOneOrTwo("3")).isFalse();
    }

}
