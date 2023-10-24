package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.domain.Numbers;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumbersTest {

    @Test
    void 숫자가_3자리가_아니면_예외를_던진다() {
        List<Integer> numbers1 = List.of(1, 2, 3, 4, 5);
        List<Integer> numbers2 = List.of(1, 2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> Numbers.fromInputNumbers(numbers1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Numbers.fromInputNumbers(numbers2));
    }

    @Test
    void 중복된_숫자가_있으면_예외를_던진다() {
        List<Integer> numbers = List.of(1, 1, 2);

        Assertions.assertThrows(IllegalArgumentException.class, () -> Numbers.fromInputNumbers(numbers));
    }

    @Test
    void 각_숫자의_크기가_1이상_9이하가_아니면_예외를_던진다() {
        List<Integer> numbers1 = List.of(10, 2, 4);
        List<Integer> numbers2 = List.of(0, 3, 5);

        Assertions.assertThrows(IllegalArgumentException.class, () -> Numbers.fromInputNumbers(numbers1));
        Assertions.assertThrows(IllegalArgumentException.class, () -> Numbers.fromInputNumbers(numbers2));
    }

    @Test
    void 같은_포지션에_같은_숫자가_존재하면_참을_반환한다() {
        List<Integer> answerNumbers = List.of(1, 2, 3);
        List<Integer> inputNumbers = List.of(1, 4, 3);

        Numbers computerNumbers = Numbers.fromInputNumbers(answerNumbers);
        Numbers playerNumbers = Numbers.fromInputNumbers(inputNumbers);

        assertThat(computerNumbers.isSamePosition(playerNumbers, 0)).isEqualTo(true);
    }

    @Test
    void 다른_포지션에_같은_숫자가_존재하면_참을_반환한다() {
        List<Integer> answerNumbers = List.of(1, 2, 3);
        List<Integer> inputNumbers = List.of(3, 4, 6);

        Numbers computerNumbers = Numbers.fromInputNumbers(answerNumbers);
        Numbers playerNumbers = Numbers.fromInputNumbers(inputNumbers);

        assertThat(computerNumbers.isSameNumber(playerNumbers, 0)).isEqualTo(true);
    }
}
