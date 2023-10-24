package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
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
    void 중복수_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("191"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 게임시작() {
        // given
        final BaseBallGame Game = new BaseBallGame();
        final Check check = new Check();
        final List<List<Integer>> user = List.of(
                List.of(7, 2, 5),
                List.of(7, 5, 2),
                List.of(8, 3, 6));
        final List<Integer> computer = List.of(7, 5, 4);
        int i = 0;
        // when
        do {
            check.compareNumber(user.get(i), computer);
            i++;
        } while (i!=user.size());

        // then
        assertThat(output().split("\n")).containsExactly(
                "1볼 1스트라이크",
                "2스트라이크",
                "낫싱");
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
