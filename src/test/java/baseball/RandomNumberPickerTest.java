package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

public class RandomNumberPickerTest {


    @Test
    void 지정한_범위내의_숫자를_뽑을_수_있다() {
        int startNumber = 1;
        int endNumber = 10;
        int size = 3;

        RandomNumberPicker randomNumberPicker = new RandomNumberPicker();

        List<Integer> randomNumbers = randomNumberPicker.pickDistinctNumbersInRange(startNumber,
            endNumber, size);
        List<Integer> afterFilteringNumbers = randomNumbers.stream()
            .filter(i -> i < endNumber)
            .filter(i -> i >= startNumber)
            .toList();

        assertThat(randomNumbers).isEqualTo(afterFilteringNumbers);
    }

    @Test
    void 지정한_갯수_만큼의_숫자를_뽑을_수_있다() {
        int startNumber = 1;
        int endNumber = 10;
        int size = 3;

        RandomNumberPicker randomNumberPicker = new RandomNumberPicker();

        List<Integer> randomNumbers = randomNumberPicker.pickDistinctNumbersInRange(startNumber,
            endNumber, size);

        assertThat(randomNumbers.size()).isEqualTo(size);
    }

    @Test
    void 뽑은_숫자들은_중복된_숫자가_없다() {
        int startNumber = 1;
        int endNumber = 10;
        int size = 3;

        RandomNumberPicker randomNumberPicker = new RandomNumberPicker();
        List<Integer> randomNumbers = randomNumberPicker.pickDistinctNumbersInRange(startNumber,
            endNumber, size);
        List<Integer> distinctRandomNumbers = randomNumbers.stream().distinct().toList();

        assertThat(distinctRandomNumbers.size()).isEqualTo(randomNumbers.size());
    }
}
