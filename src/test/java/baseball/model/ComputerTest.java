package baseball.model;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.model.Computer;
import baseball.validate.NumbersValidate;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class ComputerTest {
    @Test
    @DisplayName("3 자리의 숫자 인지 확인한다.")
    public void pick3NumberTest() {
        Computer computer = new Computer();
        List<Integer> computersRandomNumbers = computer.pickNumbers();
        assertThat(computersRandomNumbers.size()).isEqualTo(3);
        assertThat(NumbersValidate.isCorrectSize(computersRandomNumbers)).isTrue();
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
        assertThat(NumbersValidate.isNumberInRange(computersRandomNumbers)).isTrue();
    }
}
