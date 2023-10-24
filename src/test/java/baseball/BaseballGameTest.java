package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class BaseballGameTest extends NsTest {

    @Test
    @DisplayName("게임 종료 후 재시작 테스트를 2 번 할 수 있다.")
    void gameRestartTest() {

        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "1", "246", "124", "123", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "1볼", "2스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9, 1, 2, 3
        );
    }

    @Test
    @DisplayName("게임 진행 중 문자를 입력할 경우 예외가 발생한다.")
    void gameThrowTest() {

        assertThatThrownBy(() -> run("246", "13a"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("게임 진행 중 공백을 입력할 경우 예외가 발생한다.")
    void gameBlankInputThrowTest() {

        assertThatThrownBy(() -> run("246", "13 "))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }

    @Test
    @DisplayName("게임 진행 중 특수문자를 입력할 경우 예외가 발생한다.")
    void gameSpecialLettersInputThrowTest() {

        assertThatThrownBy(() -> run("246", "13!"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다.");
    }



    @Test
    @DisplayName("게임 재시작 할 때 문자를 입력한 경우 예외가 발생한다.")
    void gameRestartInputStringThrowTest() {

        assertRandomNumberInRangeTest(() -> assertThatThrownBy(
                () -> run("123", "a"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다."), 1, 2, 3);
    }

    @Test
    @DisplayName("게임 재시작 할 때 공백을 입력할 경우 예외가 발생한다.")
    void gameRestartInputBlankThrowTest() {

        assertRandomNumberInRangeTest(() -> assertThatThrownBy(
                () -> run("123", " "))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다."), 1, 2, 3);
    }

    @Test
    @DisplayName("게임 재시작 할 때 특수문자를 입력할 경우 예외가 발생한다.")
    void gameRestartInputSpecialLettersThrowTest() {

        assertRandomNumberInRangeTest(() -> assertThatThrownBy(
                () -> run("123", "!"))
                .isInstanceOf(RuntimeException.class)
                .hasMessageContaining("[ERROR] 숫자만 입력 가능합니다."), 1, 2, 3);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
