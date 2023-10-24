package baseball;

import baseball.view.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static baseball.util.TestConstants.*;

public class ConsoleTest {

    @Nested
    @DisplayName("사용자의 3자리 수 입력을 받는 기능")
    class input3DigitNumberTest extends NsTest {

        @Test
        @DisplayName("정상적으로 입력한다.")
        void success() {
            assertSimpleTest(
                    () -> {
                        run(SUCCESS_STRING);
                        assertThat(output()).isEqualTo(SUCCESS_LIST_TO_STRING);
                    }
            );
        }

        @Test
        @DisplayName("null을 입력하면 예외가 발생한다.")
        void inputNull() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(NULL_STRING))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("숫자가 아닌 입력을 하면 예외가 발생한다.")
        void inputNotNumber() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(NOT_NUMBER_STRING))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("범위를 벗어난 수를 입력하면 예외가 발생한다.")
        void inputOutOfRange() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(OUT_OF_RANGE_NUMBER))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("정해진 길이를 벗어난 숫자를 입력하면 예외가 발생한다.")
        void inputInvalidLengthNumber() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(SHORTER_THAN_NUMBER_LENGTH_LIMIT))
                            .isInstanceOf(IllegalArgumentException.class)
            );
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(LONGER_THAN_NUMBER_LENGTH_LIMIT))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("중복된 수를 입력하면 예외가 발생한다.")
        void inputDuplicateNumber() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(DUPLICATE_NUMBER_STRING))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }


        @Override
        protected void runMain() {
            System.out.println(Console.input3DigitNumber().toString());
        }
    }


    @Nested
    @DisplayName("상대방의 3자리 수 입력을 받는 기능")
    class input3DigitRandomNumberTest extends NsTest {

        @Test
        @DisplayName("정상적으로 입력한다.")
        void success() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(EMPTY_STRING);
                        assertThat(output()).isEqualTo(SUCCESS_LIST_TO_STRING);
                    },
                    SUCCESS_LIST_FIRST_ELEMENT,
                     SUCCESS_LIST_REMAINING_ELEMENTS
            );
        }

        @Override
        protected void runMain() {
            System.out.println(Console.input3DigitRandomNumber());
        }
    }

    @Nested
    @DisplayName("사용자의 재시작/종료 여부를 입력받는 기능")
    class inputRestartOrTerminateTest extends NsTest {

        @Nested
        @DisplayName("성공 테스트")
        class successTest {
            @Test
            @DisplayName("재시작을 입력한다")
            void restart() {
                assertSimpleTest(
                        () -> {
                            run(RESTART);
                            assertThat(output()).isEqualTo(RESTART);
                        }
                );
            }

            @Test
            @DisplayName("종료를 입력한다")
            void terminate() {
                assertSimpleTest(
                        () -> {
                            run(TERMINATE);
                            assertThat(output()).isEqualTo(TERMINATE);
                        }
                );
            }

        }

        @Nested
        @DisplayName("예외 테스트")
        class exceptionTest {
            @Test
            @DisplayName("null을 입력하면 예외가 발생한다.")
            void inputNull() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(NULL_STRING))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("숫자가 아닌 입력을 하면 예외가 발생한다")
            void inputNotNumber() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(NOT_NUMBER_STRING))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("범위를 벗어난 수를 입력하면 예외가 발생한다.")
            void inputOutOfRange() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(NOT_BOTH_RESTART_AND_TERMINATE))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }


        }

        @Override
        protected void runMain() {
            System.out.println(Console.inputRestartOrTerminate());
        }
    }
}
