package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ScoreFactoryTest {

    @Test
    @DisplayName("3스트라이크 테스트")
    void calculateScore_3_strike() {
        List<Integer> randomNumber = Arrays.asList(1, 2, 3);
        List<Integer> userGuessNumber = Arrays.asList(1, 2, 3);

        Score score = ScoreFactory.calculateScore(randomNumber, userGuessNumber);
        assertEquals(3, score.getStrikeCount());
        assertEquals(0, score.getBallCount());
    }

    @Test
    @DisplayName("3볼 테스트")
    void calculateScore_3_ball() {
        List<Integer> randomNumber = Arrays.asList(1, 2, 3);
        List<Integer> userGuessNumber = Arrays.asList(3, 1, 2);

        Score score = ScoreFactory.calculateScore(randomNumber, userGuessNumber);
        assertEquals(0, score.getStrikeCount());
        assertEquals(3, score.getBallCount());
    }

    @Test
    @DisplayName("낫싱 테스트")
    void calculateScore_not_thing() {
        List<Integer> randomNumber = Arrays.asList(1, 2, 3);
        List<Integer> userGuessNumber = Arrays.asList(4, 5, 6);

        Score score = ScoreFactory.calculateScore(randomNumber, userGuessNumber);
        assertEquals(0, score.getStrikeCount());
        assertEquals(0, score.getBallCount());
    }
}