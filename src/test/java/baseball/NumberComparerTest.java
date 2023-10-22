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

    @Test
    @DisplayName("컴퓨터와 플레이어는 같은 숫자가 다른 자리에 위치한다.")
    void test2() {
        int ballCount = 0;
        List<Integer> computerNumbers = List.of(3, 5, 6);
        String playerNumbers = "635";

        NumberComparer numberComparer = new NumberComparer();
        numberComparer.compareNumbers(playerNumbers, computerNumbers);

        ballCount = numberComparer.getBallCount();

        assertThat(ballCount).isEqualTo(3);
    }

    @Test
    @DisplayName("비교 결과에 스트라이크와 볼 모두 존재한다.")
    void test3() {
        int strikeCount = 0;
        int ballCount = 0;
        List<Integer> computerNumbers = List.of(3, 5, 6);
        String playerNumbers = "365";

        NumberComparer numberComparer = new NumberComparer();
        numberComparer.compareNumbers(playerNumbers, computerNumbers);

        strikeCount = numberComparer.getStrikeCount();
        ballCount = numberComparer.getBallCount();

        assertThat(strikeCount).isEqualTo(1);
        assertThat(ballCount).isEqualTo(2);
    }

    @Test
    @DisplayName("같은 숫자가 존재하지 않는다.")
    void test4() {
        int strikeCount = 0;
        int ballCount = 0;
        List<Integer> computerNumbers = List.of(3, 5, 6);
        String playerNumbers = "124";

        NumberComparer numberComparer = new NumberComparer();
        numberComparer.compareNumbers(playerNumbers, computerNumbers);

        strikeCount = numberComparer.getStrikeCount();
        ballCount = numberComparer.getBallCount();

        assertThat(strikeCount).isEqualTo(0);
        assertThat(ballCount).isEqualTo(0);
    }
}
