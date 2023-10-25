package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
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
    @DisplayName("입력에 문자 포함되어 있는 경우 예외가 발생해야 한다.")
    void 문자_포함_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12c"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("입력에 중복된 숫자가 있는 경우 예외가 발생해야 한다.")
    void 중복_숫자_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("112"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    @DisplayName("재시작 입력에 문자가 있는 경우 예외가 발생해야 한다.")
    void 재시작_입력_문자_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(
                        () -> run("135", "a")
                ),
                1, 3, 5
        );
    }

    @Test
    @DisplayName("재시작 입력의 길이가 2 이상인 경우 예외가 발생해야 한다.")
    void 재시작_입력_길이_2이상_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(
                        () -> run("135", "12")
                ),
                1, 3, 5
        );
    }

    @Test
    @DisplayName("재시작 입력의 길이가 1 미만인 경우 예외가 발생해야 한다.")
    void 재시작_입력_길이_1미만_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(
                        () -> run("135", "")
                ),
                1, 3, 5
        );
    }

    @Test
    @DisplayName("재시작 입력이 1 또는 2가 아닌 경우 예외가 발생해야 한다.")
    void 재시작_입력_예외_테스트() {
        assertRandomNumberInRangeTest(
                () -> assertThatThrownBy(
                        () -> run("135", "3")
                ),
                1, 3, 5
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}

