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
    }

    @Test
    void judgeUserInput() {
    }

    @Test
    void judgeNumber() {
    }
}