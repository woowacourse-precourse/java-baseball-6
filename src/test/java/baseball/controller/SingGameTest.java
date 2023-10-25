package baseball.controller;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.ball.Balls;
import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class SingGameTest extends NsTest {
    GameController gameController = GameController.StartBaseballGame();
    String answerNumbers = "123";
    Balls answerBalls;

    @BeforeEach
    void setUp() {
        List<Integer> answerBallNumbers = Arrays.stream(answerNumbers.split("")).map(Integer::parseInt).toList();
        answerBalls = new Balls(answerBallNumbers);
    }

    @Test
    @DisplayName("Single 게임 테스트 : 3 strike")
    public void singleGameTest() {
        String userInput = "123";
        run(userInput);
        assertThat(output()).contains("숫자를 입력해주세요 :", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다!", "게임 종료");

    }

    @Test
    @DisplayName("Single 게임 테스트 : 1ball ,  3 strike")
    public void singleGameReInputTest() {
        String[] userInput = {"461", "123"};
        run(userInput);
        assertThat(output()).contains("숫자를 입력해주세요 :", "1볼", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다!", "게임 종료");

    }

    @Test
    @DisplayName("Single 게임 테스트 : nothing ,  3 strike")
    public void singleGameReInputAfterNothingTest() {
        String[] userInput = {"465", "123"};
        run(userInput);
        assertThat(output()).contains("숫자를 입력해주세요 :", "낫싱", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다!", "게임 종료");
    }
    @Test
    @DisplayName("Single 게임 렌덤 테스트 : nothing ,  3 strike")
    public void singleGameRandomNumberTest() {
        String[] userInput = {"465", "123"};
        assertRandomNumberInRangeTest(
                () -> {
                    run(userInput);
                    assertThat(output()).contains("숫자를 입력해주세요 :", "낫싱", "3스트라이크", "3개의 숫자를 모두 맞히셨습니다!", "게임 종료");
                },
                1, 2, 3
        );
    }

    @Override
    protected void runMain() {
        gameController.playSingleGame(answerBalls);
    }
}