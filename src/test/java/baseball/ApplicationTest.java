package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.entity.Hint;
import camp.nextstep.edu.missionutils.test.NsTest;
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
    void 중복숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("a12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("012"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 스트라이크_테스트() {
        Hint hint = new Hint();

        String randomNumber = "123";
        String inputNumber = "123";

        hint.generateHint(randomNumber, inputNumber);

        String expected = "3스트라이크";
        assertEquals(expected, output());
    }

    @Test
    void 볼_스트라이크_테스트() {
        Hint hint = new Hint();

        String randomNumber = "123";
        String inputNumber = "321";

        hint.generateHint(randomNumber, inputNumber);

        String expected = "2볼 1스트라이크";
        assertEquals(expected, output());
    }

    @Test
    void 낫싱_테스트() {
        Hint hint = new Hint();

        String randomNumber = "123";
        String inputNumber = "456";

        hint.generateHint(randomNumber, inputNumber);

        String expected = "낫싱";
        assertEquals(expected, output());
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

}
