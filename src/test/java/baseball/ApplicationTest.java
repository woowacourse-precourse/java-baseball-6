package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.controller.Core;
import baseball.controller.Generator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    @Test
    void generateAnswer() {
        // given
        Generator generator = new Generator();
        int listLen = 3;

        // when
        List<Integer> result = generator.generateAnswer(listLen);

        // then
        assertThat(result.size()).as("list size").isEqualTo(listLen);

        List<Integer> check = new ArrayList<>();
        for (int num : result) {
            assertThat(false).as("duplication").isEqualTo(check.contains(num));
            check.add(num);
        }
    }

    @Test
    void isNotOver() {
        // given
        Core core = new Core();
        int case1 = 0;
        int case2 = 1;
        int case3 = 2;
        int case4 = 3;

        // when
        boolean result1 = core.isNotOver(case1);
        boolean result2 = core.isNotOver(case2);
        boolean result3 = core.isNotOver(case3);
        boolean result4 = core.isNotOver(case4);

        // then
        assertThat(true).as("nothing").isEqualTo(result1);
        assertThat(true).as("1 strike").isEqualTo(result3);
        assertThat(true).as("2 strike").isEqualTo(result2);
        assertThat(false).as("3 strike").isEqualTo(result4);
    }

    @Test
    void countBall() {
        // given
        Core core = new Core();
        List<List<Integer>> case1 = List.of(List.of(1, 2, 3), List.of(4, 5, 6)); // nothing
        List<List<Integer>> case2 = List.of(List.of(1, 2, 3), List.of(4, 1, 6)); // 1 ball
        List<List<Integer>> case3 = List.of(List.of(1, 2, 3), List.of(4, 1, 2)); // 2 ball
        List<List<Integer>> case4 = List.of(List.of(1, 2, 3), List.of(3, 1, 2)); // 3 ball
        List<List<Integer>> case5 = List.of(List.of(1, 2, 3), List.of(1, 5, 6)); // 1 strike
        List<List<Integer>> case6 = List.of(List.of(1, 2, 3), List.of(1, 3, 6)); // 1 strike 1 ball
        List<List<Integer>> case7 = List.of(List.of(1, 2, 3), List.of(1, 3, 2)); // 1 strike 2 ball
        List<List<Integer>> case8 = List.of(List.of(1, 2, 3), List.of(1, 2, 6)); // 2 strike
        List<List<Integer>> case9 = List.of(List.of(1, 2, 3), List.of(1, 2, 3)); // 3 strike

        // when
        int result1 = core.countBall(case1.get(0), case1.get(1));
        int result2 = core.countBall(case2.get(0), case2.get(1));
        int result3 = core.countBall(case3.get(0), case3.get(1));
        int result4 = core.countBall(case4.get(0), case4.get(1));
        int result5 = core.countBall(case5.get(0), case5.get(1));
        int result6 = core.countBall(case6.get(0), case6.get(1));
        int result7 = core.countBall(case7.get(0), case7.get(1));
        int result8 = core.countBall(case8.get(0), case8.get(1));
        int result9 = core.countBall(case9.get(0), case9.get(1));

        // then
        assertThat(0).as("nothing").isEqualTo(result1);
        assertThat(1).as("1 ball").isEqualTo(result2);
        assertThat(2).as("2 ball").isEqualTo(result3);
        assertThat(3).as("3 ball").isEqualTo(result4);
        assertThat(0).as("1 strike").isEqualTo(result5);
        assertThat(1).as("1 strike 2 ball").isEqualTo(result6);
        assertThat(2).as("1 strike 2 ball").isEqualTo(result7);
        assertThat(0).as("2 strike").isEqualTo(result8);
        assertThat(0).as("3 strike").isEqualTo(result9);
    }


    @Test
    void countStrike() {
        // given
        Core core = new Core();
        List<List<Integer>> case1 = List.of(List.of(1, 2, 3), List.of(4, 5, 6)); // nothing
        List<List<Integer>> case2 = List.of(List.of(1, 2, 3), List.of(4, 1, 6)); // 1 ball
        List<List<Integer>> case3 = List.of(List.of(1, 2, 3), List.of(4, 1, 2)); // 2 ball
        List<List<Integer>> case4 = List.of(List.of(1, 2, 3), List.of(3, 1, 2)); // 3 ball
        List<List<Integer>> case5 = List.of(List.of(1, 2, 3), List.of(1, 5, 6)); // 1 strike
        List<List<Integer>> case6 = List.of(List.of(1, 2, 3), List.of(1, 3, 6)); // 1 strike 1 ball
        List<List<Integer>> case7 = List.of(List.of(1, 2, 3), List.of(1, 3, 2)); // 1 strike 2 ball
        List<List<Integer>> case8 = List.of(List.of(1, 2, 3), List.of(1, 2, 6)); // 2 strike
        List<List<Integer>> case9 = List.of(List.of(1, 2, 3), List.of(1, 2, 3)); // 3 strike

        // when
        int result1 = core.countStrike(case1.get(0), case1.get(1));
        int result2 = core.countStrike(case2.get(0), case2.get(1));
        int result3 = core.countStrike(case3.get(0), case3.get(1));
        int result4 = core.countStrike(case4.get(0), case4.get(1));
        int result5 = core.countStrike(case5.get(0), case5.get(1));
        int result6 = core.countStrike(case6.get(0), case6.get(1));
        int result7 = core.countStrike(case7.get(0), case7.get(1));
        int result8 = core.countStrike(case8.get(0), case8.get(1));
        int result9 = core.countStrike(case9.get(0), case9.get(1));

        // then
        assertThat(0).as("nothing").isEqualTo(result1);
        assertThat(0).as("1 ball").isEqualTo(result2);
        assertThat(0).as("2 ball").isEqualTo(result3);
        assertThat(0).as("3 ball").isEqualTo(result4);
        assertThat(1).as("1 strike").isEqualTo(result5);
        assertThat(1).as("1 strike 2 ball").isEqualTo(result6);
        assertThat(1).as("1 strike 2 ball").isEqualTo(result7);
        assertThat(2).as("2 strike").isEqualTo(result8);
        assertThat(3).as("3 strike").isEqualTo(result9);
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
