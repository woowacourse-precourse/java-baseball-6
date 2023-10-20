package baseball;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.in;
import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ComputerTest {
    Computer computer = new Computer();


    @DisplayName("리스트 3볼 판별 기능 테스트")
    @Test
    public void threeBallScoreTest() throws Exception {
        //given
        List<Integer> answer = List.of(3,6,9);
        List<Integer> userAnswer = List.of(6,9,3);

        //when
        List<Integer> score = computer.countScore(answer, userAnswer);

        //then
        assertThat(score).isEqualTo(List.of(3,0));
    }

    @DisplayName("리스트 낫싱 판별 기능 테스트")
    @Test
    public void nothingScoreTest() throws Exception {
        //given
        List<Integer> answer = List.of(3,6,9);
        List<Integer> userAnswer = List.of(1,2,4);

        //when
        List<Integer> score = computer.countScore(answer, userAnswer);

        //then
        assertThat(score).isEqualTo(List.of(0,0));
    }

    @DisplayName("리스트 스트라이크 판별 기능 테스트")
    @Test
    public void strikeScoreTest() throws Exception {
        //given
        List<Integer> answer = List.of(3,6,9);
        List<Integer> userAnswer = List.of(3,6,9);

        //when
        List<Integer> score = computer.countScore(answer, userAnswer);

        //then
        assertThat(score).isEqualTo(List.of(0,3));
    }

    @DisplayName("리스트 볼, 스트라이크 판별 기능 테스트")
    @Test
    public void ballStrikeScoreTest() throws Exception {
        //given
        List<Integer> answer = List.of(3,6,9);
        List<Integer> userAnswer = List.of(9,6,3);

        //when
        List<Integer> score = computer.countScore(answer, userAnswer);

        //then
        assertThat(score).isEqualTo(List.of(2,1));
    }

    @DisplayName("볼 판별 기능 테스트")
    @Test
    void judgeBall() {
        //given
        List<Integer> answer = List.of(3,9,6);
        int number = 3;
        int index = 2;
        //when
        int result = computer.judgeScore(answer, number, index);
        //then
        assertThat(result).isEqualTo(1);
    }


    @DisplayName("스트라이크 판별 기능 테스트")
    @Test
    public void judgeStrike() throws Exception {
        //given
        List<Integer> answer = List.of(3,6,9);
        int number = 3;
        int index = 0;
        //when
        int result = computer.judgeScore(answer, number, index);
        //then
        assertThat(result).isEqualTo(2);
    }


    @DisplayName("낫싱 판별 기능 테스트")
    @Test
    public void judgeNothing() throws Exception {
        //given
        List<Integer> answer = List.of(3,6,9);
        int number = 8;
        int index = 1;
        //when
        int result = computer.judgeScore(answer, number, index);
        //then
        assertThat(result).isEqualTo(0);
    }
}