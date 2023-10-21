package baseball.mytest.model;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

public class BaseballGameTest {
    BaseballGame baseballGame = new BaseballGame();

    @Test
    void 숫자_1_입력시_재시작_2_입력시_종료() {
        String input = "1";
        String input2 = "2";

        assertThat(baseballGame.restartGame(input)).isEqualTo("재시작");
        assertThat(baseballGame.restartGame(input2)).isEqualTo("종료");
    }
}
