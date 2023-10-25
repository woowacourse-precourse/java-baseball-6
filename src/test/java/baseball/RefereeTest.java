package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RefereeTest {

    private Referee referee;

    @BeforeEach
    public void setUp() {
        referee = new Referee();
    }

    @Test
    public void 심판_테스트() {

        // 3 스트라이크 expected
        List<Integer> answer = Arrays.asList(1, 2, 3);
        List<Integer> userInput = Arrays.asList(1, 2, 3);
        Score score = referee.judge(userInput, answer);
        assertEquals(3, score.getStrikeCount());
        assertEquals(0, score.getBallCount());

        // 1 스트라이크 2 볼 expected
        answer = Arrays.asList(1, 2, 3);
        userInput = Arrays.asList(1, 3, 2);
        score = referee.judge(userInput, answer);
        assertEquals(1, score.getStrikeCount());
        assertEquals(2, score.getBallCount());

        // 0 스트라이크 0 볼 expected
        answer = Arrays.asList(1, 2, 3);
        userInput = Arrays.asList(5, 6, 7);
        score = referee.judge(userInput, answer);
        assertEquals(0, score.getStrikeCount());
        assertEquals(0, score.getBallCount());

    }
}