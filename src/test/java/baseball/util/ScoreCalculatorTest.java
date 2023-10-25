package baseball.util;

import static org.junit.jupiter.api.Assertions.assertEquals;

import baseball.model.player.GuessNumber;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreCalculatorTest {

    @Test
    @DisplayName("컴퓨터가 생성한 숫자게임의 정답과 사용자가 입력한 3개의 숫자를 비교해 스트라이크를 계산한다.")
    void calculateStrike_Test() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<GuessNumber> playerInput = playerInputThreeNumber(1, 2, 3);

        Integer strikes = ScoreCalculator.calculateStrike(playerInput, answer);

        assertEquals(3, strikes);
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자게임의 정답과 사용자가 입력한 3개의 숫자를 비교해 볼을 계산한다.")
    void calculateBall_Test() {
        // given
        List<Integer> answer = Arrays.asList(2, 3, 1);
        List<GuessNumber> playerInput = playerInputThreeNumber(3, 1, 2);

        Integer ball = ScoreCalculator.calculateBall(playerInput, answer);

        assertEquals(3, ball);
    }

    private List<GuessNumber> playerInputThreeNumber(Integer first, Integer middle, Integer last) {
        List<GuessNumber> playerInput = Arrays.asList(
                new GuessNumber(first),
                new GuessNumber(middle),
                new GuessNumber(last)
        );
        return playerInput;
    }
}