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

@DisplayName("통합 테스트")
class ApplicationTest extends NsTest {
    @Test
    void 게임종료_후_재시작() {
        assertRandomNumberInRangeTest(
                () -> {
                    run("246", "135", "1", "597", "589", "2");
                    assertThat(output()).contains("낫싱", "3스트라이크", "1볼 1스트라이크", "3스트라이크", "게임 종료");
                },
                1, 3, 5, 5, 8, 9
        );
    }

    @Test
    void 예외_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("1234"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }

    @DisplayName("사용자가 잘못된 입력을 할경우 IllegalArgumentException 이 발생한다.")
    @Nested
    class InputVerification {
        @DisplayName("숫자야구 입력시 3자리 숫자를 입력하지 않는다면 예외가 발생한다.")
        @ParameterizedTest(name = "[{index}차]시도: input: {0}")
        @ValueSource(strings = {"1", "12", "1234", "1aa", "12a", "abc", "  "})
        void failInputForBaseballNumber(String input) {
            //given
            //when
            //then
            assertSimpleTest(() ->
                    assertThatThrownBy(() -> runException(input))
                            .isInstanceOf(IllegalArgumentException.class)
            );
        }

        @DisplayName("게임 재시작 여부 입력시 1또는 2가 아닌 수를 입력하면 예외가 발생한다.")
        @ParameterizedTest(name = "[{index}차]시도: input: {0}")
        @ValueSource(strings = {"12", "english", "한글", "aaaa", "1a", " "})
        void failInputForRedo(String input) {
            //given
            //when
            //then
            assertSimpleTest(() ->
                    assertThatThrownBy(() ->
                            assertRandomNumberInRangeTest(
                                    () -> {
                                        run("246", "135", input);
                                    }, 1, 3, 5
                            )).isInstanceOf(IllegalArgumentException.class)
            );
        }
    }
}
