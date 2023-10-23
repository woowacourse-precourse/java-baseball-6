package baseball;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ComputerTest {

    @Test
    void initNumbers_길이_제한_테스트() {
        Computer computer = new Computer();

        computer.initNumbers();

        List<Integer> numbers = computer.getNumbers();
        int resultLength = BaseballValues.MAX_NUMBER_LENGTH.getValue();

        assertThat(numbers.size()).isEqualTo(resultLength);
    }

    @Test
    void initNumbers_중복_숫자_테스트() {

        List<Integer> duplicationNumbers = new ArrayList<>(Arrays.asList(1, 1, 1));

        Computer computer = new Computer(duplicationNumbers);

        computer.initNumbers();

        List<Integer> numbers = computer.getNumbers();

        assertThat(numbers).isNotIn(1);
    }
}
