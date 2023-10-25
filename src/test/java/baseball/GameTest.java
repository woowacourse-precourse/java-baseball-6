package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class GameTest {
    final Game game = new Game();
    final List<Integer> number = game.getComputer();

    @Test
    void 세자리의_수를_생성한다() {
        Assertions.assertThat(number.size())
                .isEqualTo(3);
    }

    @Test
    void 서로_다른_수로_이루어진_세자리의_수를_생성한다() {
        Set<Integer> uniqueNumber = new HashSet<>(number);
        Assertions.assertThat(uniqueNumber.size())
                .isEqualTo(3);
    }
}
