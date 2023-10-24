package baseball.controller;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Map;
import org.junit.jupiter.api.Test;

class ScoringTest {

    @Test
    public void 채점시_랜덤난수를_String으로_다룬다() {
        Scoring scoring = new Scoring(123);
        assertTrue(scoring.getAnswer() instanceof String);
    }

    @Test
    public void 스트라이크3() {
        Scoring scoring = new Scoring(123);
        Map<String, Integer> resultMap = scoring.score("123");
        assertEquals(3, (int) resultMap.get("스트라이크"));
    }

    @Test
    public void 스트라이크1_볼2() {
        Scoring scoring = new Scoring(123);
        Map<String, Integer> resultMap = scoring.score("132");
        assertEquals(1, (int) resultMap.get("스트라이크"));
        assertEquals(2, (int) resultMap.get("볼"));
    }

    @Test
    public void 볼2() {
        Scoring scoring = new Scoring(123);
        Map<String, Integer> resultMap = scoring.score("321");
        assertEquals(2, (int) resultMap.get("볼"));
    }

    @Test
    public void 낫싱() {
        Scoring scoring = new Scoring(123);
        Map<String, Integer> resultMap = scoring.score("789");
        assertEquals(0, (int) resultMap.size());
    }

}