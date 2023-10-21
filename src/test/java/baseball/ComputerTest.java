package baseball;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ComputerTest {
    final int SIZE = 3;
    final int START_INCLUSIVE = 1;
    final int END_INCLUSIVE = 9;

    Computer computer = new Computer();

    @Test
    void createTest() {
        computer.createNumbers();
        List<Integer> numbers = computer.getNumbers();

        Assertions.assertThat(numbers.size()).isEqualTo(SIZE);
        for (Integer number : numbers) {
            Assertions.assertThat(number).isInstanceOf(Integer.class);
        }
        for (Integer number : numbers) {
            Assertions.assertThat(number).isBetween(START_INCLUSIVE, END_INCLUSIVE);
        }
        Set<Integer> duplicate = new HashSet<>(numbers);
        Assertions.assertThat(duplicate.size()).isEqualTo(SIZE);
    }
}