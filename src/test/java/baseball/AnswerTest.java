package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class AnswerTest {

    @Test
    void 에측값_주면_힌트리스트_반환(){
        UserPrediction userPrediction = new UserPrediction(1,2,3);
        Answer answer = new Answer(1,3,2);

        List<Hint> hints = answer.getHintsWithUserPrediction(userPrediction);

        assertEquals(3, hints.size());
        assertEquals(Hint.STRIKE, hints.get(0));
        assertEquals(Hint.BALL, hints.get(1));
        assertEquals(Hint.BALL, hints.get(2));
    }

}