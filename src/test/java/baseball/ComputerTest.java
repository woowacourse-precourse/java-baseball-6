package baseball;

import static org.assertj.core.api.AssertionsForInterfaceTypes.assertThat;

import java.lang.reflect.Method;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ComputerTest {
    Computer computer = new Computer();

    @DisplayName("리스트 3볼 판별 기능 테스트")
    @Test
    public void threeBallScoreTest() throws Exception {
        //given
        List<Integer> answer = List.of(3, 6, 9);
        List<Integer> userAnswer = List.of(6, 9, 3);
        Method method = computer.getClass().getDeclaredMethod("judgeScore", List.class, int.class, int.class);
        method.setAccessible(true);

        //when
        List<Integer> score = computer.countScore(answer, userAnswer);

        //then
        assertThat(score).isEqualTo(List.of(3, 0));
    }

    @DisplayName("리스트 낫싱 판별 기능 테스트")
    @Test
    public void nothingScoreTest() throws Exception {
        //given
        List<Integer> answer = List.of(3, 6, 9);
        List<Integer> userAnswer = List.of(1, 2, 4);

        //when
        List<Integer> score = computer.countScore(answer, userAnswer);

        //then
        assertThat(score).isEqualTo(List.of(0, 0));
    }

    @DisplayName("리스트 스트라이크 판별 기능 테스트")
    @Test
    public void strikeScoreTest() throws Exception {
        //given
        List<Integer> answer = List.of(3, 6, 9);
        List<Integer> userAnswer = List.of(3, 6, 9);

        //when
        List<Integer> score = computer.countScore(answer, userAnswer);

        //then
        assertThat(score).isEqualTo(List.of(0, 3));
    }

    @DisplayName("리스트 볼, 스트라이크 판별 기능 테스트")
    @Test
    public void ballStrikeScoreTest() throws Exception {
        //given
        List<Integer> answer = List.of(3, 6, 9);
        List<Integer> userAnswer = List.of(9, 6, 3);

        //when
        List<Integer> score = computer.countScore(answer, userAnswer);

        //then
        assertThat(score).isEqualTo(List.of(2, 1));
    }

    @DisplayName("볼 판별 기능 테스트")
    @Test
    void judgeBall() throws Exception {
        //given
        List<Integer> answer = List.of(3, 9, 6);
        int number = 3;
        int index = 2;
        Method method = computer.getClass().getDeclaredMethod("judgeScore", List.class, int.class, int.class);
        method.setAccessible(true);
        //when
        int result = (int) method.invoke(computer, answer, number, index);
        //then
        assertThat(result).isEqualTo(1);
    }


    @DisplayName("스트라이크 판별 기능 테스트")
    @Test
    public void judgeStrike() throws Exception {
        //given
        List<Integer> answer = List.of(3, 6, 9);
        int number = 3;
        int index = 0;
        Method method = computer.getClass().getDeclaredMethod("judgeScore", List.class, int.class, int.class);
        method.setAccessible(true);
        //when
        int result = (int) method.invoke(computer, answer, number, index);
        //then
        assertThat(result).isEqualTo(2);
    }


    @DisplayName("낫싱 판별 기능 테스트")
    @Test
    public void judgeNothing() throws Exception {
        //given
        List<Integer> answer = List.of(3, 6, 9);
        int number = 8;
        int index = 1;
        Method method = computer.getClass().getDeclaredMethod("judgeScore", List.class, int.class, int.class);
        method.setAccessible(true);
        //when
        int result = (int) method.invoke(computer, answer, number, index);
        //then
        assertThat(result).isEqualTo(0);
    }
}