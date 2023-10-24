package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class BaseballTest extends NsTest {

    private static final BaseballGame baseballGame = new BaseballGame();

    @Test
    void 게임진행_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "513", "735", "153", "135", "2");
                    assertThat(output()).contains("낫싱", "3볼", "2스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 게임진행_예외_테스트() {

        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("162", "1A3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );

    }

    @Test
    void 종료후_재시작_예외_테스트() {

        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "3"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );

    }

    @Override
    protected void runMain() {
        baseballGame.start();
    }
}
