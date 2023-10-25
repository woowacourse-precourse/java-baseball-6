package baseball;

import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

class NumberFactoryTest {

    @Test
    void 중복되지_않은_3개의_숫자_리스트_생성() {
        //given
        final int SIZE = 3;
        final int START = 1;
        final int END = 9;

        //when
        List<Integer> numbers = NumberFactory.createNumbers(SIZE, START, END);
        Set<Integer> sets = new HashSet<>(numbers);

        //then
        assertThat(numbers.size()).isEqualTo(SIZE);
        assertThat(sets.size()).isEqualTo(SIZE);
    }

    @Test
    void 범위의_숫자_내에서_생성() {
        //given
        final int SIZE = 1;
        final int START = 1;
        final int END = 9;

        //when
        List<Integer> numbers = NumberFactory.createNumbers(1, START, END);
        int number = numbers.get(SIZE - 1);

        //then
        assertThat(number).isGreaterThanOrEqualTo(START).isLessThanOrEqualTo(END);
    }

}