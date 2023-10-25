package baseball.controller;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.view.OutputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class OutputTest extends NsTest {
    private final OutputController outputController = new OutputController();

    @Test
    @DisplayName("Intro 메시지 출력 확인")
    public void testShowIntroMessage() {
        outputController.showIntroMessage();
        run();
        assertThat(output()).contains("숫자 야구 게임을 시작합니다.");
    }

    @Test
    @DisplayName("게임 입력 메시지 출력 확인")
    public void testShowGameInputMessage() {
        outputController.showGameInputMessage();
        run();
        assertThat(output()).contains("숫자를 입력해주세요 :");
    }

    @Test
    @DisplayName("게임 클리어 메시지 출력 확인")
    public void testShowGameClearMessage() {
        outputController.showGameClearMessage();
        run();
        assertThat(output()).contains("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
    }

    @Test
    @DisplayName("게임 재시작 입력 메시지 출력 확인")
    public void testShowGameRestartInputMessage() {
        outputController.showGameRestartInputMessage();
        run();
        assertThat(output()).contains("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }

    @Test
    @DisplayName("힌트 메시지 1볼 확인")
    public void simpleOutputTest(){
        String message ="1볼";
        OutputView.showHint(message);
        run();
        assertThat(output()).contains(message);
    }

    @Override
    protected void runMain() {

    }
}
