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
    void 잘못된_숫자_입력_예외_테스트() {
        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() -> runException("2465", "135", "2"))
                                .isInstanceOf(IllegalArgumentException.class),
                1, 3, 5
        );

        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() -> runException("000", "135", "2"))
                                .isInstanceOf(IllegalArgumentException.class),
                1, 3, 5
        );

        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() -> runException("112", "135", "2"))
                                .isInstanceOf(IllegalArgumentException.class),
                1, 3, 5
        );

        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() -> runException("3", "135", "2"))
                                .isInstanceOf(IllegalArgumentException.class),
                1, 3, 5
        );
    }

    @Test
    void 잘못된_재시작_명령어_예외_테스트() {
        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() -> runException("246", "135", "3"))
                                .isInstanceOf(IllegalArgumentException.class),
                1, 3, 5
        );

        assertRandomNumberInRangeTest(() ->
                        assertThatThrownBy(() -> runException("246", "135", "asd"))
                                .isInstanceOf(IllegalArgumentException.class),
                1, 3, 5
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
