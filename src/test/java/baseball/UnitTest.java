package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrowsExactly;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class UnitTest {

    private final Computer computer = new Computer(3);

    @Nested
    @DisplayName("컴퓨터는 임의의 수를 선택한다.")
    class ComputerRandomNumberTest {
        @Test
        void 임의의_수는_3자리이다() {
            int number = computer.generateRandomNumbers();

            assertTrue(number >= 100);
            assertTrue(number < 1000);
        }

        @Test
        void 임의의_수는_서로_다른_수이다() {
            int number = computer.generateRandomNumbers();
            int n1 = number / 100;
            int n2 = (number % 100) / 10;
            int n3 = number % 10;

            assertTrue(n1 != n2);
            assertTrue(n2 != n3);
            assertTrue(n3 != n1);
        }

        @Test
        void 임의의_수의_자리수는_0이_아닌_자연수이다() {
            int number = computer.generateRandomNumbers() % 10;

            assertTrue(number >= 1);
        }
    }

    @Nested
    @DisplayName("사용자는 서로 다른 3자리의 수를 입력한다.")
    class UserInputTest {
        @Test
        void 입력값은_3자리이다() {
            String input = "123";

            assertDoesNotThrow(() -> computer.evaluate(input));
        }

        @Test
        void 입력값은_서로다른수이다() {
            String input = "456";

            assertDoesNotThrow(() -> computer.evaluate(input));
        }

        @Test
        void 입력값이_3자리가_아니면_예외발생() {
            String input = "1234";

            assertThrowsExactly(IllegalArgumentException.class, () -> computer.evaluate(input));
        }

        @Test
        void 입력값이_서로_다른_수가_아니면_예외발생() {
            String input = "112";

            assertThrowsExactly(IllegalArgumentException.class, () -> computer.evaluate(input));
        }

        @Test
        void 입력값이_숫자가_아니면_예외발생() {
            String input = "abc";

            assertThrowsExactly(IllegalArgumentException.class, () -> computer.evaluate(input));
        }

        @Test
        void 입력값이_널이면_예외발생() {
            assertThrowsExactly(IllegalArgumentException.class, () -> computer.evaluate(null));
        }

        @Test
        void 입력값의_각_자리수가_자연수가_아니면_예외발생() {
            String input = "012";

            assertThrowsExactly(IllegalArgumentException.class, () -> computer.evaluate(input));
        }
    }
}
