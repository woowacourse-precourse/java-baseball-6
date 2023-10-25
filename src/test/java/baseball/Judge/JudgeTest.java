package baseball.Judge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.Test;

class JudgeTest {

    Judge judge = new Judge();


    @Test
    void judgeStrike() {
        //given
        Integer[] ans = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(ans));
        String input = "122";
        judge.setAnswer(list);
        judge.setInput(input);

        //when
        int strike = judge.judgeStrike();

        //then
        assertThat(strike).isEqualTo(2);


    }

    @Test
    void judgeBall() {
        //given
        Integer[] ans = {1, 2, 3};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(ans));
        String input = "112";
        judge.setAnswer(list);
        judge.setInput(input);
        //when
        int ball = judge.judgeBall();

        //then
        assertThat(ball).isEqualTo(3);
    }
}