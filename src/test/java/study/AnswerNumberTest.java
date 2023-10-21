package study;

import static org.junit.jupiter.api.Assertions.*;

import baseball.Model.AnswerNumber;
import java.util.List;
import org.junit.jupiter.api.Test;

class AnswerNumberTest {

    @Test
    void getAnswerNumber() {
        AnswerNumber answerNumber = new AnswerNumber();
        List<Integer> generatedNumber = answerNumber.getAnswerNumber();

        System.out.println("자동 생성된 숫자 : " + generatedNumber);

        assertEquals(3, generatedNumber.size(), "생성된 숫자 길이는 3");
        for(int number : generatedNumber){
            assertTrue(number >= 1 && number <= 9, "생성된 숫자는 1과 9 사이");
        }
        assertEquals(generatedNumber.size(), generatedNumber.stream().distinct().count(), "전부 다른 숫자");
    }
}