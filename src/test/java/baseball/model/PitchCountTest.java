package baseball.model;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static baseball.type.MessageType.*;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class PitchCountTest {

    PitchCount pitchCount;
    List<Integer> computerNumber;
    List<Integer> userNumberCorrect;
    List<Integer> userNumberDifferent;
    List<Integer> userNumberPartialMatch;


    @BeforeEach
    void init() {
        pitchCount = new PitchCount();
        computerNumber = Arrays.asList(1, 2, 3);
        userNumberCorrect = Arrays.asList(1, 2, 3);
        userNumberDifferent = Arrays.asList(7, 8, 9);
        userNumberPartialMatch = Arrays.asList(1, 3, 2);
    }


    @Test
    void 카운트_검증_스트라이크() {
        pitchCount.evaluateStrikeAndBall(computerNumber, userNumberCorrect);
        assertEquals(3, pitchCount.getStrikeCnt());
        assertEquals(0, pitchCount.getBallCnt());
        assertTrue(pitchCount.isAnswer());
    }


    @Test
    void 카운트_검증_낫싱() {
        pitchCount.evaluateStrikeAndBall(computerNumber, userNumberDifferent);
        assertEquals(0, pitchCount.getStrikeCnt());
        assertEquals(0, pitchCount.getBallCnt());
    }


    @Test
    void 카운트_검증_볼_스트라이크() {
        pitchCount.evaluateStrikeAndBall(computerNumber, userNumberPartialMatch);
        assertEquals(1, pitchCount.getStrikeCnt());
        assertEquals(2, pitchCount.getBallCnt());
    }


    @Test
    void 힌트_출력_검증_스트라이크() {
        pitchCount.evaluateStrikeAndBall(computerNumber, userNumberCorrect);
        assertThat(pitchCount.getHint()).isEqualTo(3 + STRIKE.getMessage());
    }


    @Test
    void 힌트_출력_검증_낫싱() {
        pitchCount.evaluateStrikeAndBall(computerNumber, userNumberDifferent);
        assertThat(pitchCount.getHint()).isEqualTo(NOTHING.getMessage());
    }


    @Test
    void 힌트_출력_검증_볼_스트라이크() {
        pitchCount.evaluateStrikeAndBall(computerNumber, userNumberPartialMatch);
        assertThat(pitchCount.getHint()).isEqualTo(2 + BALL.getMessage() + " " + 1 + STRIKE.getMessage());
    }
}