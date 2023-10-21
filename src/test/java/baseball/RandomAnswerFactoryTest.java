package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class RandomAnswerFactoryTest {
    @Test
    void 서로_다른_3자리수_생성(){
        RandomAnswerFactory randomAnswerFactory = new RandomAnswerFactory();

        Answer answer1 = randomAnswerFactory.getRandomAnswer();
        Answer answer2 = randomAnswerFactory.getRandomAnswer();

        assertNotEquals(answer1.getFirstNumber(), answer1.getSecondNumber());
        assertNotEquals(answer1.getFirstNumber(), answer1.getThirdNumber());
        assertNotEquals(answer1.getSecondNumber(), answer1.getThirdNumber());

        assertNotEquals(answer1, answer2);
    }
}