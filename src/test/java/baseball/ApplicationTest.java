package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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
    void 게임종료_후_재시작_잘못된_입력_종료이후_다시하기() {
        assertThatThrownBy(() -> {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "3");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "12");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "#");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "a");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );

        }).isInstanceOf(IllegalArgumentException.class);
    }


    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            assertThatThrownBy(() -> runException("1234"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> runException("abc"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> runException("112"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> runException("ㄱㄴㄷ"))
                    .isInstanceOf(IllegalArgumentException.class);
            assertThatThrownBy(() -> runException("#$!"))
                    .isInstanceOf(IllegalArgumentException.class);
        });
    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
