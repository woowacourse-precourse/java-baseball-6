package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CustomApplicationTest extends NsTest {
    @Test
    void 게임종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 게임_3번_반복() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "1", "867", "768", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다!", "게임 종료");
                },
                1, 3, 5, 5, 8, 9, 7, 6, 8
        );
    }

    @Test
    void 숫자가_아닌_문자_사용자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("asd"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 길이가_긴_문자_사용자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("_+_+_1233"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 범위_밖의_숫자_사용자_입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
