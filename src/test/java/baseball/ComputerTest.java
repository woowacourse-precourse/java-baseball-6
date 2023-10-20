package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    Computer computer = new Computer();

    @Test
    void countScore() {
    }

    @Test
    void judgeScore() {
    }

    @DisplayName("컴퓨터가 정답을 저장하고 있는지 테스트")
    @Test
    void saveAnswer() {
        //given
        List<Integer> answer = List.of(4,5,6);
        //when
        computer.setAnswer(answer);
        //then
    }
}