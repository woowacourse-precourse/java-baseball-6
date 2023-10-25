package baseball;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GameTest {
    private Game game;
    private List<Integer> number;

    @BeforeEach
    public void setUp() {
        game = new Game();
        number = game.getComputer();
    }

    @Test
    void 세자리의_수를_생성한다() {
        Assertions.assertThat(number.size()).isEqualTo(3);
    }
}
