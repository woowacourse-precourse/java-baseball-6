package baseball.model.generator;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerNumberGeneratorTest {
    private final PlayerNumberGenerator playerNumberGenerator = new PlayerNumberGenerator();

    @Nested
    class generateListTest extends NsTest {
        @Test
        void 입력값이_3글자_초과일_경우_예외() {
            String input = "1234";

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("3개의 숫자를 입력해주세요.")
            );
        }

        @Test
        void 입력값이_숫자범위에_벗어난_경우_예외() {
            String input = "102";

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("1~9 사이의 숫자를 입력해주세요.")
            );
        }

        @Test
        void 입력값에_중복된_숫자가_있을_경우_예외() {
            String input = "112";

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("중복된 숫자가 있습니다.")
            );
        }

        @Test
        void 입력값에_숫자가_아닌_문자가_있을_경우_예외() {
            String input = " 12";

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("숫자만 입력해주세요.")
            );
        }

        @Override
        protected void runMain() {
            playerNumberGenerator.generateList();
        }
    }

    @Nested
    class generateRestartTest extends NsTest {
        @Test
        void 입력값이_1_또는_2가_아닌_숫자인_경우() {
            String input = "4";

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("1 또는 2를 입력해주세요.")
            );
        }

        @Test
        void 입력값이_숫자가_아닌_경우() {
            String input = " ";

            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
                            .hasMessage("숫자만 입력해주세요.")
            );
        }

        @Override
        protected void runMain() {
            playerNumberGenerator.generateRestart();
        }
    }
}
