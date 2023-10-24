package baseball;

import org.junit.jupiter.api.Test;

import camp.nextstep.edu.missionutils.test.NsTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ValidateInputTest extends NsTest {
    @Test
    void 입력값_검증_성공() {
        assertSimpleTest(
                () -> assertThatCode(() -> ValidateInput.validate("123", "^[1-9]{3}$", "입력 값은 1~9 까지 각 숫자 3자리수 입니다"))
                        .doesNotThrowAnyException());
    }

    @Test
    void 입력값_검증_실패() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> ValidateInput.validate("", "오류", "입력 값 검증 오류"))
                        .hasMessage("입력 값 검증 오류")
                        .isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 문자중복여부_검증_성공() {
        assertSimpleTest(
                () -> assertThatCode(() -> ValidateInput.validateDuplicate("123"))
                        .doesNotThrowAnyException());
    }

    @Test
    void 문자중복여부_검증_실패() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> ValidateInput.validateDuplicate("111"))
                        .hasMessageContaining("중복된 문자가 존재합니다.").isInstanceOf(IllegalArgumentException.class));
    }

    @Override
    protected void runMain() {}

}
