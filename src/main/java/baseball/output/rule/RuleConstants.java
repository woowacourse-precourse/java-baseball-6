package baseball.output.rule;

import baseball.game.BallAndStrike;
import java.util.List;

public class RuleConstants {
    public static List<PrintBaseBallResultOutputRule> getStandardRules(final BallAndStrike ballAndStrike) {
        return List.of(
                new PrintBallWhenBallExistRule(ballAndStrike),
                new PrintSplitWhenBallAndStrikeExistRule(ballAndStrike),
                new PrintStrikeWhenStrikeExistRule(ballAndStrike),
                new PrintNothingWhenBothBallAndStrikeNotExistRule(ballAndStrike),
                new PrintNewLineRule()
        );
    }
}
