package baseball;

import camp.nextstep.edu.missionutils.Randoms;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Test
    public void pickNumberInRange테스트() throws Exception{
        //given
        int num1 = 1;
        int num2 = 9;

        //when
        int result = Randoms.pickNumberInRange(1, 9);

        //then
        assertThat(result).isGreaterThanOrEqualTo(num1).isLessThanOrEqualTo(num2);
    }

    @Test
    public void compareNumber볼테스트() throws Exception {
        //given
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);
        Baseball baseball = new Baseball();

        //when
        String result = baseball.compareNumber(computerNumber, 1, 2);

        //then
        assertThat("볼").isEqualTo(result);
    }

    @Test
    public void compareNumber스트라이크테스트() throws Exception {
        //given
        List<Integer> computerNumber = Arrays.asList(1, 2, 3);
        Baseball baseball = new Baseball();

        //when
        String result = baseball.compareNumber(computerNumber, 1, 0);

        //then
        assertThat("스트라이크").isEqualTo(result);
    }
}
