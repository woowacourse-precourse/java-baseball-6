package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
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
                    run("246", "135", "1", "597", "125", "925", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "1볼", "2볼", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 입력_길이_예외_테스트() {

        //입력 값이 3자리 초과인 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        //입력 값이 1자리인 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        //입력 값이 2자리인 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_입력_예외_테스트() {
        //입력 값에 문자가 포함된 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        //개행 문자 입력시
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("\n"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_입력_범위_예외_테스트() {
        // 입력 값 음수인 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("-123"))
                        .isInstanceOf(IllegalArgumentException.class)
        );

        // 입력 값 0이 포함되는 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("202"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 입력_중복_숫자_예외_테스트() {
        //입력 값에 중복이 있는 경우
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
