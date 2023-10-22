package baseball.core.rule;

import baseball.Enum.ConsoleNumberSizeEnum;
import java.util.List;

public class RuleV1 implements Rule {

    private final ScoreResult scoreResult;

    protected RuleV1(ScoreResult scoreResult) {
        this.scoreResult = scoreResult;
    }

    public static RuleV1 makeScoreStrategy(){
        return new RuleV1(ScoreResult.makeScoreResult());
    }
    @Override
    public void calculatePoints(PickedNumbers pickedNumbers){
        List<Integer> opponentNumberList = pickedNumbers.getOpponentNumberList();
        List<Integer> playerNumberList = pickedNumbers.getPlayerNumberList();
        calculateStrikeScore(opponentNumberList,playerNumberList);
        calculateBallScore(opponentNumberList,playerNumberList);
    }

    private void calculateStrikeScore(List<Integer> opponentNumberList,
        List<Integer> playerNumberList) {
        for (int i = 0; i < ConsoleNumberSizeEnum.MAX_SIZE.getSize(); i++) {
            if (opponentNumberList.get(i).equals(playerNumberList.get(i))) {
                scoreResult.addStrike();
            }
        }
    }

    private void calculateBallScore(List<Integer> opponentNumberList,
        List<Integer> playerNumberList) {
        for (int i = 0; i < ConsoleNumberSizeEnum.MAX_SIZE.getSize(); i++) {
            for (int j = 0; j < ConsoleNumberSizeEnum.MAX_SIZE.getSize(); j++) {
                if (!opponentNumberList.get(i).equals(playerNumberList.get(i))) {
                    if (opponentNumberList.get(i).equals(playerNumberList.get(j))) {
                        scoreResult.addBall();
                    }
                }
            }
        }
    }

    public ScoreResult getScoreResult() {
        return scoreResult;
    }
}
