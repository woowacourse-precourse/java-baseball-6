package baseball.core.rule;

import baseball.Enum.NumberSize;
import java.util.List;

public class RuleV1 implements Rule {


    public static RuleV1 makeScoreStrategy() {
        return new RuleV1();
    }

    @Override
    public ScoreResult calculatePoints(PickedNumbers pickedNumbers) {
        ScoreResult scoreResult = ScoreResult.makeScoreResult();
        List<Integer> opponentNumberList = pickedNumbers.getOpponentNumberList();
        List<Integer> playerNumberList = pickedNumbers.getPlayerNumberList();
        calculateStrikeScore(opponentNumberList, playerNumberList, scoreResult);
        calculateBallScore(opponentNumberList, playerNumberList, scoreResult);
        return scoreResult;
    }

    private void calculateStrikeScore(List<Integer> opponentNumberList,
            List<Integer> playerNumberList, ScoreResult scoreResult) {
        for (int i = 0; i < NumberSize.MAX_SIZE.getSize(); i++) {
            if (opponentNumberList.get(i).equals(playerNumberList.get(i))) {
                scoreResult.addStrike();
            }
        }
    }

    private void calculateBallScore(List<Integer> opponentNumberList,
            List<Integer> playerNumberList, ScoreResult scoreResult) {
        for (int i = 0; i < NumberSize.MAX_SIZE.getSize(); i++) {
            for (int j = 0; j < NumberSize.MAX_SIZE.getSize(); j++) {
                if (!opponentNumberList.get(i).equals(playerNumberList.get(i))) {
                    if (opponentNumberList.get(i).equals(playerNumberList.get(j))) {
                        scoreResult.addBall();
                    }
                }
            }
        }
    }
}
