package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import org.junit.jupiter.api.Assertions;
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
    void 게임_시작_문구는_한번만_출력된다() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("521", "524", "1", "718", "1", "352", "2");
                    long count = Arrays.stream(output().split("\n"))
                            .filter(line -> line.contains("숫자 야구 게임을 시작합니다."))
                            .count();
                    Assertions.assertEquals(1, count);
                },
                5, 2, 4, 7, 1, 8, 3, 5, 2
        );
    }

    @Test
    void 재시작_명령어_예외_테스트() {
        assertThatThrownBy(() -> assertRandomNumberInRangeTest(() -> {
                    run("798", "3");
                },
                7, 9, 8
        )).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
