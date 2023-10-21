package baseball.mytest.view;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class OutputViewTest {
    OutputView outputView = new OutputView();

    @Test
    void 게임_시작_메시지() {
        assertThat(outputView.startGameMessage()).isEqualTo("숫자 야구 게임을 시작합니다.");
    }

    @Test
    void 숫자_입력_요구_메시지() {
        assertThat(outputView.numberInputMessage()).isEqualTo("숫자를 입력해주세요 :");
    }

    @Test
    void 게임_재시작_물음_메시지() {
        assertThat(outputView.restartGameMessage()).isEqualTo("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
    }
}
