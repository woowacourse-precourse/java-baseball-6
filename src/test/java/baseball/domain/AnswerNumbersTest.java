package baseball.domain;

import baseball.constant.NumberConstant;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.assertj.core.api.Assertions.assertThat;

class AnswerNumbersTest {

    @Test
    void 스트라이크_개수를_확인하는_테스트() {
        //given
        AnswerNumbers answerNumbers = new AnswerNumbers(Arrays.asList(1, 3, 5));
        List<Integer> inputList1 = Arrays.asList(1, 3, 5);
        List<Integer> inputList2 = Arrays.asList(1, 3, 7);
        List<Integer> inputList3 = Arrays.asList(2, 6, 5);
        List<Integer> inputList4 = Arrays.asList(2, 5, 3);

        //when
        int strikeNum1 = answerNumbers.getStrike(inputList1);
        int strikeNum2 = answerNumbers.getStrike(inputList2);
        int strikeNum3 = answerNumbers.getStrike(inputList3);
        int strikeNum4 = answerNumbers.getStrike(inputList4);

        //then
        assertThat(strikeNum1).isEqualTo(3);
        assertThat(strikeNum2).isEqualTo(2);
        assertThat(strikeNum3).isEqualTo(1);
        assertThat(strikeNum4).isEqualTo(0);

    }

    @Test
    void 볼의_개수를_확인하는_테스트() {
        //given
        AnswerNumbers answerNumbers = new AnswerNumbers(Arrays.asList(1, 3, 5));
        List<Integer> inputList1 = Arrays.asList(1, 3, 5);
        List<Integer> inputList2 = Arrays.asList(3, 2, 6);
        List<Integer> inputList3 = Arrays.asList(3, 5, 2);
        List<Integer> inputList4 = Arrays.asList(5, 1, 3);

        //when
        int ballNum1 = answerNumbers.getBall(inputList1);
        int ballNum2 = answerNumbers.getBall(inputList2);
        int ballNum3 = answerNumbers.getBall(inputList3);
        int ballNum4 = answerNumbers.getBall(inputList4);

        //then
        assertThat(ballNum1).isEqualTo(0);
        assertThat(ballNum2).isEqualTo(1);
        assertThat(ballNum3).isEqualTo(2);
        assertThat(ballNum4).isEqualTo(3);
    }

    @Test
    void 볼과_스트라이크의_개수를_확인하는_테스트() {
        //given
        AnswerNumbers answerNumbers = new AnswerNumbers(Arrays.asList(1, 3, 5));
        List<Integer> inputList = Arrays.asList(2, 5, 3);

        //when
        Map<Integer, Integer> ballNStrkie =
                answerNumbers.getBallNStrkie(inputList);
        Integer ballNum = ballNStrkie.get(NumberConstant.BALL);
        Integer strikeNum = ballNStrkie.get(NumberConstant.STRIKE);

        //then
        assertThat(ballNum).isEqualTo(2);
        assertThat(strikeNum).isEqualTo(0);
    }


}