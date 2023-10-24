package baseball;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class AnswerMakerTest {

    @Test
    void 중복수_테스트() {
        AnswerMaker answer = new AnswerMaker();
        answer.makeAnswer(1, 9);
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
            AnswerMaker answer = new AnswerMaker();
            answer.makeAnswer(1, 9);
            List<Integer> testList = answer.getAnswer();
            assertEquals(3, testList.size());
        }
    }

    @DisplayName("객체 생성 후 올바른 정답이 저장되는지 테스트")
    @Test
    public void testSaveAnswer() throws Exception {
        //given
        int min = 1;
        int max = 9;

        //when
        AnswerMaker answerMaker1 = new AnswerMaker();
        answerMaker1.makeAnswer(1, 9);
        List<Integer> answer = answerMaker1.getAnswer();
        //then
        assertEquals(3, answer.size(), "세 자리 숫자입니다!");
        assertTrue(answer.stream().allMatch(num -> num >= min && num <= max),
                "범위 내의 숫자입니다!");

    }

    @DisplayName("다른 답을 생성하는지 테스트")
    @Test
    public void saveAnswerTest() throws Exception {
        int min = 1;
        int max = 9;

        AnswerMaker answer = new AnswerMaker();
        answer.makeAnswer(1, 9);
        List<Integer> testAnswer = answer.getAnswer();
        answer.makeAnswer(1, 9);
        List<Integer> testAnswer2 = answer.getAnswer();

        assertNotEquals(testAnswer2, testAnswer);

    }
}