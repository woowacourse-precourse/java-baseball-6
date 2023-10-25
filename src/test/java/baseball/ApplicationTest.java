package baseball;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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
    public void 사용자가_올바른_예측답변을_입력하면_리스트를_리턴한다() throws Exception {
        String input = "123";
        assertThat(Application.validateUserInput(input)).asList().isEqualTo(List.of(1, 2, 3));
    }

    @Test
    public void 사용자가_올바르지_않은_예측답변을_입력하면_예외가_발생한다() throws Exception {
        String input1 = "112";
        String input2 = "12";
        String input3 = "a12";
        String input4 = "1234";

        assertThatThrownBy(() -> Application.validateUserInput(input1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateUserInput(input2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateUserInput(input3)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateUserInput(input4)).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    public void 사용자가_올바른_게임_재게_답변을_입력하면_불리언값을_리턴한다() throws Exception {
        String answer1 = "1";
        String answer2 = "2";

        assertThat(Application.validateReGame(answer1)).isTrue();
        assertThat(Application.validateReGame(answer2)).isFalse();
    }

    @Test
    public void 사용자가_올바르지_않은_게임_재게_답변을_입력하면_예외를_발생시킨다() throws Exception {
        String answer1 = "11";
        String answer2 = "3";
        String answer3 = "a";

        assertThatThrownBy(() -> Application.validateReGame(answer1)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateReGame(answer2)).isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(() -> Application.validateReGame(answer3)).isInstanceOf(IllegalArgumentException.class);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
