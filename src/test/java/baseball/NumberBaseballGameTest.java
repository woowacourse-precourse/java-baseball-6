package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class NumberBaseballGameTest {
    private final NumberBaseballGame numberBaseballGame = new NumberBaseballGame();

    @Test
    public void 숫자_정답시_true_반환_테스트() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(1, 2, 3);

        boolean isWin = numberBaseballGame.isUserWin(user, computer);

        assertThat(isWin).isTrue();
    }

    @Test
    public void 볼_개수_반환_테스트() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(3, 1, 2);

        int ballCount = numberBaseballGame.countBall(user, computer);

        assertThat(ballCount).isEqualTo(3);
    }

    @Test
    public void 스트라이크_개수_반환_테스트() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(1, 0, 0);

        int strikeCount = numberBaseballGame.countStrike(user, computer);

        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void 숫자_입력_예외발생_테스트1() {
        String invalidInput = "012";
        assertThatThrownBy(() -> {
            numberBaseballGame.validateInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_입력_예외발생_테스트2() {
        String invalidInput = "dqe";
        assertThatThrownBy(() -> {
            numberBaseballGame.validateInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_입력_예외발생_테스트3() {
        String invalidInput = "3125";
        assertThatThrownBy(() -> {
            numberBaseballGame.validateInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력_예외발생_테스트1() {
        String invalidInput = "3";
        assertThatThrownBy(() -> {
            numberBaseballGame.validateContinueInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력_예외발생_테스트2() {
        String invalidInput = "";
        assertThatThrownBy(() -> {
            numberBaseballGame.validateContinueInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력_예외발생_테스트3() {
        String invalidInput = "ㅇ";
        assertThatThrownBy(() -> {
            numberBaseballGame.validateContinueInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
