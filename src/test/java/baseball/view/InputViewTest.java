package baseball.view;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest extends NsTest {

    @Test
    void 사용자_숫자_입력_테스트() {
        assertSimpleTest(() -> {
            run("123", "456", "789");
            assertThat(output()).contains("숫자 야구 게임을 시작합니다.\n" + "숫자를 입력해주세요 :");
        });
    }

    @Test
    void 잘못된_입력_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> run("a", "101121", "1234"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }

    @Override
    protected void runMain() {
        InputView.readUserNumbers();
    }
}
