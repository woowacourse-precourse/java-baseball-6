package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import baseball.controller.Controller;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {

    Application application = new Application();
    Controller controller = new Controller();

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
    void 입력값_형변환_테스트() {
        String input_number = "123";
        int[] expected_result = {1, 2, 3};

        int[] real_result = controller.stringToIntArray(input_number);

        Assertions.assertArrayEquals(expected_result, real_result);
    }

    @Test
    void 입력값_자릿수_예외처리_테스트() {
        int[] input_number = {1, 2, 3, 4};
        Assertions.assertThrows(RuntimeException.class, () -> {
            controller.exceptionUserInput(input_number);
        });
    }

    @Test
    void 입력값_중복_예외처리_테스트() {
        int[] input_number = {1, 3, 3};
        Assertions.assertThrows(RuntimeException.class, () -> {
            controller.exceptionUserInput(input_number);
        });
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
