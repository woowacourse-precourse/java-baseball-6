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
    void 예외_자릿수_메시지_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 입력입니다.(3자리 숫자만 허용)")
        );
    }

    @Test
    void 예외_문자입력_메시지_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("abc"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 입력입니다.(숫자만 허용)")
        );
    }

    @Test
    void 예외_중복_메시지_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("222"))
                        .isInstanceOf(IllegalArgumentException.class)
                        .hasMessage("잘못된 입력입니다.(중복 불가)")
        );
    }

    @Test
    void 예외_종료여부_메시지_테스트() {
        assertThatThrownBy(() ->
                assertRandomNumberInRangeTest(() ->
                        {
                            runException("589", "333");
                            assertThat(output()).contains("3스트라이크");
                        },
                        5, 8, 9
                )
        ).isInstanceOf(IllegalArgumentException.class).hasMessage("잘못된 입력입니다.(1 또는 2 입력)");
    }
}
