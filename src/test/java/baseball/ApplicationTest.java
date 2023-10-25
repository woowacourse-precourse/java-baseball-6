package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.View.ConsoleView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(() -> {
            run("246", "135", "1", "597", "589", "2");
            assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
        }, 1, 3, 5, 5, 8, 9);
    }

    @Test
    void 볼_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("345", "316", "312", "123", "2");
            assertThat(output()).contains("1볼", "2볼", "3볼", "3스트라이크", "게임 종료");
        }, 1, 2, 3);
    }

    @Test
    void 스트라이크_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("156", "127", "123", "2");
            assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크", "게임 종료");
        }, 1, 2, 3);
    }

    @Test
    void 볼_스트라이크_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("413", "132", "123", "2");
            assertThat(output()).contains("1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
        }, 1, 2, 3);
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("1234")).isInstanceOf(IllegalArgumentException.class));
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("aaa")).isInstanceOf(IllegalArgumentException.class));
        assertSimpleTest(
                () -> assertThatThrownBy(() -> runException("121")).isInstanceOf(IllegalArgumentException.class));
    }

    @Test
    void 재시작_입력_예외테스트() {
        final String replayChoose = "3";
        final ConsoleView consoleView = new ConsoleView();

        assertThatThrownBy(() -> consoleView.handleReplayException(replayChoose)).isInstanceOf(
                IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
