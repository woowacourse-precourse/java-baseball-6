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
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @DisplayName("3회 게임 진행")
    @Test
    void 게임_3회_진행_후_정상종료() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("861", "1", "254", "1", "731", "2");
                    assertThat(output()).contains("3스트라이크", "3스트라이크", "3스트라이크", "게임 종료");
                },
                8, 6, 1, 2, 5, 4,7,3,1
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }


    @DisplayName("게임 1회 진행 후 비정상 종료, 재시작 커맨드 입력시 1보다 긴 입력으로 인한 예외")
    @Test
    void 게임_1회진행_후_비정상종료1() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "23"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력 길이 초과입니다. 입력길이 : [2],  예상 길이: [1]");
                },
                1, 3, 5
        );
    }

    @DisplayName("게임 1회 진행 후 비정상 종료, 재시작 커맨드 입력시 숫자가 아닌 입력으로 인한 예외")
    @Test
    void 게임_1회진행_후_비정상종료2() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "a"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력이 숫자가 아닙니다. 입력한 문자 : [a]");
                },
                1, 3, 5
        );
    }

    @DisplayName("게임 1회 진행 후 비정상 종료, 재시작 커맨드 입력시 숫자가 1,2가 아닌 숫자 인한 예외")
    @Test
    void 게임_1회진행_후_비정상종료3() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("135", "3"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력이 1혹은 2가 아닙니다. 입력한 문자 : [3]");
                },
                1, 3, 5
        );
    }

    @DisplayName("게임 1회 진행 중 비정상 종료, 커맨드 입력시 3보다 긴 입력으로 인한 예외")
    @Test
    void 게임_1회진행_비정상종료1() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("132", "1234"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력 길이 초과입니다. 입력길이 : [4],  예상 길이: [3]");
                },
                1, 3, 5
        );
    }

    @DisplayName("게임 1회 진행 중 비정상 종료, 재시작 커맨드 입력시 숫자가 아닌 입력으로 인한 예외")
    @Test
    void 게임_1회진행_비정상종료2() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123", "aasd"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력이 숫자가 아닙니다. 입력한 문자 : [aasd]");
                },
                1, 3, 5
        );
    }

    @DisplayName("게임 1회 진행 중 비정상 종료, 중복된 입력으로 인한 예외")
    @Test
    void 게임_1회진행_비정상종료3() {
        assertRandomNumberInRangeTest(
                () -> {
                    assertThatThrownBy(() -> runException("123", "111"))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("입력에서 중복된 숫자가 존재합니다.");
                },
                1, 3, 5
        );
    }



    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
