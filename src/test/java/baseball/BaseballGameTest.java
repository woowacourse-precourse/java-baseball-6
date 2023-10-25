package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

@DisplayName("숫자 야구 게임 진행 테스트")
class BaseballGameTest extends NsTest {
    @Test
    @DisplayName("정상 작동")
    void success() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("456", "124", "123", "1", "167", "356", "354", "456", "2");
                    assertThat(output()).contains("낫싱", "2스트라이크", "3스트라이크", "1볼", "2스트라이크", "1볼 1스트라이크", "3스트라이크",
                            "게임 종료");
                },
                1, 2, 3, 4, 5, 6
        );
    }

    @Nested
    @DisplayName("예외 테스트")
    class ExceptionTest {
        @Nested
        @DisplayName("사용자 입력 예외 테스트")
        class PlayerInputExceptionTest {
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

        @Nested
        @DisplayName("재시작 여부를 입력받는 기능")
        class RestartInfoTest {
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
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}