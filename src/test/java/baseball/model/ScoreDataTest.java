package baseball.model;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class ScoreDataTest {
    @Test
    public void testScoreWithNoMatches() {
        ScoreData scoreData = new ScoreData(Arrays.asList(1, 2, 3), Arrays.asList(4, 5, 6));
        assertEquals(0, scoreData.getStrike());
        assertEquals(0, scoreData.getBall());
    }

    @Test
    public void testScoreWithThreeStrikes() {
        ScoreData scoreData = new ScoreData(Arrays.asList(1, 2, 3), Arrays.asList(3, 2, 1));
        assertEquals(1, scoreData.getStrike());
        assertEquals(2, scoreData.getBall());
    }

    @Test
    public void testScoreWithTwoStrikesOneBall() {
        ScoreData scoreData = new ScoreData(Arrays.asList(4, 8, 7), Arrays.asList(6, 4, 7));
        assertEquals(1, scoreData.getStrike());
        assertEquals(1, scoreData.getBall());
    }
}