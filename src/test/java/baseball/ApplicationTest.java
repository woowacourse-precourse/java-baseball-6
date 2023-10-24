package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

    @ParameterizedTest
    @DisplayName("허용되지 않는 값 입력")
    @ValueSource(strings = {"012", "!@#", "A23"})
    void inputNotAllowedFailTest(String line) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(line))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @ParameterizedTest
    @DisplayName("중복된 값 입력")
    @ValueSource(strings = {"111", "112", "121", "211"})
    void inputDuplicatedFailTest(String line) {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException(line))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("모든 결과 경우의 수 테스트")
    void allGameResultTest() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456",
                            "345", "315", "312",
                            "145", "142", "132",
                            "143", "123", "2");
                    assertThat(output()).contains("낫싱",
                            "1볼", "2볼", "3볼",
                            "1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크",
                            "2스트라이크", "3스트라이크");
                },
                1, 2, 3
        );
    }
}
