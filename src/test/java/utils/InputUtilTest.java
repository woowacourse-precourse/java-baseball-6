package utils;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
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
            String input = "123";
            List<Integer> list = List.of(1, 2, 3);
            assertSimpleTest(
                    () -> {
                        run(input);
                        assertThat(output()).isEqualTo(list.toString());
                    }
            );
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            @Test
            @DisplayName("null 테스트")
            void nullTest() {
                String nullStr = null;
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(nullStr))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("빈 문자열 테스트")
            void emptyTest() {
                String emptyStr = new String();
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(emptyStr))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("잘못된 타입 테스트")
            void invalidTypeTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("1a2"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("3자리가 아닌 숫자 테스트")
            void invalidLengthTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("12"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("1234"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("0 테스트")
            void invalidZeroTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("012"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("102"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("120"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("중복 테스트")
            void invalidDuplicateTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("112"))
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
    @DisplayName("사용자의 3자리 수를 입력받는 기능")
    class RestartInfoTest extends NsTest {
        @Test
        @DisplayName("정상 입력")
        void success() {
            assertSimpleTest(
                    () -> {
                        run("1");
                        assertThat(output()).isEqualTo(String.valueOf(1));
                    }
            );
        }

        @Nested
        @DisplayName("예외 테스트")
        class ExceptionTest {
            @Test
            @DisplayName("null 테스트")
            void nullTest() {
                String nullStr = null;
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(nullStr))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("빈 문자열 테스트")
            void emptyTest() {
                String emptyStr = new String();
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException(emptyStr))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("잘못된 타입 테스트")
            void invalidTypeTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("a"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("1자리가 아닌 숫자 테스트")
            void invalidLengthTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("12"))
                                .isInstanceOf(IllegalArgumentException.class)
                );
            }

            @Test
            @DisplayName("0 테스트")
            void invalidZeroTest() {
                assertSimpleTest(() ->
                        assertThatThrownBy(() -> runException("0"))
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