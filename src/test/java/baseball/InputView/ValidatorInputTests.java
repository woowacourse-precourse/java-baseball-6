package baseball.InputView;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.Application;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class ValidatorInputTests extends NsTest {

    @DisplayName("입력한 수가 3자리보다 클 때")
    @Test
    void validateUserLongLengthInputTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력한 수가 3자리보다 작을 때")
    @Test
    void validateUserShortLengthInputTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력한 수 중에 겹치는 숫자가 있을 때")
    @Test
    void validateUserDuplicateInputTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("입력한 수에 숫자가 아닌 다른 문자가 있을 때")
    @Test
    void validateUserNotNumberInputTest() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a21"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}