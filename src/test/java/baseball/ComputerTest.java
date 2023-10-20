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

    @DisplayName("볼 판별 기능 테스트")
    @Test
    void judgeBall() {
        //given
        List<Integer> answer = List.of(3,9,6);
        //when
        int result = computer.judgeScore(answer, 3,1);
        //then
        assertThat(result).isEqualTo(computer.BALL);
    }
}