package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class ScoringTest {

    @Test
    public void 채점시_랜덤난수를_String으로_다룬다() {
        Scoring scoring = new Scoring(123);
        assertTrue(scoring.getAnswer() instanceof String);
    }

}