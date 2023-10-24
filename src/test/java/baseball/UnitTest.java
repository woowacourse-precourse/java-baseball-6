package baseball;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertEquals;
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

            assertDoesNotThrow(() -> computer.evaluate(input, "123"));
        }

        @Test
        void 입력값은_서로다른수이다() {
            String input = "456";

            assertDoesNotThrow(() -> computer.evaluate(input, "123"));
        }

        @Test
        void 입력값이_3자리가_아니면_예외발생() {
            String input = "1234";

            assertThrowsExactly(IllegalArgumentException.class, () -> computer.evaluate(input, "123"));
        }

        @Test
        void 입력값이_서로_다른_수가_아니면_예외발생() {
            String input = "112";

            assertThrowsExactly(IllegalArgumentException.class, () -> computer.evaluate(input, "123"));
        }

        @Test
        void 입력값이_숫자가_아니면_예외발생() {
            String input = "abc";

            assertThrowsExactly(IllegalArgumentException.class, () -> computer.evaluate(input, "123"));
        }

        @Test
        void 입력값이_널이면_예외발생() {
            assertThrowsExactly(
                    IllegalArgumentException.class,
                    () -> computer.evaluate(null, "123")
            );
        }

        @Test
        void 입력값의_각_자리수가_자연수가_아니면_예외발생() {
            String input = "012";

            assertThrowsExactly(IllegalArgumentException.class, () -> computer.evaluate(input, "123"));
        }
    }

    @Nested
    @DisplayName("컴퓨터는 입력한 수에 대한 결과를 출력한다.")
    class ComputerEvaluationTest {

        @Nested
        @DisplayName("숫자는 포함 되어 있지만 자리가 다른 경우 볼.")
        class BallTest {
            @Test
            void 원볼() {
                String targetNumber = "123";
                String input = "452";
                String result = computer.evaluate(input, targetNumber);

                assertEquals("1볼", result);
            }

            @Test
            void 투볼() {
                String targetNumber = "123";
                String input = "352";
                String result = computer.evaluate(input, targetNumber);

                assertEquals("2볼", result);
            }

            @Test
            void 쓰리볼() {
                String targetNumber = "123";
                String input = "231";
                String result = computer.evaluate(input, targetNumber);

                assertEquals("3볼", result);
            }
        }

        @Nested
        @DisplayName("숫자가 포함 되어 있고 자리도 같은 경우 스트라이크.")
        class StrikeTest {
            @Test
            void 원스트라이크() {
                String targetNumber = "123";
                String input = "145";
                String result = computer.evaluate(input, targetNumber);

                assertEquals("1스트라이크", result);
            }

            @Test
            void 투스트라이크() {
                String targetNumber = "123";
                String input = "124";
                String result = computer.evaluate(input, targetNumber);

                assertEquals("2스트라이크", result);
            }

            @Test
            void 쓰리스트라이크() {
                String targetNumber = "123";
                String input = "123";
                String result = computer.evaluate(input, targetNumber);

                assertEquals("3스트라이크", result);
            }
        }

        @Nested
        @DisplayName("볼과 스트라이크를 모두 포함하는 경우")
        class BallAndStrikeTest {
            @Test
            void 원볼_원스트라이크() {
                String targetNumber = "123";
                String input = "135";
                String result = computer.evaluate(input, targetNumber);

                assertEquals("1볼 1스트라이크", result);
            }

            @Test
            void 투볼_원스트라이크() {
                String targetNumber = "123";
                String input = "321";
                String result = computer.evaluate(input, targetNumber);

                assertEquals("2볼 1스트라이크", result);
            }
        }

        @Test
        void 볼과_스트라이크가_모두_없는_경우_낫싱() {
            String targetNumber = "123";
            String input = "456";
            String result = computer.evaluate(input, targetNumber);

            assertEquals("낫싱", result);
        }
    }
}
