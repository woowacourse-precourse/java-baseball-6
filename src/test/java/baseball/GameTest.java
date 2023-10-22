package baseball;

import baseball.util.ErrorMessage;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class GameTest extends NsTest {

    @Test
    void 간단_게임_성공() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 복잡_게임_성공() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "124", "163", "153", "135", "2");
                    assertThat(output()).contains("낫싱", "1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 복잡_게임_성공_후_재시도() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "124", "163", "153", "135", "1", "642", "624", "2");
                    assertThat(output()).contains("낫싱", "1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 6, 2, 4
        );
    }

    @Test
    void 리트라이_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("246", "124", "163", "153", "135", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessageContaining(ErrorMessage.RETRY_COMMAND_ERROR);
                    assertThat(output()).contains("낫싱", "1스트라이크", "1볼 1스트라이크", "2볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5
        );
    }

    @Test
    void 길이_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.LENGTH_ERROR)
        );
    }

    @Test
    void 중복_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.DUPLICATE_ERROR)
        );
    }

    @Test
    void 제로_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.ZERO_ERROR)
        );
    }

    @Test
    void 문자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("aaa"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessageContaining(ErrorMessage.NUMERIC_ERROR)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
