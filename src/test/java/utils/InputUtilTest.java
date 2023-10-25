package utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import constant.TestConstant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("입력 기능")
class InputUtilTest {
    @Nested
    @DisplayName("사용자의 3자리 수를 입력받는 기능")
    class PlayerInputTest extends NsTest {
        @Test
        @DisplayName("정상 입력")
        void success() {
            assertSimpleTest(
                    () -> {
                        run(TestConstant.FIRST_ANSWER);
                        assertThat(output()).isEqualTo(TestConstant.FIRST_ANSWER_SPLIT.toString());
                    }
            );
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            @Test
            @DisplayName("null 테스트")
            void nullTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.NULL_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("빈 문자열 테스트")
            void emptyTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.EMPTY_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("잘못된 타입 테스트")
            void invalidTypeTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.PLAYER_INPUT_INVALID_TYPE_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("3자리가 아닌 숫자 테스트")
            void invalidLengthTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.PLAYER_INPUT_SHORT_LENGTH_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.PLAYER_INPUT_EXCEED_LENGTH_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("0 테스트")
            void invalidZeroTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.PLAYER_INPUT_ZERO_TEST_1))
                                .isInstanceOf(IllegalArgumentException.class)
                );
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.PLAYER_INPUT_ZERO_TEST_2))
                                .isInstanceOf(IllegalArgumentException.class)
                );
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.PLAYER_INPUT_ZERO_TEST_3))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("중복 테스트")
            void invalidDuplicateTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.PLAYER_INPUT_DUPLICATION_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }
        }

        @Override
        protected void runMain() {
            System.out.println(InputUtil.getPlayerInput());
        }
    }

    @Nested
    @DisplayName("재시작 여부를 입력받는 기능")
    class RestartInfoTest extends NsTest {
        @Test
        @DisplayName("정상 입력")
        void success() {
            assertSimpleTest(
                    () -> {
                        run(TestConstant.RESTART_GAME_VALUE);
                        assertThat(output()).isEqualTo(
                                String.valueOf(Integer.parseInt(TestConstant.RESTART_GAME_VALUE)));
                    }
            );
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            @Test
            @DisplayName("null 테스트")
            void nullTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.NULL_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("빈 문자열 테스트")
            void emptyTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.EMPTY_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("잘못된 타입 테스트")
            void invalidTypeTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.RESTART_INVALID_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("1자리가 아닌 숫자 테스트")
            void invalidLengthTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.RESTART_INVALID_LENGTH_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("잘못된 값 테스트")
            void invalidValueTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(TestConstant.RESTART_INVALID_ZERO_TEST))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }
        }

        @Override
        protected void runMain() {
            System.out.println(InputUtil.getRestartInfo());
        }
    }
}