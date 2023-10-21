package baseball;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CompareWithAnswerTest {
    @Test
    public void 숫자비교_테스트_1볼_1스트라이크(){
        //given
        List<Integer> answer_nums = Arrays.asList(2, 9, 4);
        List<Integer> user_nums = Arrays.asList(1, 2, 4);
        //when
        Boolean result = CompareWithAnswer.compareWithAnswer(answer_nums, user_nums);
        //then
        assertEquals(false,result);
    }

    @Test
    public void 숫자비교_테스트_3스트라이크(){
        //given
        List<Integer> answer_nums = Arrays.asList(2, 9, 4);
        List<Integer> user_nums = Arrays.asList(2, 9, 4);
        //when
        Boolean result = CompareWithAnswer.compareWithAnswer(answer_nums, user_nums);
        //then
        assertEquals(true,result);
    }

}