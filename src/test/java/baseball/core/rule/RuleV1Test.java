package baseball.core.rule;

import baseball.core.rule.PickedNumbers;
import baseball.core.rule.RuleV1;
import baseball.core.rule.ScoreResult;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RuleV1Test {

    @Test
    void when3Strike() {
        //if
        List<Integer> opponentNumberList = List.of(1, 2, 3);
        List<Integer> playerNumberList = List.of(1, 2, 3);
        PickedNumbers pickedNumbers = PickedNumbers.createPickedNumbers(opponentNumberList, playerNumberList);
        RuleV1 scoreStrategyV1 = RuleV1.makeScoreStrategy();

        //when
        scoreStrategyV1.calculatePoints(pickedNumbers);
        ScoreResult scoreResult = scoreStrategyV1.getScoreResult();

        //then
        Assertions.assertThat(scoreResult.getStrikeCount()).isEqualTo(3);
        Assertions.assertThat(scoreResult.getBallCount()).isEqualTo(0);
        Assertions.assertThat(scoreResult.isNothing()).isFalse();

    }

    @Test
    void when1Strike1Ball() {
        //if
        List<Integer> opponentNumberList = List.of(1, 2, 3);
        List<Integer> playerNumberList = List.of(1, 3, 0);
        PickedNumbers pickedNumbers = PickedNumbers.createPickedNumbers(opponentNumberList, playerNumberList);
        RuleV1 scoreStrategyV1 = RuleV1.makeScoreStrategy();

        //when
        scoreStrategyV1.calculatePoints(pickedNumbers);
        ScoreResult scoreResult = scoreStrategyV1.getScoreResult();

        //then
        Assertions.assertThat(scoreResult.getStrikeCount()).isEqualTo(1);
        Assertions.assertThat(scoreResult.getBallCount()).isEqualTo(1);
        Assertions.assertThat(scoreResult.isNothing()).isFalse();

    }

    @Test
    void whenNothing() {
        //if
        List<Integer> opponentNumberList = List.of(1, 2, 3);
        List<Integer> playerNumberList = List.of(4, 5, 0);
        PickedNumbers pickedNumbers = PickedNumbers.createPickedNumbers(opponentNumberList, playerNumberList);
        RuleV1 scoreStrategyV1 = RuleV1.makeScoreStrategy();

        //when
        scoreStrategyV1.calculatePoints(pickedNumbers);
        ScoreResult scoreResult = scoreStrategyV1.getScoreResult();

        //then
        Assertions.assertThat(scoreResult.getStrikeCount()).isEqualTo(0);
        Assertions.assertThat(scoreResult.getBallCount()).isEqualTo(0);
        Assertions.assertThat(scoreResult.isNothing()).isTrue();

    }
}