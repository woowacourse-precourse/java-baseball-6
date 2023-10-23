package baseball;

import baseball.view.RetryInputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @DisplayName("세 자리 숫자가 아닌 숫자를 입력했을 시 예외발생")
    @Test
    void wrongSizeTest() {
        assertThatThrownBy(() -> runException("13")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("중복된 숫자가 존재하는 세 자리 숫자를 입력했을 시 예외발생")
    @Test
    void numberDuplicationTest() {
        assertThatThrownBy(() -> runException("133")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("재시작 시 1이나 2이외의 숫자를 입력했을 때 예외 발생")
    @Test
    void retryInputTest() {


    }


    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
