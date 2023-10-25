package baseball.global;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ValidationTest extends NsTest {

    @Test
    @DisplayName("숫자가 2개만 들어온 경우 예외 발생 확인")
    void testValidateInputLength() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("12"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자가 아닌 다른 값이 들어온 경우 예외 발생 확인")
    void testValidateNumericInput() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("한글"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("1 또는 2의 값이 아닌 경우 예외 발생 확인")
    void testValidateUniqueNumbers() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("3"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("중복된 숫자가 들어온 경우 예외 발생 확인")
    void testInvalidInput_DuplicateDigits() {
        assertSimpleTest(() ->
            assertThatThrownBy(() -> runException("111"))
                .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}