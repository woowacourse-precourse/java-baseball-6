package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
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
                assertThatThrownBy(() ->
                    runException("1234")
                )
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_3자리숫자입력부분_문자입력() {
        assertSimpleTest(() ->
                assertThatThrownBy(() ->
                        runException("abc")
                )
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 예외_테스트_다시시작입력부분_숫자외의입력() {
        assertThatThrownBy(() -> {
            run("246", "135", "1", "597", "589", "3");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Test
    void 예외_테스트_다시시작입력부분_문자입력() {
        assertThatThrownBy(() -> {
            run("246", "135", "1", "597", "589", "abc");
        }).isInstanceOf(IllegalArgumentException.class);
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
