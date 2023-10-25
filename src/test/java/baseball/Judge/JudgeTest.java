package baseball.Judge;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(value = MethodOrderer.OrderAnnotation.class)
class JudgeTest {

    private static Judge judge = new Judge();


    @Test
    @Order(1)
    void judgeStrike() {
        //given
        Integer[] ans = {6, 3, 7};
        ArrayList<Integer> list = new ArrayList<>(Arrays.asList(ans));
        String input = "333";
        judge.setAnswer(list);
        judge.setInput(input);

        //when
        int strike = judge.judgeStrike();

        //then
        assertThat(strike).isEqualTo(2);


    }

    @Test
    @Order(2)
    void judgeBall() {

        //when
        int ball = judge.judgeBall();

        //then
        assertThat(ball).isEqualTo(1);
    }
}