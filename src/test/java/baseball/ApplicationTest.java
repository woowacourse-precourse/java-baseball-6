package baseball;

import baseball.controller.GameController;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {

    @BeforeEach
    void playing_변수_초기화() {
        GameController.playing = true;
    }

    @Test
    void 스트라이크만_존재할_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("168", "193", "197", "2");
                    assertThat(output()).contains("1스트라이크", "2스트라이크", "3스트라이크");
                },
                1, 9, 7
        );
    }

    @Test
    void 볼만_존재할_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("451", "234", "312", "123", "2");
                    assertThat(output()).contains("1볼", "2볼", "3볼");
                },
                1, 2, 3
        );
    }


    @Test
    void 볼과_스트라이크_둘다_존재할_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("726", "728", "782", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "2볼 1스트라이크");
                },
                7, 8, 2
        );
    }

    @Test
    void 볼과_스트라이크_둘다_존재하지_않을_경우() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("136", "248", "368", "579", "2");
                    assertThat(output()).contains("낫싱");
                },
                5,7,9
        );
    }

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_두자리수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("98"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_0을_포함한수() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("507"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_중복된_숫자() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("223"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_문자열() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("문자열"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 예외_테스트_문자열_숫자_혼합() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("문1자2열"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
