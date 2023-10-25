package baseball;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.Assertions.catchThrowable;

import baseball.service.BaseballGame;
import baseball.validator.Validator;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
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
    void 중복_값_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("122"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 숫자_이외_입력_테스트() {
        assertSimpleTest(() ->
                assertThatThrownBy(() -> runException("12삼"))
                        .isInstanceOf(IllegalArgumentException.class)
        );
    }

    @Test
    void 세_자리_수_입력값_길이_테스트() {
        // given
        int lengthThree = 3;
        String case1 = "123";
        String case2 = "12";
        String case3 = "1234";

        // when
        Throwable result1 = catchThrowable(() -> {
            Validator.validateInputLength(case1, lengthThree);
        });
        Throwable result2 = catchThrowable(() -> {
            Validator.validateInputLength(case2, lengthThree);
        });
        Throwable result3 = catchThrowable(() -> {
            Validator.validateInputLength(case3, lengthThree);
        });

        // then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_또는_종료_입력값_길이_테스트() {
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

        // then
        assertThat(result1).doesNotThrowAnyException();
        assertThat(result2).isInstanceOf(IllegalArgumentException.class);
        assertThat(result3).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 스트라이크_개수_테스트() {
        // given
        final int STRIKE_COUNT = 2;
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(1, 2, 4);
        BaseballGame baseballGame = new BaseballGame();

        // when
        baseballGame.calculateNumbers(computerNumbers, playerNumbers);

        // then
        assertThat(baseballGame.strikeCount).isEqualTo(STRIKE_COUNT);
    }

    @Test
    void 볼_개수_테스트() {
        // given
        final int BALL_COUNT = 2;
        List<Integer> computerNumbers = List.of(1, 2, 3);
        List<Integer> playerNumbers = List.of(3, 2, 1);
        BaseballGame baseballGame = new BaseballGame();

        // when
        baseballGame.calculateNumbers(computerNumbers, playerNumbers);

        // then
        assertThat(baseballGame.ballCount).isEqualTo(BALL_COUNT);
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}
