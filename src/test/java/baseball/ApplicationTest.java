package baseball;

import baseball.entity.CorrectNumber;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    void 게임종료후입력_예외처리() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "125"))
                            .isInstanceOf(IllegalArgumentException.class);
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 입력과_정답비교() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "159", "597", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 정답생성_각자리_중복확인() {
        // given
        CorrectNumber correctNumber = new CorrectNumber();

        // when
        correctNumber.generateCorrectNumbers();

        // then
        List<Integer> correctNumberList = correctNumber.getCorrectNumbers();
        for (int i = 0; i < correctNumberList.size(); i++) {
            for (int j = 0; j < correctNumberList.size(); j++) {
                if (i != j) { // 같은 위치는 비교하지 않는다.
                    assertThat(correctNumberList.get(i)).isNotEqualTo(correctNumberList.get(j));
                }
            }
        }
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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
