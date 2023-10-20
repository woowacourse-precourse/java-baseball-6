package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomAnswerFactoryTest {
    @Test
    void 서로_다른_3자리수_생성(){
        RandomAnswerFactory randomAnswerFactory = new RandomAnswerFactory();

        List<Integer> answer = randomAnswerFactory.getRandomAnswer();

        assertEquals(answer.size(), 3);
        assertNotEquals(answer.get(0), answer.get(1));
        assertNotEquals(answer.get(1), answer.get(2));
        assertNotEquals(answer.get(0), answer.get(2));
    }
}