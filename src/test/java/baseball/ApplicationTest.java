package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertThrows;

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
    public void 사용자_입력_테스트_올바른_값() {
        // given
        String[] userNumber = new String[] {"1", "2", "3"};

        // when
        boolean correctNumber = Application.isCorrectNumber(userNumber);

        // then
        Assertions.assertThat(correctNumber).isTrue();
    }

    @Test
    public void 사용자_입력_테스트_제로_입력() throws IllegalArgumentException {
        // given
        String[] userNumber = new String[] {"0", "2", "2"};

        // when


        // then
        assertThrows(IllegalArgumentException.class, () -> Application.isCorrectNumber(userNumber));
    }

    @Test
    public void 사용자_입력_테스트_중복값() throws IllegalArgumentException {
        // given
        String[] userNumber = new String[] {"1", "2", "2"};

        // when


        // then
        assertThrows(IllegalArgumentException.class, () -> Application.isCorrectNumber(userNumber));
    }

    @Test
    public void 사용자_입력_테스트_문자() throws IllegalArgumentException {
        // given
        String[] userNumber = new String[] {"1", "2", "abc"};

        // when


        // then
        assertThrows(IllegalArgumentException.class, () -> Application.isCorrectNumber(userNumber));
    }

    @Test
    public void 사용자_입력_테스트_길이_초과() throws IllegalArgumentException {
        // given
        String[] userNumber = new String[] {"1", "2", "3", "4"};

        // when


        // then
        assertThrows(IllegalArgumentException.class, () -> Application.isCorrectNumber(userNumber));
    }

    @Test
    public void 접수_집계_테스트() throws Exception {
        Computer computer = new Computer();
        // given
        // 테스트 1
        List<Integer> computerPickNumber1 = new ArrayList<>(Arrays.asList(1, 2, 3));
        List<Integer> userNumber1 = new ArrayList<>(Arrays.asList(1, 2, 3));

        // 테스트 2
        List<Integer> computerPickNumber2 = new ArrayList<>(Arrays.asList(1, 2, 5));
        List<Integer> userNumber2 = new ArrayList<>(Arrays.asList(1, 2, 3));

        // when
        int[] score1 = computer.calculateScore(computerPickNumber1, userNumber1);
        int[] score2 = computer.calculateScore(computerPickNumber2, userNumber2);

        // then
        Assertions.assertThat(score1.length).isEqualTo(2);
        Assertions.assertThat(score1[0]).isEqualTo(3);  // 3 스트라이크
        Assertions.assertThat(score1[1]).isEqualTo(0);  // 0 볼

        Assertions.assertThat(score2.length).isEqualTo(2);
        Assertions.assertThat(score2[0]).isEqualTo(2);  // 2 스트라이크
        Assertions.assertThat(score2[1]).isEqualTo(0);  // 0볼
    }
}
