package baseball;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

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

    @Test
    void 입력한_숫자_끝_범위가_숫자_시작_범위보다_작은_경우_예외를_발생시킨다() {

        int startNumber = Integer.MAX_VALUE;
        int endNumber = 0;
        int size = 3;

        RandomNumberPicker randomNumberPicker = new RandomNumberPicker();

        assertThatThrownBy(
            () -> randomNumberPicker.pickDistinctNumbersInRange(startNumber, endNumber, size))
            .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void 입력한_숫자_범위가_뽑아야_할_숫자_갯수_보다_작은_경우_예외를_발생시킨다() {

        int startNumber = 1;
        int endNumber = 10;
        int size = Integer.MAX_VALUE;

        RandomNumberPicker randomNumberPicker = new RandomNumberPicker();

        assertThatThrownBy(
            () -> randomNumberPicker.pickDistinctNumbersInRange(startNumber, endNumber, size))
            .isInstanceOf(IllegalArgumentException.class);
    }
}
