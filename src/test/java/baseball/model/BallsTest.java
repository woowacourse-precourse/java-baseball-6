package baseball.model;

import baseball.Computer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class BallsTest {

    @DisplayName("랜덤한 숫자를 입력받는 Balls 생성")
    @Test
    public void createBalls_randomNums() throws Exception {
        //given
        Computer computer = new Computer();
        List<Integer> randomNumbers = computer.createRandomNumbers();

        //when
        Balls balls = new Balls(randomNumbers);
        List<Ball> ballList = randomNumbers.stream()
                .map((num) -> new Ball(num))
                .toList();
        //then
        assertThat(balls.getBalls()).containsExactlyElementsOf(ballList);
    }

    @DisplayName("랜덤한 숫자를 입력받는 Balls 생성 예외 : 숫자가 중복되는 경우 예외 발생")
    @Test
    public void createBalls_randomNums_exception_duplicatedNumber() throws Exception {
        //given
        List<Integer> IllegalList = List.of(1, 1, 2);

        //when, then
        assertThatThrownBy(() -> new Balls(IllegalList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않는 3자리 수를 입력해 주세요.");
    }

    @DisplayName("랜덤한 숫자를 입력받는 Balls 생성 예외 : 숫자가 3개가 아닌 경우 예외 발생")
    @Test
    public void createBalls_randomNums_exception_sizeNotMatch() throws Exception {
        //given
        List<Integer> IllegalList = List.of(1, 2);

        //when, then
        assertThatThrownBy(() -> new Balls(IllegalList))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("중복되지 않는 3자리 수를 입력해 주세요.");
    }

    @DisplayName("랜덤한 숫자를 입력받는 Balls 생성 예외 : null 값이 주어진 경우 예외 발생")
    @Test
    public void createBalls_randomNums_exception_nullPointer() throws Exception {
        //given
        List<Integer> IllegalList = null;

        //when, then
        assertThatThrownBy(() -> new Balls(IllegalList))
                .isInstanceOf(NullPointerException.class);
    }
}
