package baseball.model;

import baseball.type.MessageType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
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
    void 스트라이크_볼_카운트_검증() {

        //완벽한 매치의 경우
        pitchCount.countStrikeBall(computerNumber, userNumberCorrect);
        assertTrue(pitchCount.isAnswer());
        assertEquals(3, pitchCount.getStrikeCnt());
        assertEquals(0, pitchCount.getBallCnt());

        //숫자가 전혀 맞지 않는 경우
        pitchCount.countStrikeBall(computerNumber, userNumberDifferent);
        assertEquals(0, pitchCount.getStrikeCnt());
        assertEquals(0, pitchCount.getBallCnt());

        //일부 숫자가 맞는 경우
        pitchCount.countStrikeBall(computerNumber, userNumberPartialMatch);
        assertEquals(1, pitchCount.getStrikeCnt());
        assertEquals(2, pitchCount.getBallCnt());
    }


    @Test
    void 힌트_출력_검증() {
        PitchCount pitchCount = new PitchCount();

        pitchCount.countStrikeBall(computerNumber, userNumberCorrect);
        assertThat(pitchCount.getHint()).isEqualTo(3 + STRIKE.getMessage());

        pitchCount.countStrikeBall(computerNumber, userNumberDifferent);
        assertThat(pitchCount.getHint()).isEqualTo(NOTHING.getMessage());

        pitchCount.countStrikeBall(computerNumber, userNumberPartialMatch);
        assertThat(pitchCount.getHint()).isEqualTo(2 + BALL.getMessage() + " " + 1 + STRIKE.getMessage());

    }
}