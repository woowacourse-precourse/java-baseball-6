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
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 세번_연속_스트라이크() {
        assertRandomNumberInRangeTest(() -> {
                    run("123", "1", "456", "1", "789", "2");
                    assertThat(output()).contains("3스트라이크", "3스트라이크", "3스트라이크");
                },
                1, 2, 3, 4, 5, 6, 7, 8, 9
        )
        ;
    }

    @Test
    void 두번_반복_진행() {
        assertRandomNumberInRangeTest(() -> {
                    run("245", "132", "123", "1", "941", "127", "192", "2");
                    assertThat(output()).contains("1볼", "2볼 1스트라이크", "3스트라이크", "2볼", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                }, 1, 2, 3, 1, 9, 2
        )
        ;
    }

    @Test
    void 리드미_동일내용() {
        assertRandomNumberInRangeTest(() -> {
                    run("123", "145", "671", "216", "713", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "1볼", "2볼", "1스트라이크", "3스트라이크", "게임 종료");
                }, 7, 1, 3
        );
    }

    @Test
    void 기능요구사항_동일내용() {
        assertRandomNumberInRangeTest(() -> {
                    run("123", "456", "789", "425", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "낫싱", "3스트라이크", "게임 종료");
                }, 4, 2, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}