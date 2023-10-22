package baseball;

import static org.assertj.core.api.Assertions.*;

import java.util.List;
import baseball.domain.NumberComparer;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class NumberComparerTest {
    @Test
    @DisplayName("컴퓨터와 플레이어는 같은 숫자가 같은 자리에 위치한다.")
    void test1() {
        int strikeCount = 0;
        List<Integer> computerNumbers = List.of(3, 5, 6);
        String playerNumbers = "341";

        NumberComparer numberComparer = new NumberComparer();
        numberComparer.compareNumbers(playerNumbers, computerNumbers);

        strikeCount = numberComparer.getStrikeCount();

        assertThat(strikeCount).isEqualTo(1);
    }
}
