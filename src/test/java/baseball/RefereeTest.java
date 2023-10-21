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

    @DisplayName("볼을 판정하는 테스트")
    @Test
    void judgeBallTest() {
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

    @DisplayName("스트라이크를 판정하는 테스트")
    @Test
    void judgeStrikeTest() {
        //given
        int firstNumber = 4;
        int secondNumber = 9;
        int thirdNumber = 2;
        List<Integer> answerList = List.of(firstNumber, secondNumber, thirdNumber);
        Referee referee = new Referee(answerList);
        //when
        int result = referee.judgeNumber(thirdNumber, 2);
        //then
        assertThat(result).isEqualTo(2);
    }

    @DisplayName("낫싱을 판정하는 테스트")
    @Test
    void judgeNothingTest() {
        //given
        int firstNumber = 4;
        int secondNumber = 9;
        int thirdNumber = 2;
        int notExistNumber = 5;
        List<Integer> answerList = List.of(firstNumber, secondNumber, thirdNumber);
        Referee referee = new Referee(answerList);
        //when
        int result = referee.judgeNumber(notExistNumber, 2);
        //then
        assertThat(result).isEqualTo(0);
    }

    @DisplayName("유저 inputList 전체 판정하는 테스트")
    @Test
    void judgeUserInputTest() {
        //given
        List<Integer> answerList = List.of(3, 7, 6);
        Referee referee = new Referee(answerList);
        List<Integer> userInput1 = List.of(3, 7, 6);
        List<Integer> userInput2 = List.of(7, 6, 3);
        List<Integer> userInput3 = List.of(3, 6, 7);
        List<Integer> userInput4 = List.of(2, 1, 8);
        List<Integer> userInput5 = List.of(3, 6, 1);
        //when
        List<Integer> result1 = referee.judgeUserInput(userInput1);
        List<Integer> result2 = referee.judgeUserInput(userInput2);
        List<Integer> result3 = referee.judgeUserInput(userInput3);
        List<Integer> result4 = referee.judgeUserInput(userInput4);
        List<Integer> result5 = referee.judgeUserInput(userInput5);
        //then
        assertThat(result1).isEqualTo(List.of(0, 3));
        assertThat(result2).isEqualTo(List.of(3, 0));
        assertThat(result3).isEqualTo(List.of(2, 1));
        assertThat(result4).isEqualTo(null);
        assertThat(result5).isEqualTo(List.of(1, 1));
    }
}