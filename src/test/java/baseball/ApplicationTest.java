package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.core.Core;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
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

    /* 유닛 테스트 코드 대원칙
     * - given(준비): 어떤 데이터가 준비되었을 때
     * - when(실행): 어떠한 함수를 실행하면
     * - then(검증): 어떠한 결과가 나와야한다.
     * 위 구조를 지키며 작성한다.
     * */
    @Test
    void 스트라이크_개수() {
        // given
        final List<Integer> computerNumbers = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        final List<Integer> playerNumbers = new ArrayList<>() {
            {
                add(1);
                add(9);
                add(5);
            }
        };

        // when
        Core core = new Core();
        int result = core.countStrike(computerNumbers, playerNumbers);

        // then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void 볼_개수() {
        // given
        final List<Integer> computerNumbers = new ArrayList<>() {
            {
                add(1);
                add(2);
                add(5);
            }
        };
        final List<Integer> playerNumbers = new ArrayList<>() {
            {
                add(3);
                add(4);
                add(7);
            }
        };

        // when
        Core core = new Core();
        int result = core.countBall(computerNumbers, playerNumbers);

        // then
        assertThat(result).isEqualTo(0);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
