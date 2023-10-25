package baseball;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class NumberFactoryTest {

    @Test
    void 중복되지_않은_3개의_숫자_리스트_생성() {
        //given
        final int LIMIT = 3;
        List<Integer> numbers = NumberFactory.createNumbers();

        //when
        Set<Integer> sets = new HashSet<>(numbers);

        //then
        assertThat(numbers.size()).isEqualTo(LIMIT);
        assertThat(sets.size()).isEqualTo(LIMIT);
    }

}