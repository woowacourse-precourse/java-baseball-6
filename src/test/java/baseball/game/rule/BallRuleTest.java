package baseball.game.rule;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.BallAndStrike;
import baseball.game.BaseBallNumberGroup;
import java.util.List;
import org.junit.jupiter.api.Test;

public class BallRuleTest {

    @Test
    void 다른_위치에_같은_숫자인_경우_Ball_증가() {
        final BallRule ballRule = new BallRule();
        final BallAndStrike twoBallAndZeroStrike = ballRule.apply(
                new BaseBallNumberGroup(List.of(1, 2, 3)),
                new BaseBallNumberGroup(List.of(2, 3, 4))
        );

        assertThat(twoBallAndZeroStrike).isEqualTo(new BallAndStrike(2, 0));
    }
}
