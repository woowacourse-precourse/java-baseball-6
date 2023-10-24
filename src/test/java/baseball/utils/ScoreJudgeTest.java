package baseball.utils;

import baseball.utils.ScoreJudge;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

public class ScoreJudgeTest {
    List<Integer> correctAnswer = new ArrayList<>();    // 정답은 123

    @BeforeEach
    void setUp() {
        correctAnswer.add(1);
        correctAnswer.add(2);
        correctAnswer.add(3);
    }

    @Test
    void 정답이_123일때_입력이_456이면_결과는_낫싱() {
        assertResult("낫싱", "456");
    }

    @Test
    void 정답이_123일때_입력이_245이면_결과는_1볼() {
        assertResult("1볼", "245");
    }

    @Test
    void 정답이_123일때_입력이_241이면_결과는_2볼() {
        assertResult("2볼", "241");
    }

    @Test
    void 정답이_123일때_입력이_312이면_결과는_3볼() {
        assertResult("3볼", "312");
    }

    @Test
    void 정답이_123일때_입력이_134이면_결과는_1볼1스트라이크() {
        assertResult("1볼 1스트라이크", "134");
    }

    @Test
    void 정답이_123일때_입력이_321이면_결과는_2볼1스트라이크() {
        assertResult("2볼 1스트라이크", "321");
    }

    @Test
    void 정답이_123일때_입력이_423이면_결과는_2스트라이크() {
        assertResult("2스트라이크", "423");
    }

    @Test
    void 정답이_123일때_입력이_123이면_결과는_3스트라이크() {
        assertResult("3스트라이크", "123");
    }

    private void assertResult(String expected, String userInput) {
        String guessResult = ScoreJudge.judgeScore(correctAnswer, userInput);
        Assertions.assertEquals(expected, guessResult);
    }
}
