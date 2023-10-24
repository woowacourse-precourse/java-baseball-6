package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
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

    @Test
    void 스트라이크_개수_테스트() {
        List<Integer> userInput1 = Arrays.asList(1, 2, 3);
        List<Integer> userInput2 = Arrays.asList(4, 7, 8);
        List<Integer> userInput3 = Arrays.asList(4, 2, 6);
        List<Integer> userInput4 = Arrays.asList(4, 5, 6);
        List<Integer> result = Arrays.asList(4, 5, 6);

        assertThat(Application.getStrikeCount(userInput1, result)).isEqualTo(0);
        assertThat(Application.getStrikeCount(userInput2, result)).isEqualTo(1);
        assertThat(Application.getStrikeCount(userInput3, result)).isEqualTo(2);
        assertThat(Application.getStrikeCount(userInput4, result)).isEqualTo(3);
    }

    @Test
    void 볼_개수_테스트() {
        List<Integer> userInput1 = Arrays.asList(1, 2, 3);
        List<Integer> userInput2 = Arrays.asList(7, 4, 8);
        List<Integer> userInput3 = Arrays.asList(5, 6, 7);
        List<Integer> userInput4 = Arrays.asList(6, 4, 5);
        List<Integer> result = Arrays.asList(4, 5, 6);

        assertThat(Application.getBallCount(userInput1, result)).isEqualTo(0);
        assertThat(Application.getBallCount(userInput2, result)).isEqualTo(1);
        assertThat(Application.getBallCount(userInput3, result)).isEqualTo(2);
        assertThat(Application.getBallCount(userInput4, result)).isEqualTo(3);
    }

    @Test
    void 서로_다른_랜덤숫자_테스트() {
        List<Integer> threeRandomNumber = Application.getThreeRandomNumber();

        boolean isNumber = Application.isNumber(threeRandomNumber);
        boolean isDifferentNumber = Application.isDifferentRandomNumber(threeRandomNumber);

        assertThat(isNumber).isEqualTo(true);
        assertThat(isDifferentNumber).isEqualTo(true);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
