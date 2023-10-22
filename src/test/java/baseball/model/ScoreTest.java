package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ScoreTest {
    @Test
    public void testScoreWithNoMatches() {
        Score score = new Score(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        assertEquals(0, score.getStrike());
        assertEquals(0, score.getBall());
    }

    @Test
    public void testScoreWithThreeStrikes() {
        Score score = new Score(Arrays.asList(1, 2, 3), Arrays.asList(3, 2, 1));
        assertEquals(1, score.getStrike());
        assertEquals(2, score.getBall());
    }

    @Test
    public void testScoreWithTwoStrikesOneBall() {
        Score score = new Score(Arrays.asList(4, 8, 7), Arrays.asList(6, 4, 7));
        assertEquals(1, score.getStrike());
        assertEquals(1, score.getBall());
    }
}