package baseball.validator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidatorTest {

    Validator validator = new Validator();

    @Test
    @DisplayName("숫자로 입력을 받지 못하면 IllegalArgumentException을 던집니다.")
    void parseValidatedInt() {
        String inputString = "가나다";
        assertThatThrownBy(() -> validator.parseValidatedInt(inputString))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("자릿수가 일치하지 않으면 IllegalArgumentException을 던집니다.")
    void validateCiphers() {
        // given
        int 원하는_자릿수 = 3;

        // when
        int 한자릿수 = 1;
        int 두자릿수 = 10;
        int 세자릿수 = 100;
        int 네자릿수 = 1000;

        // then
        assertThatThrownBy(() -> validator.validateCiphers(한자릿수, 원하는_자릿수))
                .isInstanceOf(IllegalArgumentException.class);

        assertThatThrownBy(() -> validator.validateCiphers(두자릿수, 원하는_자릿수))
                .isInstanceOf(IllegalArgumentException.class);

        // 세자릿수면 에러가 발생하지 않음
        validator.validateCiphers(세자릿수, 원하는_자릿수);

        assertThatThrownBy(() -> validator.validateCiphers(네자릿수, 원하는_자릿수))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("숫자 중에서도 범위 외의 숫자가 입력된다면 IllegalArgumentException을 던집니다.")
    void validateInRange() {
        // given
        int 원하는_범위_시작 = 1;
        int 원하는_범위_끝 = 9;

        // when
        int ZERO = 0;
        int ONE = 1;
        int TEN = 10;

        // then
        assertThatThrownBy(() -> validator.validateInRange(ZERO, 원하는_범위_시작, 원하는_범위_끝))
                .isInstanceOf(IllegalArgumentException.class);
        // 1을 입력하면 에러가 발생하지 않음
        validator.validateInRange(ONE, 원하는_범위_시작, 원하는_범위_끝);
        assertThatThrownBy(() -> validator.validateInRange(TEN, 원하는_범위_시작, 원하는_범위_끝))
                .isInstanceOf(IllegalArgumentException.class);
    }
}