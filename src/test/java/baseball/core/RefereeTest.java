package baseball.core;

import static org.junit.jupiter.api.Assertions.*;

import baseball.Enum.GameStatus;
import baseball.core.rule.PickedNumbers;
import baseball.core.rule.RuleV1;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class RefereeTest {

    @Test
    void oneBallOneStrike() {
        List<Integer> opponentNumberList = List.of(1, 2, 3);
        List<Integer> playerNumberList = List.of(1, 3, 4);
        PickedNumbers pickedNumbers = PickedNumbers.createPickedNumbers(opponentNumberList,
                playerNumberList);

        Referee referee = new Referee(RuleV1.makeScoreStrategy());
        referee.checkPoint(pickedNumbers);

        Assertions.assertThat(referee.getGameStatus()).isEqualTo(GameStatus.IN_PROGRESS);

    }

    @Test
    void threeStrike() {
        List<Integer> opponentNumberList = List.of(1, 2, 3);
        List<Integer> playerNumberList = List.of(1, 2, 3);
        PickedNumbers pickedNumbers = PickedNumbers.createPickedNumbers(opponentNumberList,
                playerNumberList);

        Referee referee = new Referee(RuleV1.makeScoreStrategy());
        referee.checkPoint(pickedNumbers);

        Assertions.assertThat(referee.getGameStatus()).isEqualTo(GameStatus.WIN);


    }
}