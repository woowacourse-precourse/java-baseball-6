package baseball;


import static baseball.util.GameResults.GAME_OVER;
import static baseball.util.GameResults.ONE_STRIKE;
import static baseball.util.GameResults.THREE_STRIKE;
import static baseball.util.GameResults.TWO_BALL;
import static baseball.util.TestConstants.DUPLICATE_NUMBER_STRING;
import static baseball.util.TestConstants.EMPTY_STRING;
import static baseball.util.TestConstants.EXPECTED_TWO_BALL_ONE_STRIKE;
import static baseball.util.TestConstants.FIRST_SUCCESS_STRING;
import static baseball.util.TestConstants.FULL_LIST_FIRST_ELEMENT;
import static baseball.util.TestConstants.FULL_LIST_REMAINING_ELEMENTS;
import static baseball.util.TestConstants.LONGER_THAN_NUMBER_LENGTH_LIMIT;
import static baseball.util.TestConstants.NEITHER_RESTART_NOR_TERMINATE;
import static baseball.util.TestConstants.NOT_NUMBER_STRING;
import static baseball.util.TestConstants.NULL_STRING;
import static baseball.util.TestConstants.OUT_OF_RANGE_NUMBER;
import static baseball.util.TestConstants.RESTART;
import static baseball.util.TestConstants.SECOND_SUCCESS_STRING;
import static baseball.util.TestConstants.SHORTER_THAN_NUMBER_LENGTH_LIMIT;
import static baseball.util.TestConstants.TERMINATE;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class BaseBallGameSystemTest extends NsTest {

    @Nested
    @DisplayName("성공 테스트")
    class successTest {

        @Test
        @DisplayName("성공 후 게임을 종료한다.")
        void successAndTerminate() {
            assertRandomNumberInRangeTest(
                    () -> {
                        run(FIRST_SUCCESS_STRING, TERMINATE);
                        assertThat(output()).contains(THREE_STRIKE, GAME_OVER);
                    },
                    FULL_LIST_FIRST_ELEMENT, FULL_LIST_REMAINING_ELEMENTS
            );
        }


        @Test
        @DisplayName("성공 후 재시작 하여 성공 후 종료한다.")
        void successAndRestartThenTerminate() {

            assertRandomNumberInRangeTest(
                    () -> {
                        run(FIRST_SUCCESS_STRING, RESTART,
                                EXPECTED_TWO_BALL_ONE_STRIKE, SECOND_SUCCESS_STRING, TERMINATE);
                        assertThat(output()).contains(TWO_BALL + ONE_STRIKE, THREE_STRIKE, GAME_OVER);
                    },
                    FULL_LIST_FIRST_ELEMENT, FULL_LIST_REMAINING_ELEMENTS

            );
        }

    }

    @Nested
    @DisplayName("예외 테스트")
    class exceptionTest {

        @Nested
        @DisplayName("잘못된 3자리 숫자 입력")
        class input3DigitNumberExceptionTest {

            @Test
            @DisplayName("null을 입력하면 예외가 발생한다.")
            void inputNull() {
                assertSimpleTest(
                        () -> assertThatThrownBy(() -> runException(NULL_STRING))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("빈 문자열을 입력하면 예외가 발생한다.")
            void inputEmpty() {
                assertSimpleTest(
                        () -> assertThatThrownBy(() -> runException(EMPTY_STRING))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("숫자가 아닌 입력을 하면 예외가 발생한다.")
            void inputNotNumber() {
                assertSimpleTest(
                        () -> assertThatThrownBy(() -> runException(NOT_NUMBER_STRING))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("범위를 벗어난 수를 입력하면 예외가 발생한다.")
            void inputOutOfRangeNumber() {
                assertSimpleTest(
                        () -> assertThatThrownBy(() -> runException(OUT_OF_RANGE_NUMBER))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("정해진 길이를 벗어난 숫자를 입력하면 예외가 발생한다.")
            void inputInvalidLengthNumber() {
                assertSimpleTest(
                        () -> {
                            assertThatThrownBy(() -> runException(SHORTER_THAN_NUMBER_LENGTH_LIMIT))
                                    .isInstanceOf(IllegalArgumentException.class);

                            assertThatThrownBy(() -> runException(LONGER_THAN_NUMBER_LENGTH_LIMIT))
                                    .isInstanceOf(IllegalArgumentException.class);
                        }
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


        }

        @Nested
        @DisplayName("잘못된 재시작/종료 입력")
        class inputRestartOrTerminateExceptionTest {

            @Test
            @DisplayName("null을 입력하면 예외가 발생한다.")
            void inputNull() {
                assertRandomNumberInRangeTest(() ->
                                assertThatThrownBy(() -> runException(FIRST_SUCCESS_STRING, NULL_STRING))
                                        .isInstanceOf(IllegalArgumentException.class)
                        , FULL_LIST_FIRST_ELEMENT, FULL_LIST_REMAINING_ELEMENTS
                );
            }

            @Test
            @DisplayName("빈 문자열을 엽력하면 예외가 발생한다.")
            void inputEmpty() {
                assertRandomNumberInRangeTest(() ->
                                assertThatThrownBy(() -> runException(FIRST_SUCCESS_STRING, EMPTY_STRING))
                                        .isInstanceOf(IllegalArgumentException.class)
                        , FULL_LIST_FIRST_ELEMENT, FULL_LIST_REMAINING_ELEMENTS
                );
            }

            @Test
            @DisplayName("숫자가 아닌 입력을 하면 예외가 발생한다.")
            void inputNotNumber() {
                assertRandomNumberInRangeTest(() ->
                                assertThatThrownBy(() -> runException(FIRST_SUCCESS_STRING, NOT_NUMBER_STRING))
                                        .isInstanceOf(IllegalArgumentException.class),
                        FULL_LIST_FIRST_ELEMENT, FULL_LIST_REMAINING_ELEMENTS
                );
            }

            @Test
            @DisplayName("범위를 벗어난 입력을 하면 예외가 발생한다.")
            void inputOutOfRange() {
                assertRandomNumberInRangeTest(() ->
                                assertThatThrownBy(() -> runException(FIRST_SUCCESS_STRING, NEITHER_RESTART_NOR_TERMINATE)),
                        FULL_LIST_FIRST_ELEMENT, FULL_LIST_REMAINING_ELEMENTS

                );
            }
        }

    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

}
