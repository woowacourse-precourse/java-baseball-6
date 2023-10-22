package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

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

    @Test
    void 중복된_값_입력_시_예외_발생_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자가_아닌_것을_입력했을_시_예외_발생_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12삼"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 정답을_맞춘_후_입력값의_길이_예외_테스트() {
        // given
        int lengthOne = 1;
        String case1 = "1";
        String case2 = "";
        String case3 = "12";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validator.validateInputLength(case1, lengthOne);
        });

        Throwable result2 = catchThrowable(() -> {
            Validator.validateInputLength(case2, lengthOne);
        });

        Throwable result3 = catchThrowable(() -> {
            Validator.validateInputLength(case3, lengthOne);
        });

        //then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
