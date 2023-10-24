package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BaseballGameTest {
    @Test
    public void 숫자_정답시_true_반환_테스트() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(1, 2, 3);

        boolean isWin = GameRules.isUserWin(GameRules.countStrike(user, computer));

        assertThat(isWin).isTrue();
    }

    @Test
    public void 볼_개수_반환_테스트() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(3, 1, 2);

        int ballCount = GameRules.countBall(user, computer);

        assertThat(ballCount).isEqualTo(3);
    }

    @Test
    public void 스트라이크_개수_반환_테스트() {
        List<Integer> computer = Arrays.asList(1, 2, 3);
        List<Integer> user = Arrays.asList(1, 0, 0);

        int strikeCount = GameRules.countStrike(user, computer);

        assertThat(strikeCount).isEqualTo(1);
    }

    @Test
    void 숫자_입력_예외발생_테스트_0입력() {
        String invalidInput = "012";
        assertThatThrownBy(() -> {
            InputValidator.numberInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_입력_예외발생_테스트_문자() {
        String invalidInput = "dqe";
        assertThatThrownBy(() -> {
            InputValidator.numberInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_입력_예외발생_테스트_3자리_이상() {
        String invalidInput = "3125";
        assertThatThrownBy(() -> {
            InputValidator.numberInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 숫자_입력_예외발생_테스트_중복() {
        String invalidInput = "114";
        assertThatThrownBy(() -> {
            InputValidator.numberInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력_예외발생_테스트_3입력() {
        String invalidInput = "3";
        assertThatThrownBy(() -> {
            InputValidator.continueInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력_예외발생_테스트_빈칸입력() {
        String invalidInput = "";
        assertThatThrownBy(() -> {
            InputValidator.continueInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 재시작_입력_예외발생_테스트_문자() {
        String invalidInput = "ㅇ";
        assertThatThrownBy(() -> {
            InputValidator.continueInput(invalidInput);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
