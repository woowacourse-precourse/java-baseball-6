package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import baseball.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class InputViewTest extends NsTest {

    @Test
    void 사용자_입력_요구_출력_테스트() {
        run("123", "1");
        assertThat(output()).contains("숫자를 입력해주세요 : ",
            "게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Override
    protected void runMain() {
        InputView.getInputNumber();
        InputView.getRestartOrQuit();
    }
}
