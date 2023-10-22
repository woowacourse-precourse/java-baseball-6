package baseball;

import baseball.view.Console;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class ConsoleTest {
    private final String emptyString = "";
    private final String successString = "123";
    private final List<Integer> successList = List.of(1, 2, 3);
    private final int successListSize = successList.size();
    private final String nullString = null;
    private final String notNumber = "ABC";
    private final String outOfRangeNumber = "012";
    private final String shorterThanLimitNumber = "1";
    private final String longerThanLimitNumber = "1234";
    private final String duplicateNumber = "112";
    private final String RESTART = "1";
    private final String TERMINATE = "2";
    private final String NOT_BOTH_RESTART_AND_TERMINATE = "3";

    @Nested
    @DisplayName("사용자의 3자리 수 입력을 받는 기능")
    class input3DigitNumberTest extends NsTest {
        List<Integer> successList = new ArrayList<>(List.of(1, 2, 3));

        @Test
        @DisplayName("정상적으로 입력한다.")
        void success() {
            assertSimpleTest(
                    () -> {
                        run(successString);
                        assertThat(output()).isEqualTo(successList.toString());
                    }
            );
        }

        @Test
        @DisplayName("null을 입력하면 예외가 발생한다.")
        void inputNull() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(nullString))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("숫자가 아닌 입력을 하면 예외가 발생한다.")
        void inputNotNumber() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(notNumber))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("범위를 벗어난 수를 입력하면 예외가 발생한다.")
        void inputOutOfRange() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(outOfRangeNumber))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("정해진 길이를 벗어난 숫자를 입력하면 예외가 발생한다.")
        void inputInvalidLengthNumber() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(shorterThanLimitNumber))
                            .isInstanceOf(IllegalArgumentException.class)
            );
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(longerThanLimitNumber))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @Test
        @DisplayName("중복된 수를 입력하면 예외가 발생한다.")
        void inputDuplicateNumber() {
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(duplicateNumber))
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
                        run(emptyString);
                        assertThat(output()).isEqualTo(successList.toString());
                    },
                    successList.get(0),
                    successList.subList(1, successListSize)
                            .toArray(new Integer[successListSize - 1])
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
                        assertThatThrownBy(() -> runException(nullString))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("숫자가 아닌 입력을 하면 예외가 발생한다")
            void inputNotNumber() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(notNumber))
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
