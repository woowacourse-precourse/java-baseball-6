package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class IntegrationTest extends NsTest {

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @Nested
    @DisplayName("프로그램이 성공적으로 실행되고 종료된다.")
    class Success {

        @DisplayName("게임을 재시작하고 종료하는 경우")
        @Test
        void restart() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "1", "597", "589", "2");
                        assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 3, 5, 5, 8, 9
            );
        }

        @DisplayName("게임을 한 번 하고 종료하는 경우")
        @Test
        void play1game() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run("246", "135", "123", "2");
                        assertThat(output()).contains("1볼", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                    },
                    1, 2, 3
            );
        }
    }

    @Nested
    @DisplayName("예외가 발생하여 프로그램이 종료된다.")
    class Failure {

        @DisplayName("숫자 야구 입력 시 3보다 많은 숫자를 입력한 경우")
        @Test
        void InvalidBaseballRange() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException("1234"))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("숫자 야구 입력 시 1~9가 아닌 문자를 입력한 경우")
        @ValueSource(strings = {"012", "   ", "\n\n\n", "NULL", "'''", "@#$"})
        @ParameterizedTest
        void InvalidBaseballInput(String input) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("숫자 야구 입력 시 서로 중복되는 문자를 입력한 경우")
        @ValueSource(strings = {"111", "112", "344", "616"})
        @ParameterizedTest
        void DuplicatedBaseballInput(String input) {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("게임 진행 여부 입력 시 1이나 2가 아닌 문자를 입력한 경우")
        @ValueSource(strings = {"3", "0", "@#$", "c", " ", "\n"})
        @ParameterizedTest
        void InvalidRestartInput(String input) {
            assertRandomNumberInRangeTest(
                    () -> assertThatThrownBy(
                            () -> runException("246", "135", input))
                            .isInstanceOf(IllegalArgumentException.class), 1, 3, 5);
        }
    }
}