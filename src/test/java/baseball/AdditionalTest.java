package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class AdditionalTest extends NsTest {

    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("124", "123", "1", "123", "789", "654", "456","2");
                    assertThat(output()).contains(
                            "2스트라이크", "3스트라이크", "낫싱", "낫싱", "2볼 1스트라이크", "3스트라이크", "게임 종료"
                    );
                },
                1, 2, 3, 4, 5, 6
        );
    }
    @Test
    void 중복숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("133","444"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자_0포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("120","000"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 숫자_자릿수_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1","12"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Test
    void 입력값_타입_예외테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("kim","!@#","12A","김민제"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }
    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}