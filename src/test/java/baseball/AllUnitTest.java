package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AllUnitTest extends NsTest {
    @Test
    @DisplayName("세 자리 초과 글자를 입력할 경우 에러 반환")
    public void 세_자리_초과_글자를_입력할_경우_에러_반환() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("세 자리 미만 글자를 입력할 경우 에러 반환")
    public void 세_자리_미만_글자를_입력할_경우_에러_반환() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("음수를 입력할 경우 에러 반환")
    public void 음수를_입력할_경우_에러_반환() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("숫자가 아닌 문자를 입력할 경우 에러 반환")
    public void 숫자가_아닌_문자를_입력할_경우_에러_반환() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("재입력시 1이나 2가 아닌 값을 입력할 경우 에러 반환")
    public void 재입력시_1이나_2가_아닌_값을_입력할_경우_에러_반환() {
        assertThrows(IllegalArgumentException.class, () -> {
            run("246", "3");
            assertThat(output()).contains("3스트라이크");
        });
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
