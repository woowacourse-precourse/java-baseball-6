package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ApplicationTest extends NsTest {
    @Test
    @DisplayName("게임종료 후 재시작")
    void test1() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    @DisplayName("게임종료")
    void test2() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("136", "135", "2");
                    assertThat(output()).contains("2스트라이크", "3스트라이크");
                },
                1,3,5
        );
    }

    @Test
    @DisplayName("예외 테스트: 3자리 숫자가 아닌 경우")
    void test3() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트: 서로 다른 숫자가 아닌 경우")
    void test4() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("133"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트: 숫자가 아닌 다른 문자열을 입력한 경우")
    void test5() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("rks@!"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("예외 테스트: 빈 문자열을 입력한 경우")
    void test6() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(" "))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
