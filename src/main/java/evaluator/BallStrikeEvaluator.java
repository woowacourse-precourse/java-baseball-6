package evaluator;

import java.util.List;
import number.ComputerNumber;
import number.PlayerNumber;

public class BallStrikeEvaluator {

    private int ballCount;

    private int strikeCount;

    public BallStrikeEvaluator() {
        this.ballCount = 0;
        this.strikeCount = 0;
    }

    public void evaluate(ComputerNumber computerNumber, PlayerNumber playerNumber) {
        List<Integer> computerNumberList = computerNumber.getComputerNumber();
        List<Integer> playerNumberList = playerNumber.getPlayerNumber();

        for (Integer playerEachNumber : playerNumberList) {
            int playerIdx = playerNumberList.indexOf(playerEachNumber);
            int computerIdx = computerNumberList.indexOf(playerEachNumber);
            checkBallStrike(computerIdx, playerIdx);
        }
    }

    private void checkBallStrike(int computerIdx, int playerIdx) {
        if(computerIdx != -1) {
            if(computerIdx == playerIdx) {
                this.strikeCount++;
            }
            if (computerIdx != playerIdx) {
                this.ballCount++;
            }
        }
    }

    public int getBallCount() {
        return this.ballCount;
    }

    public int getStrikeCount() {
        return this.strikeCount;
    }
}
