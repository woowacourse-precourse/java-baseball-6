package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class RefereeTest {

    @DisplayName("감독 클래스를 생성했을 때, 맴버 변수로 정답 리스트를 가지고 있는지에 대한 테스트")
    @Test
    void constructorTest() {
        //given
        List<Integer> answerList = List.of(3, 8, 6);
        //when
        Referee referee = new Referee(answerList);
        //then
        assertThat(referee.getAnswerList()).isEqualTo(answerList);
        assertThat(referee.getAnswerList().size()).isEqualTo(3);
        assertThat(referee.getAnswerList()).isEqualTo(answerList);
    }

    @DisplayName("유저의 숫자를 정답과 비교하여 볼을 판정하는 테스트")
    @Test
    void judgeNumberTest() {
        //given
        int firstNumber = 4;
        int secondNumber = 9;
        int thirdNumber = 2;
        List<Integer> answerList = List.of(firstNumber, secondNumber, thirdNumber);
        Referee referee = new Referee(answerList);
        //when
        int result = referee.judgeNumber(firstNumber, 1);
        //then
        assertThat(result).isEqualTo(1);
    }

    @Test
    void judgeNumber() {
    }
}