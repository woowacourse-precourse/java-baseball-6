package baseball.domain;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class BaseballNumberTest {

    @Test
    void numbers의_사이즈가_범위를_벗어나면_IllegalArgumentException가_발생한다() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void numbers의_중복된_숫자가_존재하면_IllegalArgumentException가_발생한다() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(2);

        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void numbers의_각각의_숫자들이_범위를_벗어나면_IllegalArgumentException가_발생한다() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(0);
        numbers.add(2);
        numbers.add(3);

        assertThatThrownBy(() -> new BaseballNumber(numbers))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void getNumberByIndex_메서드는_인덱스에_맞는_값을_가져온다() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        BaseballNumber baseballNumber = new BaseballNumber(numbers);

        assertEquals(baseballNumber.getNumberByIndex(1), 2);
    }

    @Test
    void isNumberContains_메서드는_매개변수로_주어진_값이_포함되어_있으면_true를_반환한다() {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        BaseballNumber baseballNumber = new BaseballNumber(numbers);

        assertTrue(baseballNumber.isNumberContains(3));
    }
}
