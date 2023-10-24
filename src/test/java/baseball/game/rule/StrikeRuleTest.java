package baseball.game.rule;

import static org.assertj.core.api.Assertions.assertThat;

import baseball.game.BallAndStrike;
import baseball.game.BaseBallNumberGroup;
import java.util.List;
import org.junit.jupiter.api.Test;

public class StrikeRuleTest {

    @Test
    void 같은_위치에_같은_숫자인_경우_Strike_증가() {
        final StrikeRule strikeRule = new StrikeRule();
        final BallAndStrike zeroBallAndTwoStrike = strikeRule.apply(
                new BaseBallNumberGroup(List.of(1, 2, 3)),
                new BaseBallNumberGroup(List.of(1, 2, 4))
        );

        assertThat(zeroBallAndTwoStrike).isEqualTo(new BallAndStrike(0, 2));
    }
}
