package baseball;

import baseball.view.InputConsole;
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

    @Test
    void 메시지확인_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run(
                            "246", "135", "1",
                            "512", "597", "589", "1",
                            "651", "657", "567", "2");
                    assertThat(output()).contains(
                            "숫자 야구 게임을 시작합니다.", "숫자를 입력해주세요 : ",
                            "낫싱", "3스트라이크",
                            "3개의 숫자를 모두 맞히셨습니다! 게임 종료\n게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.",
                            "1볼", "1볼 1스트라이크", "3스트라이크",
                            "2볼", "2볼 1스트라이크", "3스트라이크", "게임 종료"
                    );
                },
                1, 3, 5, 5, 8, 9, 5, 6, 7
        );
    }

    @Test
    void 숫자_범위_성공_테스트() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("123", "789", "135", "2");
                    assertThat(output()).contains("1볼 1스트라이크", "낫싱", "3스트라이크");

                },
                1, 3, 5
        );
    }

    @Test
    void 숫자_범위_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("111", "122", "988", "999", "1234", "101", "99", "48", "100"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 문자_입력_예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12o", "a75", "5b7","$26", "5&6", "57>", "test", "!&$"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 시작_종료_입력_예외_테스트1() {
        try {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "a");
                        assertThat(output()).contains("3스트라이크");
                    },
                    1,2,3
            );
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void 시작_종료_입력_예외_테스트2() {
        try {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "27");
                        assertThat(output()).contains("3스트라이크");
                    },
                    1,2,3
            );
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Test
    void 시작_종료_입력_예외_테스트3() {
        try {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("123", "5");
                        assertThat(output()).contains("3스트라이크");
                    },
                    1,2,3
            );
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
