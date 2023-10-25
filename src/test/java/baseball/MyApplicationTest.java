package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

public class MyApplicationTest extends NsTest {

    @DisplayName("중복 답안 입력 시 예외")
    @ParameterizedTest
    @ValueSource(strings = {"111", "112", "121", "122"})
    void 예외_테스트_중복(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("숫자 외 문자 입력 시 예외")
    @ParameterizedTest
    @ValueSource(strings = {"12ㅁ", "1a4", "f12"})
    void 예외_테스트_문자입력(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @DisplayName("유효하지 않은 길이의 문자 입력 시 예외")
    @ParameterizedTest
    @ValueSource(strings = {"12", "1", "1234", " "})
    void 예외_테스트_길이(String input) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(input))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
