package baseball;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class AnswerMakerTest {

    AnswerMaker answerMaker = new AnswerMaker(1, 9);

    @Test
    void 범위_내의_난수생성_테스트() {
        int min = 1;
        int max = 9;

        for (int i = 0; i < 9999; i++) {
            int randomNumber = answerMaker.makeNumbers(min, max);
            assertThat(randomNumber).isBetween(min, max);
        }
    }

    @Test
    void 중복수_테스트() {
        AnswerMaker answer = new AnswerMaker(1, 9);
        List<Integer> testList = answer.getAnswer();
        for (int i = 0; i < testList.size(); i++) {
            for (int j = i + 1; j < testList.size(); j++) {
                assertNotEquals(testList.get(i), testList.get(j));
            }
        }
    }

    @Test
    void 세_개의_숫자_테스트() {
        for (int i = 0; i < 100; i++) {
            AnswerMaker answer = new AnswerMaker(1, 9);
            List<Integer> testList = answer.getAnswer();
            assertEquals(3, testList.size());
        }

    }
}