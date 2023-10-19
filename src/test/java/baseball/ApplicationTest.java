package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

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
}
