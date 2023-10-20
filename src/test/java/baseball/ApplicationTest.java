package baseball;

import baseball.domain.GameStandard;
import baseball.domain.Judge;
import baseball.domain.NumbersGenerate;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    GameStandard gameStandard;
    Judge judge;


    @BeforeEach
    void setUp() {
        gameStandard = new GameStandard();
        judge = new Judge();
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

    @DisplayName("심판의 유저의 게임 진행 상황 확인, 볼, 스트라이크, 낫싱")
    @Test
    public void baseballGameInspectionTest() throws Exception {
        // given
        List<Integer> computerList = new ArrayList<>(List.of(1, 2, 3));
        List<List<Integer>> numInputUser = new ArrayList<>(List.of(
                // 3스트라이크
                List.of(1, 2, 3),
                // 2스트라이크
                List.of(1, 2, 4),
                // 2볼 1스트라이크
                List.of(1, 3, 2),
                // 1볼 1스트라이크
                List.of(1, 8, 2),
                // 1스트라이크
                List.of(1, 8, 4),
                // 1볼
                List.of(4, 1, 6),
                // 2볼
                List.of(7, 1, 2),
                // 3볼
                List.of(3, 1, 2),
                // 낫싱
                List.of(7, 9, 8)
        ));

        List<String> hints = new ArrayList<>(
                List.of(
                        "3스트라이크",
                        "2스트라이크",
                        "2볼 1스트라이크",
                        "1볼 1스트라이크",
                        "1스트라이크",
                        "1볼 ",
                        "2볼 ",
                        "3볼 ",
                        "낫싱"
                )
        );
        String resultHint = "";
        List<String> hintResult = new ArrayList<>();

        // when
        for (List<Integer> numList : numInputUser) {
            resultHint = judge.baseballGameInspection(computerList, numList);
            hintResult.add(resultHint);
        }

        // then
        assertThat(hintResult).containsAll(hints);
    }
}
