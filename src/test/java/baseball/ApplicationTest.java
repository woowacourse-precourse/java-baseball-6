package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
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
    void 게임종료_입력_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "12"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5
        );
    }
    @Test
    void 문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("S23"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자_예외_2개_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("21"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자_예외_중복_숫자_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("121"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 정상_작동_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("523", "781", "572", "597", "759", "579", "2");
                    assertThat(output()).contains("1스트라이크", "1볼", "2스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                5, 7, 9
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
