package baseball;

import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import org.junit.jupiter.api.Test;

public class RandomsTest {

    @Test
    void pickNumberInList() {
        // given
        List<Integer> givenList = new ArrayList<>();
        for (int i = 111; i <= 999; i++) {
            givenList.add(i);
        }

        // when
        int result = Randoms.pickNumberInList(givenList);

        // then
        assertThat(result).isGreaterThanOrEqualTo(111);
        assertThat(result).isLessThanOrEqualTo(999);
    }

    @Test
    void pickNumberInRange() {
        // given // when
        int result = Randoms.pickNumberInRange(1, 999);

        // then
        assertThat(result).isGreaterThanOrEqualTo(1);
        assertThat(result).isLessThanOrEqualTo(999);
    }

    @Test
    void pickUniqueNumbersInRange() {
        // given // when
        List<Integer> result = Randoms.pickUniqueNumbersInRange(1, 999, 3);

        // then
        assertThat(result.size()).isEqualTo(3);
        assertThat(new HashSet<>(result).size()).isEqualTo(3);
        assertThat(result.get(0)).isLessThanOrEqualTo(999);
        assertThat(result.get(2)).isGreaterThanOrEqualTo(1);
    }

    @Test
    void shuffle() {
        // given
        List<Integer> givenList = new ArrayList<>();
        for (int i = 1; i <= 999; i++) {
            givenList.add(i);
        }

        // when
        List<Integer> result = Randoms.shuffle(givenList);

        // then
        assertThat(result.get(0)).isNotEqualTo(1);
        assertThat(result.get(998)).isNotEqualTo(999);
    }
}
