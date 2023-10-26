package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.ball.Balls;
import baseball.validate.GameValidate;
import baseball.validate.NumbersValidate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    BaseballGameRuleTest baseballGameRuleTest = new BaseballGameRuleTest();
    @Test
    @DisplayName("3 자리의 숫자 인지 확인한다.")
    public void pick3NumberTest() {
        Computer computer = new Computer();
        List<Integer> computersRandomNumbers = computer.pickNumbers();
        assertThat(computersRandomNumbers.size()).isEqualTo(baseballGameRuleTest.getBaseballMaxAmount());
        assertThat(GameValidate.isCorrectSize(computersRandomNumbers)).isTrue();
    }
    @Test
    @DisplayName("중복을 확인한다")
    public void pick3AllDifferentNumberTest() {
        Computer computer = new Computer();
        List<Integer> computersRandomNumbers = computer.pickNumbers();
        assertThat(NumbersValidate.isNumberNotDuplicate(computersRandomNumbers)).isTrue();

    }
    @Test
    @DisplayName("숫자의 한 자리수의 범위가 1~9 인지 확인한다.")
    public void pick3NumberRangeTest() {
        Computer computer = new Computer();
        List<Integer> computersRandomNumbers = computer.pickNumbers();
        assertThat(GameValidate.isNumberInRange(computersRandomNumbers)).isTrue();
    }
    @Test
    @DisplayName("3가지 숫자를 선택하여 공을 만든다.")
    public void pick3NumberAndGetBallTest() {

        Computer computer = new Computer();
        List<Integer> computersRandomNumbers = computer.pickNumbers();

        Balls balls = computer.initBallsForGame(computersRandomNumbers);
        Balls targetBalls = computer.initBallsForGame(computersRandomNumbers);

        assertThat(balls.equals(targetBalls)).isTrue();
    }
}
