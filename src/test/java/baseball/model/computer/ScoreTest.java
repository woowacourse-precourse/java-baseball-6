package baseball.model.computer;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import baseball.model.player.GuessNumber;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreTest {

    private Score score;

    @BeforeEach
    void init() {
        score = new Score();
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자게임의 정답과 사용자가 입력한 3개의 숫자를 비교해 점수를 계산한다.")
    void calculate_Test() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<GuessNumber> playerInput = playerInputThreeNumber(1, 2, 3);

        // when
        score.calculate(playerInput, answer);

        // then
        assertEquals(3, score.getStrike());
        assertEquals(0, score.getBall());
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자게임의 정답과 사용자가 입력한 3개의 숫자를 비교해 일치하면 true를 반환한다.")
    void isAllStrike_true_Test() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<GuessNumber> playerInput = playerInputThreeNumber(1, 2, 3);

        // when
        score.init();
        score.calculate(playerInput, answer);

        // then
        assertTrue(score.isAllStrike());
    }

    @Test
    @DisplayName("컴퓨터가 생성한 숫자게임의 정답과 사용자가 입력한 3개의 숫자를 비교해 일치하지 않으면 false를 반환한다.")
    void isAllStrike_false_Test() {
        // given
        List<Integer> answer = Arrays.asList(1, 2, 4);
        List<GuessNumber> playerInput = playerInputThreeNumber(1, 2, 3);

        // when
        score.init();
        score.calculate(playerInput, answer);

        // then
        assertFalse(score.isAllStrike());
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