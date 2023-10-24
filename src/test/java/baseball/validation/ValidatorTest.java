package baseball.validation;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    @Test
    void 세자리_숫자로_이루어진_문자입니다() {
        //given
        Validator validator = new Validator();
        //then
        assertThatCode(() -> validator.validateThreeNumber("123"))
                .doesNotThrowAnyException();

    }

    @Test
    void 세자리_숫자로_이루어진_문자가_아닐경우_예외가_터집니다() {
        //given
        Validator validator = new Validator();
        //then
        assertThatThrownBy(() -> validator.validateThreeNumber("1234"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateThreeNumber("abc"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateThreeNumber("a1c"))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateThreeNumber(""))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateThreeNumber(" "))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void 서로다른_세자리_숫자로_이루어진_숫자_입니다() {
        //given
        Validator validator = new Validator();
        //then
        assertThatCode(() -> validator.validateDuplicate(Arrays.asList(1, 2, 3)))
                .doesNotThrowAnyException();
    }

    @Test
    void 서로다른_세자리_숫자로_이루어진_숫자가_아니라면_예외가_터집니다() {
        //given
        Validator validator = new Validator();
        //then
        assertThatThrownBy(() -> validator.validateDuplicate(Arrays.asList(1, 3, 3)))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void _1_또는_2의_문자만_입력해야합니다() {
        //given
        Validator validator = new Validator();
        //then
        assertThatCode(() -> validator.validate1Or2("1"))
                .doesNotThrowAnyException();
        assertThatCode(() -> validator.validate1Or2("2"))
                .doesNotThrowAnyException();
    }

    @Test
    void _1_또는_2의_문자이외의_문자가_입력이_되면_예외가_터집니다() {
        //given
        Validator validator = new Validator();
        //then
        assertThatThrownBy(() -> validator.validate1Or2("3"))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> validator.validate1Or2("a"))
                .isInstanceOf(IllegalArgumentException.class);

    }

}